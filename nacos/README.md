## nacos

### 概览
英文全称Dynamic Naming and Configuration Service，Na为naming/nameServer即注册中心,co为configuration即注册中心，service是指该注册/配置中心都是以服务为核心。服务在nacos是一等公民

Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。

nacos脑图：
![nacosMap](./img/nacosMap.jpg)

### 使用方式
1. 从 Github 上下载源码方式
    ```java
    git clone https://github.com/alibaba/nacos.git
    cd nacos/
    mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
    ls -al distribution/target/
    
    // change the $version to your actual path
    cd distribution/target/nacos-server-$version/nacos/bin
    ```
1. 下载编译后压缩包方式

    您可以从 [最新稳定版本](https://github.com/alibaba/nacos/releases) 下载 nacos-server-$version.zip 包。
    ```java
     unzip nacos-server-$version.zip 或者 tar -xvf nacos-server-$version.tar.gz
     cd nacos/bin
    ```
1. 启动服务器
    Linux/Unix/Mac
    启动命令(standalone代表着单机模式运行，非集群模式):
    
    `sh startup.sh -m standalone`
    
    如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：
    
    bash startup.sh -m standalone
    
    Windows
    启动命令(standalone代表着单机模式运行，非集群模式):
    
    `cmd startup.cmd -m standalone`

1. 启动过程注意点
    1. 环境准备要严格，因为开发任务使用到的工具需要32位jdk，我修改了环境变量，所以导致启动后无法访问管理系统的情况。
        ```java
        Nacos 依赖 Java 环境来运行。如果您是从代码开始构建并运行Nacos，还需要为此配置 Maven环境，请确保是在以下版本环境中安装使用:
        
        64 bit OS，支持 Linux/Unix/Mac/Windows，推荐选用 Linux/Unix/Mac。
        64 bit JDK 1.8+；下载 & 配置。
        Maven 3.2.x+；下载 & 配置。
        ```
    1. 启动过程比较慢，出现以下信息，表示完全启动成功，访问控制台的地址：http://192.168.1.6:8848/nacos/index.html
        ```java
        2020-12-13 22:04:12,368 INFO Nacos started successfully in stand alone mode. use embedded storage
        ```

### 配置中心

### 参考
1. [官方网址](http://nacos.io)

### 问题待解决及计划
1. 完成配置中心功能。
2. nacos源码部分依赖无法通过maven下载，初步分析和maven镜像有关，后续再分析解决。