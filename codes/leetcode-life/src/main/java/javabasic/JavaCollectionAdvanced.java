package javabasic;

/**
 * 问题类型：
 * ..问题
 * <p>
 * Description
 *
 * @author dave
 * @since 2021/2/22 21:35
 */
public class JavaCollectionAdvanced {
    protected static class Student {
        public String name;
        public int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public Student() {
            super();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
