package hello.core.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);//회원 아이디로 회원정보 찾기
}
