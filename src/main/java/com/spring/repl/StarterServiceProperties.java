package com.spring.repl;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
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
@ConfigurationProperties(prefix = "clojure.nrepl")
public class StarterServiceProperties {
    private boolean state=false;
    private Integer port=7888;
    private List<String> mode= Collections.singletonList("dev");


    public Integer getPort() { return port; }

    public void setPort(Integer port) { this.port = port; }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<String> getMode() {
        return mode;
    }

    public void setMode(List<String> mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "StarterServiceProperties{" +
                "state=" + state +
                ", port=" + port +
                ", mode=" + mode +
                '}';
    }
}