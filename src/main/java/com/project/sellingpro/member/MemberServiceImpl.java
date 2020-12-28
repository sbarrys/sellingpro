package com.project.sellingpro.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스를 구현객체로 생성해주지 않으면 NullPointException
    private  final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {

        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
