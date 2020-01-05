package repl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import repl.R;


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
@Configuration
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure  {

    @Autowired
    private StarterServiceProperties properties;

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean(initMethod="init")
    public R starterService (){
        return new R(properties, applicationContext, env);
    }


}