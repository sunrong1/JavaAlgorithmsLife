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
        System.out.println(numIslands2(grid));
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

    /**
     * 方法2 并查集 merge
     * 
     * @date 2026/4/11 13:41
     * @param grid
     * @return
     */
    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // the num of islands
        int nums = 0;
        // first,init union find
        int rows = grid.length;
        int cols = grid[0].length;
        int[] parent = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // 初始化并查集父节点,指向自己的位置
                    parent[i * cols + j] = i * cols + j;
                    nums++;
                }
            }
        }
        // second,merge
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int index = i * cols + j;
                    // the right is land,merge
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        if (merge(parent, index, index + 1)) {
                            nums--;
                        }
                    }

                    // the bottom is land,merge
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        if (merge(parent, index, index + cols)) {
                            nums--;
                        }
                    }
                }
            }
        }
        return nums;
    }

    public static boolean merge(int[] parent, int index1, int index2) {
        int root1 = find(parent, index1);
        int root2 = find(parent, index2);
        if (root1 != root2) {
            parent[root1] = root2;
            return true;
        }
        return false;
    }

    private static int find(int[] parent, int index2) {
        // 找到根节点,index 和自己相等，才是根节点！！
        while (parent[index2] != index2) {
            index2 = parent[index2];
        }
        return index2;
    }
}

