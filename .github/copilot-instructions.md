# Copilot Instructions for JavaAlgorithmsLife

## Project Overview
**Purpose:** LeetCode solution repository for data structures & algorithms in Java with learning focus.

**Structure:** 
- `codes/leetcode-life/src/main/java/` contains solutions organized by data type: `array/`, `linkedList/`, `tree/`, `stack/`, `queue/`, `heap/`, `hash/`, `map/`, `sort/`, `string/`, `math/`, `find/`
- Shared utilities: `util/ArrayUtil.java` for array operations; node classes `ListNode.java`, `TreeNode.java` in respective folders
- Each solution file: `NO_<problemNumber>_<englishTitle>_<difficulty>.java` (e.g., `NO_1_two_sum_easy.java`)

**Tech Stack:** Java (JDK 17 per pom.xml), Maven, standard library only—no third-party dependencies except Maven itself.

## Development Workflow

**Build & Run:**
```bash
mvn clean compile                    # Build the project
cd codes/leetcode-life && mvn clean compile
```

**Code Structure:** Each problem class typically contains:
1. A `main()` method with hardcoded test cases (direct input/output to stdout)
2. Multiple solution methods showing different approaches (e.g., `addTowSum`, `addTowSum2`, `addTowSum3` for variations like brute-force vs. hashmap)
3. Method naming reflects the algorithm approach: `addTowSum2` indicates the 2nd solution variant

**Example:** [NO_1_two_sum_easy.java](codes/leetcode-life/src/main/java/array/NO_1_two_sum_easy.java) demonstrates brute-force, hashmap, and store-complement approaches with the main() acting as test harness.

## Coding Conventions

**Comment Template** (from `docs/intellij-best-practice.md`):
```java
/**
 * 问题类型: <algorithm/pattern name>
 * Description: <problem statement>
 * 
 * @author <name>
 * @since <date>
 */
```

**Code Style:** Follows Alibaba Java Coding Guidelines with JDK 17. Use IntelliJ IDEA shortcuts for consistent formatting (Ctrl+Alt+L for reformat).

**Multiple Solutions Pattern:**
- Number methods sequentially: `solve()`, `solve2()`, `solve3()`
- Comment each with complexity analysis (when non-trivial)
- All methods tested in single main() call for side-by-side comparison

**Data Structure Reuse:**
- `ListNode` class (in [linkedList/](codes/leetcode-life/src/main/java/linkedList/)) for all linked list problems
- Use dummy nodes to simplify head deletion in linked list operations
- Import shared utilities: `import util.ArrayUtil;` for print/display helpers

## IDE & Debugging Guidance
- Open in IntelliJ IDEA; run/debug any main() method directly via IDE
- Key shortcuts: F5 (debug), F10 (step over), F11 (step into)
- Save Action plugin auto-formats on save; Alibaba Java Coding Guidelines plugin validates code style

## Key File References
- [pom.xml](codes/leetcode-life/pom.xml): Maven build with JDK 17 compiler config
- [ArrayUtil.java](codes/leetcode-life/src/main/java/util/ArrayUtil.java): Print helpers (e.g., `printIntListList()`)
- [docs/intellij-best-practice.md](docs/intellij-best-practice.md): Detailed IDE setup and comment conventions
- [README.md](README.md): Project motivation and resources

## Common Patterns & Tips
- **Sorting for optimization:** Pre-sort arrays to enable two-pointer or greedy solutions (e.g., 3Sum)
- **Dummy nodes:** Useful in linked list operations to unify head/body deletion logic
- **Layer-order traversal (BFS):** Use `Stack<TreeNode>` or `Queue<TreeNode>` for level-based tree traversal
- **HashMap deduplication:** Standard for reducing time complexity in hash-heavy problems
- **No unit tests:** Solutions prioritize clarity and algorithm exposition over formal test coverage

## Notes for AI Agents
- When adding new solutions, follow `NO_<number>_<title>_<difficulty>.java` naming exactly
- Ensure all solutions have hardcoded main() test cases—no JUnit expected
- Import `util.ArrayUtil` and common node classes; they are pre-defined and reusable
- When implementing complex structures, check if `ListNode.java` or `TreeNode.java` exist first to reuse
- Code should be readable first; optimize only when problem constraints demand it
