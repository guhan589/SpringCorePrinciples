package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",//member 패키지만 등록이 된다.
        //디폴트로는 ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class) // 컴포넌트를 다 스캔 하고 거기서 뺄것을 지정
)

public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
