package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")

    void finAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //리스트 출력시 iter 치고 tab을 누르면 알아서 for문이 생성됨
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name==>" + beanDefinitionName + ", Object==>" + bean);
        }
    }


    @Test
    @DisplayName("애플리케이션 빈 출력하기")

    void finApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //리스트 출력시 iter 치고 tab을 누르면 알아서 for문이 생성됨
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //getBeanDefinition : Bean하나하나에 대한 메다테이터 정보


            //getRole(): spring내부에서 등록한 bean이 아닌 application을 개발하기 위해 등록한 bean
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name==>" + beanDefinitionName + ", Object==>" + bean);
            }
        }
    }
}
