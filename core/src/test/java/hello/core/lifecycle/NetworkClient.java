package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient /*implements InitializingBean, DisposableBean */{


    /**
     * InitializingBean, DisposableBean 인터페이스는 잘사용하지 않는다.
     * 이유: 스프링 전용 인터페이스에 의존해야하며 초기화, 소멸 메서드의 이름을 변경할 수 없고
     * 내가 코드를 수정할 수 없는 외부 라이브러리를 적용할 수 없다.
     */
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call:" + url + " message=" + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close:" + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

    /*@Override //의존관계 주입이 끝날때 호출 또는 스프링 bean이 생성 될 때 호출
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override //스프링 bean이 삭제 될 때 호출
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }*/
}
