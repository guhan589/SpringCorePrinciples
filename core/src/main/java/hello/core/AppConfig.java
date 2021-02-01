package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 객체를 생성하고 관리하면서 의존관계를 연결해주는 것을
                        // IOC컨테이너 또는 DI컨테이너라고 함

//    @Autowired MemberRepository memberRepository;
    // @Bean이 적힌 메소드를 모두 호출한다.
    int count = 0;
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }
    @Bean
    public RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
