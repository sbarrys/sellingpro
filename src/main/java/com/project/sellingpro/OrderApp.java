package com.project.sellingpro;

import com.project.sellingpro.member.*;
import com.project.sellingpro.order.Order;
import com.project.sellingpro.order.OrderService;
import com.project.sellingpro.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); //appConfig.memberService();
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);//appConfig.orderService();

        Long memberId = 1L;
        Member member =new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
    }
}
