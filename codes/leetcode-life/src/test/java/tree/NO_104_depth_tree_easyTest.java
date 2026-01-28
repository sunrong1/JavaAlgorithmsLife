package tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for NO_104_depth_tree_easy class
 * Tests the maxDepth2 method which calculates the maximum depth of a binary tree
 * using recursive DFS approach.
 */
class NO_104_depth_tree_easyTest {

    /**
     * Test case: Empty tree (null root)
     * Expected: depth = 0
     */
    @Test
    @DisplayName("Test empty tree - should return 0")
    void testEmptyTree() {
        TreeNode root = null;
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(0, result, "Empty tree should have depth 0");
    }

    /**
     * Test case: Single node tree (root only)
     * Expected: depth = 1
     */
    @Test
    @DisplayName("Test single node tree - should return 1")
    void testSingleTreeNode() {
        TreeNode root = new TreeNode(1);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(1, result, "Single node tree should have depth 1");
    }

    /**
     * Test case: Two-level tree with only left child
     * Tree structure:
     *     1
     *    /
     *   2
     * Expected: depth = 2
     */
    @Test
    @DisplayName("Test two-level tree with left child only")
    void testTwoLevelTreeWithLeftChild() {
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(2, result, "Two-level tree should have depth 2");
    }

    /**
     * Test case: Two-level tree with only right child
     * Tree structure:
     *     1
     *      \
     *       2
     * Expected: depth = 2
     */
    @Test
    @DisplayName("Test two-level tree with right child only")
    void testTwoLevelTreeWithRightChild() {
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(2, result, "Two-level tree should have depth 2");
    }

    /**
     * Test case: Two-level complete tree
     * Tree structure:
     *     1
     *    / \
     *   2   3
     * Expected: depth = 2
     */
    @Test
    @DisplayName("Test two-level complete tree")
    void testTwoLevelCompleteTree() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(2, result, "Two-level complete tree should have depth 2");
    }

    /**
     * Test case: Three-level tree (skewed to the right)
     * Tree structure:
     *       1
     *        \
     *         2
     *          \
     *           3
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test three-level right-skewed tree")
    void testThreeLevelRightSkewedTree() {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode root = new TreeNode(1, null, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Three-level right-skewed tree should have depth 3");
    }

    /**
     * Test case: Three-level tree (skewed to the left)
     * Tree structure:
     *     3
     *    /
     *   2
     *  /
     * 1
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test three-level left-skewed tree")
    void testThreeLevelLeftSkewedTree() {
        TreeNode level1 = new TreeNode(1);
        TreeNode level2 = new TreeNode(2, level1, null);
        TreeNode root = new TreeNode(3, level2, null);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Three-level left-skewed tree should have depth 3");
    }

    /**
     * Test case: Three-level complete tree
     * Tree structure:
     *       1
     *      / \
     *     2   3
     *    /
     *   4
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test three-level tree with left-left branch")
    void testThreeLevelTreeWithLeftLeftBranch() {
        TreeNode leaf = new TreeNode(4);
        TreeNode left = new TreeNode(2, leaf, null);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Three-level tree should have depth 3");
    }

    /**
     * Test case: Three-level complete tree
     * Tree structure:
     *       1
     *      / \
     *     2   3
     *        / \
     *       4   5
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test three-level complete tree")
    void testThreeLevelCompleteTree() {
        TreeNode level2Left = new TreeNode(4);
        TreeNode level2Right = new TreeNode(5);
        TreeNode right = new TreeNode(3, level2Left, level2Right);
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Three-level complete tree should have depth 3");
    }

    /**
     * Test case: Four-level tree
     * Tree structure:
     *         1
     *        / \
     *       2   3
     *      /     \
     *     4       5
     *    /
     *   6
     * Expected: depth = 4
     */
    @Test
    @DisplayName("Test four-level tree")
    void testFourLevelTree() {
        TreeNode leaf = new TreeNode(6);
        TreeNode level2Left = new TreeNode(4, leaf, null);
        TreeNode level2Right = new TreeNode(5);
        TreeNode left = new TreeNode(2, level2Left, null);
        TreeNode right = new TreeNode(3, null, level2Right);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(4, result, "Four-level tree should have depth 4");
    }

    /**
     * Test case: Balanced binary tree with 4 levels
     * Tree structure:
     *          1
     *        /   \
     *       2     3
     *      / \   / \
     *     4   5 6   7
     *    /
     *   8
     * Expected: depth = 4
     */
    @Test
    @DisplayName("Test balanced binary tree with 4 levels")
    void testBalancedTreeFourLevels() {
        TreeNode leaf = new TreeNode(8);
        TreeNode level2Left = new TreeNode(4, leaf, null);
        TreeNode level2Right = new TreeNode(5);
        TreeNode left = new TreeNode(2, level2Left, level2Right);
        TreeNode level2LeftRight = new TreeNode(6);
        TreeNode level2RightRight = new TreeNode(7);
        TreeNode right = new TreeNode(3, level2LeftRight, level2RightRight);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(4, result, "Balanced tree with 4 levels should have depth 4");
    }

    /**
     * Test case: Deep tree with 5 levels
     * Tree structure:
     *         1
     *          \
     *           2
     *            \
     *             3
     *              \
     *               4
     *                \
     *                 5
     * Expected: depth = 5
     */
    @Test
    @DisplayName("Test deep tree with 5 levels")
    void testDeepTreeFiveLevels() {
        TreeNode level4 = new TreeNode(5);
        TreeNode level3 = new TreeNode(4, null, level4);
        TreeNode level2 = new TreeNode(3, null, level3);
        TreeNode level1 = new TreeNode(2, null, level2);
        TreeNode root = new TreeNode(1, null, level1);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(5, result, "Deep tree with 5 levels should have depth 5");
    }

    /**
     * Test case: Tree with negative values
     * Tree structure:
     *        -1
     *       /   \
     *     -2    -3
     *    /
     *  -4
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test tree with negative values")
    void testTreeWithNegativeValues() {
        TreeNode leaf = new TreeNode(-4);
        TreeNode left = new TreeNode(-2, leaf, null);
        TreeNode right = new TreeNode(-3);
        TreeNode root = new TreeNode(-1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Tree with negative values should have depth 3");
    }

    /**
     * Test case: Tree with zero values
     * Tree structure:
     *       0
     *      / \
     *     0   0
     * Expected: depth = 2
     */
    @Test
    @DisplayName("Test tree with zero values")
    void testTreeWithZeroValues() {
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        TreeNode root = new TreeNode(0, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(2, result, "Tree with zero values should have depth 2");
    }

    /**
     * Test case: Large values in tree
     * Tree structure:
     *         1000
     *        /    \
     *      2000  3000
     *     /
     *   4000
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test tree with large values")
    void testTreeWithLargeValues() {
        TreeNode leaf = new TreeNode(4000);
        TreeNode left = new TreeNode(2000, leaf, null);
        TreeNode right = new TreeNode(3000);
        TreeNode root = new TreeNode(1000, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Tree with large values should have depth 3");
    }

    /**
     * Test case: Perfect binary tree with 3 levels
     * Tree structure:
     *         1
     *       /   \
     *      2     3
     *     / \   / \
     *    4   5 6   7
     * Expected: depth = 3
     */
    @Test
    @DisplayName("Test perfect binary tree with 3 levels")
    void testPerfectBinaryTreeThreeLevels() {
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(3, rightLeft, rightRight);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(3, result, "Perfect binary tree with 3 levels should have depth 3");
    }

    /**
     * Test case: Asymmetric tree
     * Tree structure:
     *         1
     *       /   \
     *      2     3
     *     / \     \
     *    4   5     6
     *   /
     *  7
     * Expected: depth = 4
     */
    @Test
    @DisplayName("Test asymmetric tree")
    void testAsymmetricTree() {
        TreeNode leaf = new TreeNode(7);
        TreeNode leftLeft = new TreeNode(4, leaf, null);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightRight = new TreeNode(6);
        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(3, null, rightRight);
        TreeNode root = new TreeNode(1, left, right);
        int result = NO_104_depth_tree_easy.maxDepth2(root);
        assertEquals(4, result, "Asymmetric tree should have depth 4");
    }
}
