
```bash
# 
-XX:+PrintGCDetails  #-XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead. 
-Xlog:gc*


# Using in jdk1.8
-Xms<heap size>[unit]  # 设置 JVM 初始堆大小
-Xmx<heap size>[unit]  # 设置 JVM 最大堆大小

-XX:NewSize=<young size>[unit]    # 设置新生代初始大小
-XX:MaxNewSize=<young size>[unit] # 设置新生代最大大小

-Xmn512m

-XX:NewRatio=2 # 默认值）表示老年代 : 新生代 = 2 : 1。即新生代占整个堆大小的 1/3。

-XX:MetaspaceSize=N #设置 Metaspace 的初始大小（是一个常见的误区，后面会解释）
-XX:MaxMetaspaceSize=N #设置 Metaspace 的最大大小

# 在发生 OOM 时生成堆转储文件
-XX:+HeapDumpOnOutOfMemoryError

# 指定堆转储文件的输出路径。<pid> 会被替换为进程 ID
-XX:HeapDumpPath=/path/to/heapdump/java_pid<pid>.hprof
# 示例：-XX:HeapDumpPath=/data/dumps/

# (可选) 在发生 OOM 时执行指定的命令或脚本
# 例如，发送告警通知或尝试重启服务（需谨慎使用）
# -XX:OnOutOfMemoryError="<command> <args>"
# 示例：-XX:OnOutOfMemoryError="sh /path/to/notify.sh"

# (可选) 启用 GC 开销限制检查
# 如果 GC 时间占总时间比例过高（默认 98%）且回收效果甚微（默认小于 2% 堆内存），
# 会提前抛出 OOM，防止应用长时间卡死在 GC 中。
-XX:+UseGCOverheadLimit
```