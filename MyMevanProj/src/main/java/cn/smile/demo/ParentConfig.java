package cn.smile.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JavaConfigA.class,JavaConfigB.class})
public class ParentConfig {

}
