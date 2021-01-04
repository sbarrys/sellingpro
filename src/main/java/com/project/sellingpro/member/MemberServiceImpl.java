package com.project.sellingpro.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private  final MemberRepository memberRepository ;//= new MemoryMemberRepository()
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){ // Appconfig 가 실제 구현체 MemoryMemberReposiory를 생성해서 넣어준다.
        this.memberRepository= memberRepository;
    }
    @Override
    public void join(Member member) {

        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
