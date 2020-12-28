package com.project.sellingpro.discount;

import com.project.sellingpro.member.Member;

public interface DiscountPolicy {
    /**
    * @return 할인 대상 금액
     */
    int discount(Member member,int price);

}
