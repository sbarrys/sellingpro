package com.project.sellingpro.order;

import com.project.sellingpro.member.Grade;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberService;
import com.project.sellingpro.member.MemberServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {

    MemberService memberService =new MemberServiceImpl();
    OrderService orderService =new OrderServiceImpl();

    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA",Grade.VIP);
        //when
        memberService.join(member);
        Order order= orderService.createOrder(memberId,"itemA",10000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
