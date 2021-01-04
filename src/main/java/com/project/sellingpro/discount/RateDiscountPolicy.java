package com.project.sellingpro.discount;

import com.project.sellingpro.discount.DiscountPolicy;
import com.project.sellingpro.member.Grade;
import com.project.sellingpro.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if( member.getGrade() == Grade.VIP ){
            return price * discountPercent / 100 ;
        }else{
            return 0;
        }
    }
}
