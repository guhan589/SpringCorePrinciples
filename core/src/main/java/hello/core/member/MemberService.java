package hello.core.member;

public interface MemberService { // 회원의 정보를 가입 및 조회하는 인터페이스

    void join(Member member);

    Member findMember(Long Member);

}
