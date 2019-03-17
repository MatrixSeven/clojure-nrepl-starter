package com.spring.repl;

import clojure.lang.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import clojure.lang.RT;
import java.util.Arrays;
import java.util.List;

//=======================================================
//		          .----.
//		       _.'__    `.
//		   .--(^)(^^)---/!\
//		 .' @          /!!!\
//		 :         ,    !!!!
//		  `-..__.-' _.-\!!!/
//		        `;_:    `"'
//		      .'"""""`.
//		     /,  ya ,\\
//		    //狗神保佑\\
//		    `-._______.-'
//		    ___`. | .'___
//		   (______|______)
//=======================================================

/**
 * [Zhihu]https://www.zhihu.com/people/Sweets07
 * [Github]https://github.com/MatrixSeven
 * Created by Seven on 2019-03-17 16:33
 */
@Service
@SuppressWarnings({"unchecked"})
public class ClojureServices {

    private static Logger logger= LoggerFactory.getLogger(ClojureServices.class);

    private static final Var EVAL=var("eval");
    private static final Var READ_STRING=var("read-string");
    private static ApplicationContext applicationContext;
    private StarterServiceProperties starterServiceProperties;
    private Environment environment;

    public ClojureServices(StarterServiceProperties properties, ApplicationContext applicationContext, Environment env){
        environment=env;
        starterServiceProperties=properties;
        ClojureServices.applicationContext=applicationContext;
    }

    private static Var var(String varName) {
        return RT.var("clojure.core",varName);
    }

    public static <T> T getBean(String name){
        return (T)applicationContext.getBean(name);
    }

    public void init(){
        final List<String> mode=starterServiceProperties.getMode();
        final List<String> active=Arrays.asList(environment.getActiveProfiles());
        final boolean runMode= active.stream().anyMatch(mode::contains);
        if(starterServiceProperties.getState()&&runMode) {
            Integer port=starterServiceProperties.getPort();
            Thread replThread=new Thread(() -> {
                eval("(use '[clojure.tools.nrepl.server :only (start-server)])");
                eval("(use '[cider.nrepl :only (cider-nrepl-handler)])");
                eval("(def repl-server (start-server :port "+port+" :handler cider-nrepl-handler))");
                logger.info("Clojure nrepl is started on port(s): {} ",port);
                logger.info("Clojure nrepl services running only on {} mode", mode);
            });
            replThread.setName("Nrepl-Service");
            replThread.start();
        }else {
            logger.info("Clojure nrepl services is Loaded,but not start");
            logger.info("Clojure nrepl services running only on {} mode", mode);
        }

    }
    private static <T> T eval(String... code) {
        return (T) EVAL.invoke(readString(String.join("\n", code)));
    }
    private static <T> T readString(String s) {
        return (T) READ_STRING.invoke(s);
    }
}
