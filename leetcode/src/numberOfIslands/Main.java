package numberOfIslands;

public class Main {
    public static void main(String[] args) {
        char[][] grid;
        grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};


        System.out.println(numIslands(grid));

    }

    public  static int numIslands(char[][] grid) {
        int result=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]=='1'){
                    result++;
                    exploreIsland(grid,i,j);
                }

            }
        }


        return result;
    }

    public static void exploreIsland(char[][] grid,int i,int j){
        grid[i][j]='#';

        //check top
        if(i>0 && grid[i-1][j]=='1')
            exploreIsland(grid,i-1,j);

        //check bottom
        if(i< grid.length-1 && grid[i+1][j]=='1')
            exploreIsland(grid,i+1,j);

        //check left
        if(j>0 && grid[i][j-1]=='1')
            exploreIsland(grid,i,j-1);

        //check right
        if(j<grid[i].length-1 && grid[i][j+1]=='1')
            exploreIsland(grid,i,j+1);


    }

}
