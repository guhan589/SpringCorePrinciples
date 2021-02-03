package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject(); // getObject 호출 시 이때 bean이 등록된다.
        myLogger.log("service id =" + id);
    }
}
