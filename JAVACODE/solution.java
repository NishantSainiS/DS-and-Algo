package JAVACODE;

class GFG
{

	// Max tree size
	final static int MAX = 1000;

	static int BITree[] = new int[MAX];

	// Updates a node in Binary Index
	// Tree (BITree) at given index
	// in BITree. The given value 'val'
	// is added to BITree[i] and
	// all of its ancestors in tree.
	public static void updateBIT(int n,
								int index,
								int val)
	{
		// index in BITree[] is 1
		// more than the index in arr[]
		index = index + 1;

		// Traverse all ancestors
		// and add 'val'
		while (index <= n)
		{
			// Add 'val' to current
			// node of BITree
			BITree[index] += val;

			// Update index to that
			// of parent in update View
			index += index & (-index);
		}
	}

	// Constructs Binary Indexed Tree
	// for given array of size n.

	public static void constructBITree(int arr[],
									int n)
	{
		// Initialize BITree[] as 0
		for(int i = 1; i <= n; i++)
			BITree[i] = 0;

		// Store the actual values
		// in BITree[] using update()
		for(int i = 0; i < n; i++)
			updateBIT(n, i, arr[i]);

		// Uncomment below lines to
		// see contents of BITree[]
		// for (int i=1; i<=n; i++)
		//	 cout << BITree[i] << " ";
	}

	// SERVES THE PURPOSE OF getElement()
	// Returns sum of arr[0..index]. This
	// function assumes that the array is
	// preprocessed and partial sums of
	// array elements are stored in BITree[]
	public static int getSum(int index)
	{
		int sum = 0; //Initialize result

		// index in BITree[] is 1 more
		// than the index in arr[]
		index = index + 1;

		// Traverse ancestors
		// of BITree[index]
		while (index > 0)
		{

			// Add current element
			// of BITree to sum
			sum += BITree[index];

			// Move index to parent
			// node in getSum View
			index -= index & (-index);
		}

		// Return the sum
		return sum;
	}

	// Updates such that getElement()
	// gets an increased value when
	// queried from l to r.
	public static void update(int l, int r,
							int n, int val)
	{
		// Increase value at
		// 'l' by 'val'
		updateBIT(n, l, val);

		// Decrease value at
		// 'r+1' by 'val'
		updateBIT(n, r + 1, -val);
	}


	// Driver Code
	public static void main(String args[])
	{
		int arr[] = {0, 0, 0, 0, 0};
		int n = arr.length;

		constructBITree(arr,n);

		// Add 2 to all the
		// element from [2,4]
		int l = 2, r = 4, val = 2;
		update(l, r, n, val);

		int index = 4;

		System.out.println("Element at index "+
								index + " is "+
								getSum(index));

		// Add 2 to all the
		// element from [0,3]
		l = 0; r = 3; val = 4;
		update(l, r, n, val);

		// Find the element
		// at Index 3
		index = 3;
		System.out.println("Element at index "+
								index + " is "+
								getSum(index));
	}
}
// This code is contributed
// by Puneet Kumar.
