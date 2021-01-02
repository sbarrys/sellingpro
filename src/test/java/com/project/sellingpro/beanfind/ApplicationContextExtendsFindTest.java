package com.project.sellingpro.beanfind;

import com.project.sellingpro.discount.DiscountPolicy;
import com.project.sellingpro.discount.FixDiscountPolicy;
import com.project.sellingpro.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 여럿있으면 중복 오류")
    void findBeanByParentTypeDuplicate(){
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 여럿있으면 이름으로 조회해라")
    void findBeanByParentTypeWithABeanName(){
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 여럿있으면 특정타입으로 조회해라")
    void findBeanByParentTypeWithAChildType(){
        DiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("부모 타입으로 조회시, Map<String,DiscountPolicy> 사용해서 모두 가져오기 ")
    void findBeanByParentType(){
        Map<String,DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);

        assertThat(beans.size()).isEqualTo(2);
    }

    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
