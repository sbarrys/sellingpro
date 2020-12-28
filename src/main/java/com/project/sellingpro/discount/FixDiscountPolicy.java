package com.project.sellingpro.discount;

import com.project.sellingpro.member.Grade;
import com.project.sellingpro.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
