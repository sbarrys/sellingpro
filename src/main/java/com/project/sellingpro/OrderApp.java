package com.project.sellingpro;

import com.project.sellingpro.member.*;
import com.project.sellingpro.order.Order;
import com.project.sellingpro.order.OrderService;
import com.project.sellingpro.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService =appConfig.memberService();
        OrderService orderService =appConfig.orderService();

        Long memberId = 1L;
        Member member =new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
    }
}
