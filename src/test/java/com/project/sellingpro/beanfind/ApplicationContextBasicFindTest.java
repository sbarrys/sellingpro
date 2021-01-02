package com.project.sellingpro.beanfind;

import com.project.sellingpro.AppConfig;
import com.project.sellingpro.member.MemberService;
import com.project.sellingpro.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("getBea+(이름,타입) 으로 빈 조회하기")
    public void findBeanByName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("getBean(타입) 으로 빈 조회하기")
    public void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("getBean(이름) 으로 없는 이름 빈 조회하기")
    public void findNotFoundBean(){
        MemberService memberService = ac.getBean("없는이름",MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("없는이름",MemberService.class));

    }
}
