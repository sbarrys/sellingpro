package com.project.sellingpro;

import com.project.sellingpro.member.Grade;
import com.project.sellingpro.member.Member;
import com.project.sellingpro.member.MemberService;
import com.project.sellingpro.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);

        System.out.println("new member  = " + member);
        System.out.println("find member  = " + findmember);
    }
}
