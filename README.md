## 日志等级
![图片](https://images.soboys.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTgwMTE5MDE0NTU1Mjk3.png)

图片上是比较常用的日志等级实际定义了8个级别的log（除去OFF和ALL，可以说分为6个级别），优先级从高到低依次为：OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。在日志记录中比当前日志等级高的日志都会进行打印
**ALL** 最低等级的，用于打开所有日志记录。


## logback配置
在项目中使用logback时，它会默认在项目的classpath路径下按顺序查找名为logback-test.xml、logback.groovy、logback.xml的文件，如果上述文件均未找到，则使用默认配置（debug级别）将日志输出到控制台。


