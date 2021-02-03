package hello.core.common;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
//클래스일 때 ScopedProxyMode.TARGET_CLASS이용
//언터페이스 일 때 ScopedProxyMode.INTERFACES이용
public class MyLogger {
    private String uuid;
    private String requestURL;


    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init(){
        //다른 http요청과 구분하기 위해서 UUID생성
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }
    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
