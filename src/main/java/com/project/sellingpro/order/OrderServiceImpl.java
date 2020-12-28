package com.project.sellingpro.order;

import com.project.sellingpro.discount.DiscountPolicy;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberRepository;
import com.project.sellingpro.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //인터페이스만 의존하도록 싹 지웠다.
    //그러면 NullPoint 인데 어떻게 하면 될까?
    //해결방안 : Spring 이 객체를 대신 생성해서 대신 주입시켜주는 방식으로 해결한다..
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        //Order 에서는 discount 라는 것에 책임을 넘겨버렸다. 현재 단일책임 규칙이 잘 이루어 지고 있는 중
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
