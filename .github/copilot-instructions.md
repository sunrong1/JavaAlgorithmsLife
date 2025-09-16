# Copilot Instructions for JavaAlgorithmsLife

## 项目架构概览
- 本仓库聚焦于数据结构与算法题解，采用 Java 语言，目录结构以算法类型（如 array、linkedList、tree 等）为主线，便于分类检索与复用。
- 每类算法/数据结构对应一个文件夹，文件命名以 LeetCode 题号+题目英文+难度标识（如 `NO_1_two_sum_easy.java`），便于快速定位。
- 代码风格遵循 Alibaba Java Coding Guidelines，JDK 版本为 1.8。
- 主要代码位于 `codes/leetcode-life/src/main/java/` 下，按模块细分（如 `array/`, `linkedList/`, `tree/` 等）。
- 公共工具类如 `ArrayUtil.java`、链表/树节点定义如 `ListNode.java`、`TreeNode.java` 统一放在对应模块或 `util/` 目录。

## 关键开发流程
- 构建与运行：使用 Maven 管理，主模块 `pom.xml` 已配置 JDK 1.8。常用命令：
  - 构建：`mvn clean compile`
  - 运行（如有 main 方法）：可直接在 IDE（推荐 Intellij IDEA）运行，或用 `mvn exec:java`（需配置 mainClass）。
- 代码调试：推荐在 Intellij IDEA 下逐步调试，配合注释与断点。
- 题解类一般包含 main 方法用于本地测试，输入输出直接在 main 中硬编码。
- 代码注释采用统一模板，见 `docs/intellij-best-practice.md`。

## 项目约定与模式
- 文件命名规范：`NO_<题号>_<题目英文>_<难度>.java`，如 `NO_206_reverse_linkedlist_easy.java`。
- 每个题解类通常包含多种解法（如暴力、哈希、双指针等），方法名体现解法思路（如 `addTowSum`、`addTowSum2`）。
- 复杂结构（如链表、树）统一使用自定义节点类（如 `ListNode`、`TreeNode`），便于复用。
- 代码注释需包含问题描述、解题思路、作者与时间。
- 参考资料与学习心得见 `README.md`、`docs/how-to-learn-Algorithm.md`。

## 重要文件与目录
- `codes/leetcode-life/pom.xml`：Maven 构建配置。
- `codes/leetcode-life/src/main/java/`：主代码目录。
- `docs/intellij-best-practice.md`：IDE 配置与注释规范。
- `README.md`：项目介绍与参考资料。

## 其他说明
- 题解代码以可读性和算法思路为主，未强制覆盖单元测试。
- 主要依赖标准 Java 库，无额外第三方依赖。
- 贡献新题解时请遵循现有命名、注释和结构规范。

---
如需补充或澄清，请在下方留言。
