package hello.core.web;


import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
//이 어노테이션은 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다. 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용되곤 합니다.
public class LogDemoController {

    private final LogDemoService logDemoService;
    //    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    /**
     * MyLogger는 request 요청이 들어올 떄 생성이 되며 MyLogger 클래스를 DI할 경우
     * coreApplication 서버 실행 시 request요청이 바로 안들어오기에 오류가 발생한다.
     *
     * 이를 해결하기 위해서 ObjectProvider를 이용하여 getObejct 메서드 요청이 들어올 떄 MyLogger가 생성되도록 하는 로직을 이용하거나
     * MyLogger클래스의 scope어노테이션에 프록시를 사용하는 방법이 있다.
     * */
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        logDemoService.logic("testId");
        return "Ok";


    }
}
