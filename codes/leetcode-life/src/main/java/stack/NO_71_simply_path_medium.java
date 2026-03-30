package stack;

import java.util.*;

/**
 * 问题类型：
 * 栈的问题：数据结构的特点和使用
 * <p>
 * Description
 * 简化路径
 *
 * @author dave
 * @since 2021/2/18 22:06
 */
public class NO_71_simply_path_medium {
    public static void main(String[] args) {
        String input = "/home/my//../";
        String ret = simplifyPath(input);
        System.out.println("\nResutl:" + ret);
    }

    /**
     * 方法1： 
     * 栈的使用
     * . .. / // /// 两种特殊场景
     * . 当前目录
     * .. 上级目录
     * / 根目录，目录
     * 
     * @param path
     * @return
     */
        public static String simplifyPath(String path) {
            if (path == null) {
                return "";
            }
            // first: handle the //,simplify the // to /
            path = path.replaceAll("//", "/");
            // 2nd: handle the end of /
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            //3nd: split the path by /
            String[] parts = path.split("/");
            //4th: handle the . and ..
            Stack<String> stack = new Stack<>();
            for(int i = 0; i < parts.length; i++) {
                if (parts[i].isEmpty()) {
                    continue;
                }
               if (parts[i].equals(".")) {
                 continue;
               }
               else if (parts[i].equals("..")) {
                 if (!stack.isEmpty()) {
                     stack.pop();
                 }
               }
               else {
                   stack.push(parts[i]);
               }
            }
            //5nd: join the stack
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, "/" + stack.pop());
            }

            if (sb.length() == 0) {
                return "/";
            }
            return sb.toString();
        }
   
}
