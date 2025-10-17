package map;

/**
 * @program: JavaAlgorithmsLife
 * @description: 岛屿数量
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 *   = 3个岛
 * @author: dave
 * @create: 2025/10/16 13:11
 **/
public class NO_200_number_ofisland_mid {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    /**
     * 方法1 深度有限搜索
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0) {
            return 0;
        }
        int nums =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //找到1，启动深度有限搜索，搜索到的全部置0
                if (grid[i][j] =='1'){
                    //找到一个岛，把这个岛周围的1全部设置成0
                    nums++;
                    dfs(grid,i,j);
                }
            }
        }
        return nums;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i>= grid.length || j >= grid[0].length || i<0 || j< 0){
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1'){
            grid[i][j]='0';
        }
        //不漏掉任何一个1的方向
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

}


