import java.util.Scanner;

public class Alfie {
    static int paths;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int i = 0; i<testCases;i++){
            int N = sc.nextInt();
            sc.nextLine();
            String multiArr[][] = new String[N][N];
            boolean visited[][] = new boolean[N][N];
            for(int j=0;j<N;j++){
                String[] arr = sc.nextLine().split(" ");
                for(int k = 0; k< N ;k++){
                    multiArr[j][k] = arr[k];
                }
            }
           int routes =  checkPath(0,0,multiArr,N,visited);
            System.out.println(routes);

        }
    }

    public static int checkPath(int x,int y,String[][] multi,int N,boolean[][] visited){
        if((x==N-1 && y==N-1))
            if(multi[x][y].equals("0")){
                paths++;
                return paths;
            }
        visited[x][y] = true;
        //check left
        if((x>=0 && y>=0) && (x!=N && y!=N) && !multi[x][y].equals("1")) {

            if(x+1<N && !visited[x+1][y])
                checkPath(x + 1, y, multi, N,visited);
            if(y+1<N && !visited[x][y+1])
                checkPath(x, y + 1, multi, N,visited);
            if(x-1>=0 && !visited[x-1][y])
                checkPath(x - 1, y, multi, N,visited);
            if(y-1 >=0 && !visited[x][y-1])
                checkPath(x, y - 1, multi, N,visited);
        }

        visited[x][y] = false;

        return paths;

    }
}
