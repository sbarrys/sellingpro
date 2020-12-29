package com.project.sellingpro;

import com.project.sellingpro.discount.FixDiscountPolicy;
import com.project.sellingpro.member.MemberService;
import com.project.sellingpro.member.MemberServiceImpl;
import com.project.sellingpro.member.MemoryMemberRepository;
import com.project.sellingpro.order.OrderService;
import com.project.sellingpro.order.OrderServiceImpl;

public class AppConfig {
    //기존에는 MemberService 에서 직접 memberRepository들을 생성하고 했었다. 그것은 배우가 배우를 직접 초빙하는 일과 같다.
    //이제는  Appconfig에서 그런것들을 해주도록 하겠다.
    public MemberService memberService(){
        //MemeberService 의 MemeberRepository는 구현체를 만들지 않고 생성자로 넣어주었다.
        //그 생성자를 Appconfig가 만들어준다..
        //그래서 자동으로 아래에있는 memoryMemberRepository가 들어가게 된다.
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
