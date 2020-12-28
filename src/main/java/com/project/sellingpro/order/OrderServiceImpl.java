package com.project.sellingpro.order;

import com.project.sellingpro.discount.DiscountPolicy;
import com.project.sellingpro.discount.FixDiscountPolicy;
import com.project.sellingpro.discount.RateDiscountPolicy;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberRepository;
import com.project.sellingpro.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책을 변경하려면 클라이언트인 OrderServiceImple 의 코드를 고쳐야한다. 우리는 인터페이스만 의존하는것이 아닌, 구현체도 의존하고 있던것. (DIP 위반)
    // 그래서 "수정"하는 순간 OCP가 위반된다.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        //Order 에서는 discount 라는 것에 책임을 넘겨버렸다. 현재 단일책임 규칙이 잘 이루어 지고 있는 중
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
