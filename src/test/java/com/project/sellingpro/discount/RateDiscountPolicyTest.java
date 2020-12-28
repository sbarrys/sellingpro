package com.project.sellingpro.discount;

import com.project.sellingpro.member.Grade;
import com.project.sellingpro.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용됨")
    void vip_O(){
        //given
        Member memeber= new Member(1L,"VIPmember", Grade.VIP);
        //when
        int discount = discountPolicy.discount(memeber,1000);

        //then
        Assertions.assertThat(discount).isEqualTo(100);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않음")
    void vip_X(){
        //given
        Member memeber= new Member(2L,"BASICmember", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(memeber,1000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}
