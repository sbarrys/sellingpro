package com.project.sellingpro.beanfind;

import com.project.sellingpro.AppConfig;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberRepository;
import com.project.sellingpro.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameNameBeanFindTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("getBean(타입) 으로 조회시 같은 타입이 2개이상 일 경우 에러")
    void findBeanByTypeDuplicate(){
        ac.getBean(MemberRepository.class);
    }

    @Test
    @DisplayName("getBean(타입) 으로 존재하는 모든 타입의 빈 출력")
    void findAllBeansByType(){
//        ac.getBean(MemberRepository.class);
        Map<String,MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key ="+key+" value = "+beansOfType.get(key));
        }
        System.out.println("beansOfType = "+beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration//클래스 안에서 사용할 config이다.
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
