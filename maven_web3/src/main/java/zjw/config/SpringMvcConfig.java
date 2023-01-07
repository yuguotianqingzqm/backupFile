package zjw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//3:初始化SpringMVC怀境（同Spring怀境），设定SpringMVC加载对应的bean
@Configuration
@ComponentScan("zjw.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
