package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(findMember.getName());

    }
}
