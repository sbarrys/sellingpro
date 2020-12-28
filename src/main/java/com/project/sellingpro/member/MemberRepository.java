package com.project.sellingpro.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
