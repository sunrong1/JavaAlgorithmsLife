# intellij 最佳实践

## 常用快捷键

快捷键大幅提升编码效率和体验；当然好的键盘也很重要；写的顺心，当然效率很高。
ps：经常有输入法、有道词典、显卡等快捷键的配置和intellij冲突，注意消除

### 查找替换

- ctrl + shift + f：全局查找
- ctrl + shift + r：全局替换
- ctrl + f:当前文件查找
- ctrl + r:当前文件替换


### 快速编辑
- ctrl + x ：剪切当前行/删除
- ctrl + d ：直接复制当前行

- F2 ：修改变量名（需要修改Intellij的默认配置）
### 代码浏览
- ctrl + shift + 左右箭头 : 历史代码
- ctrl + 鼠标点击：转到
- ctrl + e：最近编辑的文件

### 代码注释格式

- 文件（Class）的Head注释 file and code template 中增加file Header

````yaml
/**
 * Description
 * 
 * @author dave
 * @since ${DATE} ${TIME}
 */

````

- 函数的注释 Intellij 的默认注释，快捷键 /** + 回车 键默认不错

### 调试
习惯了VS的快捷方法，把他修改成和VS一样了
- F5 : 启动调试
- F10 ：逐步运行
- F11 : 进入方法内调试

## 代码格式

### 插件

- save action 保存后，进行格式优化，import优化等操作；
- Alibaba Java Coding Guidelines 阿里的Java代码编程规范







