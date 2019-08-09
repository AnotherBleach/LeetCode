package BinaryTree;
import java.util.Scanner;

public class Main {
    static int num = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] hasGet = new boolean[m][n];
        to(0,0,m,n,k,hasGet);
        System.out.println(num);
    }

    static void to(int x,int y,int m,int n,int k,boolean[][] visited){
        if(!isVaild(x,y,m,n,k,visited))
            return;
        to(x-1,y,m,n,k,visited);
        to(x+1,y,m,n,k,visited);
        to(x,y-1,m,n,k,visited);
        to(x,y+1,m,n,k,visited);
        return;
    }
    static boolean isVaild(int x,int y,int m,int n,int k,boolean[][] visited){
        if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==false && canTo(x,y,k)){
            num++;
            visited[x][y] = true;
            return true;
        }else{
            return false;
        }

    }
    static boolean canTo(int x,int y,int k){
        int sum = 0;
        while(x!=0){
            int x1 = x%10;
            x = x/10;
            sum = sum+x1;
        }
        while(y!=0){
            int y1 = y%10;
            y = y/10;
            sum = sum+y1;
        }
        if(sum>k){
            return false;
        }
        return true;
    }
}