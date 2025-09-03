
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class box {

    private static  class Cell{
        int row,col,steps;
        Cell(int r,int c,int s){
            this.row=r;
            this.col=c;
            this.steps=s;
        }
    }

    private  static int minMoves(int[][] grid,int[] source,int[] dest,int[] moveRule){
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();
        
      if (grid[source[0]][source[1]] == 1 || grid[dest[0]][dest[1]] == 1){
    	return -1;
       }

        q.add(new Cell(source[0],source[1],0));

        visited[source[0]][source[1]]=true;

        int[][] direction = {
            {moveRule[0],moveRule[1]},
            {moveRule[1],-moveRule[0]},
            {-moveRule[1],moveRule[0]},
            {-moveRule[0],-moveRule[1]}
        };

        while(!q.isEmpty()){
            Cell curr = q.poll();
            if(curr.row==dest[0] && curr.col== dest[1]){
                return curr.steps;
            }

            for(int[] dir: direction){
                int newRow = curr.row+dir[0];
                int newCol = curr.col+dir[1];
                if(newRow>=0&&newCol>=0&&newRow<m&&newCol<n&&
                grid[newRow][newCol]==0 && !visited[newRow][newCol]){
                    visited[newRow][newCol]=true;
                    q.add(new Cell(newRow,newCol,curr.steps+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int[] source = {sc.nextInt(),sc.nextInt()};
        int[] dest = {sc.nextInt(),sc.nextInt()};
        int[] moveRule = {sc.nextInt(),sc.nextInt()};

        int minMove = minMoves(grid,source,dest,moveRule);

        System.out.println(minMove);
    }
}
