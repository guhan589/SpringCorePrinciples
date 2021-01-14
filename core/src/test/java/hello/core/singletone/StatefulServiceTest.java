package hello.core.singletone;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int usrAPrice = statefulService1.order("usrA", 10000);

        //ThreadB: B사용자 20000원 주문
        int usrBPrice = statefulService2.order("usrB", 20000);

        //ThreadA:사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price=>" + usrAPrice);
        System.out.println("price=>" + usrBPrice);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}