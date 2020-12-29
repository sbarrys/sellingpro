package com.project.sellingpro.order;

import com.project.sellingpro.discount.DiscountPolicy;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    //이제 순수한 인터페이스에만 의존한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //Appconfig 가 실제 구현체를 탑재한 생성자를 만들어서  넣어준다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        //Order 에서는 discount 라는 것에 책임을 넘겨버렸다. 현재 단일책임 규칙이 잘 이루어 지고 있는 중
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
