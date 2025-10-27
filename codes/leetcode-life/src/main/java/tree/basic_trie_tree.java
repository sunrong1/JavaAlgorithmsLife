package tree;

/**
 * @program: JavaAlgorithmsLife
 * @description: 字典树,华为面试题
 * @author: dave
 * @create: 2025/10/24 12:51
 **/
public class basic_trie_tree {
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "apple";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith("app");
    }

    static class Trie {

        //孩子节点
        private Trie[] children;

        //是否尾节点，默认部署尾部节点
        private boolean isEnd;
        public Trie() {
            //初始化26个字母的孩子节点
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) -'a';
                if (node.children[index] == null){
                    //没有匹配上，不存在，需要插入
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /**
         * 第一步：看查询的方式
         * @param word
         * @return
         */
        public boolean search(String word) {
            //可以找到当前节点，且是尾部节点
            Trie  node = SearchPrefix(word);
            return node != null && node.isEnd;
        }

        private Trie SearchPrefix(String word) {
            Trie node  = this;//创建初始化指针
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i)-'a';
                if (node.children[index] != null) {
                    //匹配，继续搜索
                    node = node.children[index];
                }
                else {
                    return null;
                }
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            Trie node = SearchPrefix(prefix);
            return node !=null;
        }
    }

}
