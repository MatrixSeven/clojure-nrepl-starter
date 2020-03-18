# clojure-nrepl-starter

![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)
![Jenkins Status](https://img.shields.io/jenkins/s/https/builds.apache.org/job/maven-box/job/maven/job/master.svg?style=flat-square)




### 这是什么?
这个是一个Spring-boot的nrepl快速启动组件,在Maven中引入该依赖后可以快速在Spring-boot项目中启动一个`Clojure-Cider-Nrepl`.

### 可以做什么?
启动`Nrepl`后可以在终端使用`lein connect`直接连接到该服务,连接后可以直接获取Spring上下文中的Bean,并且直接调用Bean的方法/查看当前属性状态
结合`Jrebel`可以实现JavaCode热加载并且Repl不断开,但是在终端里并没有代码补全,如果想体验补全的快感建议使用`Emacs+Cider`环境.

### 为啥出来了个这么个玩意
突发奇想,然后就被无聊的搞出来了

### 如何使用
直接在项目的`pom.xml`里引入依赖
```xml
<dependency>
  <groupId>com.github.matrixseven</groupId>
  <artifactId>clojure-nrepl-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```
然后配置
```properties
#是否启动,默认不启动
clojure.nrepl.state=true
#服务绑定的端口,默认7888
clojure.nrepl.port=7888
#仅在以下环境中启动,默认为dev,优先级高于state
clojure.nrepl.mode=dev,test
```

### 使用场景
某日你突然要临时发几条`kafka/mq`消息又或者热加载某个`bean`后需要调用某个方法测试,以前可能要写个`Test`用例或者`web`项目调用下接口等等.那么现在so easy,无论是本地还是跑在测试线的环境,只要您开启了`nrepl`服务,你就可以直接连接上去,干你想干的事情,直接发消息/调用某个方法而不要重启/发布你的项目.



### eg:
#### 体验
![](clojure.gif)

#### 直接emacs中启动nrepl链接
![](1.png)

#### 或者直接在idea中添加远程repl
![](2.png)

#### 然后尝试使用它.
![](3.png)

## Enjoy it!
* 一个emacs配置文件 [https://github.com/MatrixSeven/SEmacs](https://github.com/MatrixSeven/SEmacs)
* 吾爱Java(QQ群):[170936712（点击加入）](https://link.zhihu.com/?target=https%3A//jq.qq.com/%3F_wv%3D1027%26k%3D41oCCMn)