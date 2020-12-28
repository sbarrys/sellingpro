package com.project.sellingpro;

import com.project.sellingpro.order.Order;
import com.project.sellingpro.order.OrderService;
import com.project.sellingpro.order.OrderServiceImpl;
import com.project.sellingpro.member.Grade;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberService;
import com.project.sellingpro.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService =new MemberServiceImpl();
        OrderService orderService =new OrderServiceImpl();

        Long memberId = 1L;
        Member member =new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
    }
}
