# 学习笔记

[TOC]

## Maven

Maven是一个项目管理和构建的工具，帮助开发者管理项目、构建项目、发布项目。

`pom`是Maven的核心，`pom`代表工程对象模型，它是使用Maven工作时的基本组件，是一个XML文件，存放在工程根目录。

`pom.xml`包含了关于工程和各配置细节的信息，Maven使用这些信息构建工程。

`pom.xml`是可以继承的，继承其他父工程使用`<parent></parent>`标签。

`pom.xml`将项目的依赖项都定义在`<dependencies>`和`<dependency>`标签对中。

坐标：Maven引用依赖是通过坐标来实现的。

- `groupId`：工程组标识，通常是唯一的。
- `artifactId`：工程标识，通常是工程的名称。`groupId`和`artifactId`共同定义了仓库中的位置。
- `version`：工程版本号，用于版本控制。

Maven常用命令：

- `mvn -v`：查看版本
- `mvn compile`：编译，将Java源文件编译成`.class`文件
- `mvn test`：执行`test`目录下的测试用例
- `mvn package`：打包，将Java工程打成JAR包
- `mvn clean`：清理环境，清除`target`文件夹
- `mvn install`：安装，将当前项目安装到Maven本地仓库中

传递依赖：如果项目中引用了JAR包（Maven中称为直接引用），而该JAR包又引用了其他JAR包（Maven中称为间接引用），那么，默认情况下，项目编译时，Maven会把直接引用和间接引用的JAR包都下载到本地仓库。

排除依赖：如果只想下载直接引用的JAR包，则需要排除间接引用的JAR包。

依赖冲突：项目中多个JAR包引用了相同的JAR包时会产生依赖冲突。

Maven避免依赖冲突的两种策略：

- 短路优先：`本项目 -> A.jar -> B.jar -> X.jar`、`本项目 -> C.jar -> X.jar`
- 声明优先：若引用路径长度相同时，在`pom.xml`中谁先声明谁优先使用。

Maven聚合模块：

- 父模块`pom.xml`的`packaging`类型必须是`pom`
- 聚合子模块使用`<modules>`和`<module>`标签对
- 父模块使用`<dependencyManagement>`标签统一管理依赖包版本
- 子模块需要在`pom.xml`中使用`<parent>`标签声明子模块继承父模块。

## Redis

Redis支持的常用数据类型：

- `string`：最基本存储，二进制方式存储（可以存储任何类型数据），单个字符串上限是1GB
- `list`：双向链表，也可以作为栈、队列
- `hash`：字典
- `set`：集合
- `sortedset`：有序集合

Redis特性：

- 所有操作都是原子性的
- 以K-V形式存储，V可以是多种数据类型
- key可以设置过期时间，有定时删除（定时删除键，主动策略）、定期删除（定时检查是否有过期键，主动策略）、惰性删除（使用前先检查是否过期，被动策略）
- 支持两种持久化方式：RDB（快照、默认）、AOF
    - RDB保存数据
    - AOF保存命令
    - RDB恢复数据比AOF快
    - RDB保存时间间隔过大的情况下可能会丢失数据，推荐使用AOF方式

Redis高性能的原因：

- 完成基于内存
- 数据结构简单
- 单线程，没有线程切换的开销
- 多路I/O复用模型

使用Redis需要注意的问题：

- 缓存穿透：缓存穿透是指查询一个不存在的数据，但是由于Cache不命中，又需要去DB查询，造成系统性能下降。
    - 解决方案：给没有命中的key设定“没有意义的空值”
- 缓存雪崩：缓存雪崩是指Cache设置了相同的过期时间，导致Cache在同一时间失效，请求全部转发到DB，DB的瞬时压力过大，造成雪崩。
    - 解决方案：给key设定不同的（随机的）过期时间

Redis I/O 模型：

![BIO模型](https://gitee.com/adanzzz/pics/raw/master/images/20210709113922.png)

![I/O多路复用模型](https://gitee.com/adanzzz/pics/raw/master/images/20210709114102.png)

![Redis Reactor模型](https://gitee.com/adanzzz/pics/raw/master/images/20210709114205.png)

## MySQL

