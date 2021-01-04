package com.project.sellingpro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)// 과거에 만들어 놓은 AppConfig를 빼놓기 위해서
)// 자동으로 쫙 스캔해서 자동으로 Bean들로 등록해줌
public class AutoAppConfig {

}
