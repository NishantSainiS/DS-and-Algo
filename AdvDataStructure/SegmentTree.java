package AdvDataStructure;

import java.util.Arrays;

class SegmentTree {
    int[] tree;
    int size;
    SegmentTree(int[] array) {
        size = array.length;
        tree = new int[4 * size];
        buildTree(array, 0, 0, size - 1);
    }

    private void buildTree(int[] array, int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = array[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(array, 2 * treeIndex + 1, left, mid);
        buildTree(array, 2 * treeIndex + 2, mid + 1, right);
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }
    int getSum(int n, int queryStart, int queryEnd){
        // Check for erroneous input values
        if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, queryStart, queryEnd, 0);
    }
    int getSumUtil(int arrayStart, int arrayEnd, int queryStart, int queryEnd, int treeIndex){
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (queryStart <= arrayStart && arrayEnd <= queryEnd)
            return tree[treeIndex];
        // If segment of this node is outside the given range
        if (arrayEnd < queryStart || arrayStart > queryEnd)
            return 0;
        // If a part of this segment overlaps with the given range
        int mid = getMid(arrayStart, arrayEnd);
        return getSumUtil(arrayStart, mid, queryStart, queryEnd, 2 * treeIndex + 1) + getSumUtil(mid + 1, arrayEnd, queryStart, queryEnd, 2 * treeIndex + 2);
    }
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    void updateValue(int[] arr, int n, int i, int new_val){
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        // Get the difference between new value and old value
        int diff = new_val - arr[i];
        // Update the value in array
        arr[i] = new_val;
        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }
    void updateValueUtil(int arrayStart, int arrayEnd, int i, int diff, int treeIndex){
        // Base Case: If the input index lies outside the range of this segment
        if (i < arrayStart || arrayEnd < i) return;
        // If the input index is in range of this node, then update the value of the node and its children
        tree[treeIndex] = tree[treeIndex] + diff;
        if (arrayEnd != arrayStart) {
            int mid = getMid(arrayStart, arrayEnd);
            updateValueUtil(arrayStart, mid, i, diff, 2 * treeIndex + 1);
            updateValueUtil(mid + 1, arrayEnd, i, diff, 2 * treeIndex + 2);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 6};
        SegmentTree tree = new SegmentTree(array);
        int n = array.length;
        System.out.println("Sum of values in given range = " +tree.getSum(n, 1, 3));
        tree.updateValue(array, n, 1, 10);
        System.out.println("Updated sum of values in given range = " +tree.getSum(n, 1, 3));
    }
}
