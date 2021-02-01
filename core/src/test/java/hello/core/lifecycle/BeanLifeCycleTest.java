package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig{

        /**
         * 빈 등록 초기화, 소멸 메서드
         * 메서드 이름을 자유롭게 줄 수 있다.
         * 스프링 빈이 스프링 코드에 의존적이지 않는다.
         * 코드가 아니라 설정 정보를 사용하기 때문에 코드를
         * 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.
         * */
        //@Bean(initMethod = "init",destroyMethod = "close")
        //destroyMethod: defalut값이 (inferred) :추론 으로 등록되어있어 close나 shutdown 의 이름을 가진 메서드를
        //자동으로 호출해 준다. 추론기능을 사용하기 싫으면 destroyMethod = "" 빈공백을 주면 된다.

        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
