package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();


        /**
         * Spring 은 모든 것을 ApplicationContext으로 시작하면
         * 이것은 spring컨테이너라고 보면된다.
         *
         * ApplicationContext는 인터페이스 이다.
         **/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 첫번째 매개변수 이름은 호출하고자 하는 메소드의 이름을 적는다.


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(findMember.getName());

    }
}
