package com.project.sellingpro.singleton;

import com.project.sellingpro.AppConfig;
import com.project.sellingpro.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("1. Java만으로 만든 DI 컨테이너")
    void pureDIContainer(){
        AppConfig appConfig= new AppConfig();
        //호출 할때마다 객체를 생성하게 된다.
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        //참조 메모리값이 다른것을 확인한다.
        System.out.println("1 : "+memberService1);
        System.out.println("2 : "+memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("2. 싱글톤 패턴으로 만든 Service 여러거 사용해보기")
    void singletonServiceTest(){
        SingletonService singletonService1 =SingletonService.getInstance();
        SingletonService singletonService2 =SingletonService.getInstance();
        System.out.println("1 : "+singletonService1);
        System.out.println("2 : "+singletonService2);
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }


    @Test
    @DisplayName("3.Spring 컨테이너가 제공해주는 Bean 객체")
    void singletonBySpringContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 컨테이너로 가져온것은 싱글톤으로 생성된 객체를 공유한다.
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);
        //참조 메모리값이 동일한 것을 확인한다.
        System.out.println("1 : "+memberService1);
        System.out.println("2 : "+memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
