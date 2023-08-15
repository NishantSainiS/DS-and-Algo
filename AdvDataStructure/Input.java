package ;

import java.util.Scanner;

public class Input {
    public static void main(String args[]){
        int r,c;
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        int array[][] = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                array[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
