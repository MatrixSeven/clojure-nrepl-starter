# clojure-nrepl-starter

### 这是什么?
这个是一个Spring-boot的nrepl快速启动组件,在Maven中引入该依赖后可以快速在Spring-boot项目中启动一个`Clojure-Cider-Nrepl`.

### 可以做什么?
启动`Nrepl`后可以在终端使用`lein connect`直接连接到该服务,连接后可以直接获取Spring上下文中的Bean,并且直接调用Bean的方法/查看当前属性状态
结合`Jrebel`可以实现JavaCode热加载并且Repl不断开,但是在终端里并没有代码补全,如果想体验补全的快感建议使用`Emacs+Cider`环境.

