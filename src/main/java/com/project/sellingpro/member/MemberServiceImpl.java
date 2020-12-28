package com.project.sellingpro.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스를 구현객체로 생성해주지 않으면 NullPointException
    // DIP 위바중이다 - 현재 인터페이스랑 구현체 둘다 의존하고 있다. (인터페이스만 의존하게 바꿔줘야함)
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
