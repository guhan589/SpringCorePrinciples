package hello.core.singletone;

import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){ 
        /**
         * getInstance()메소드를 만들어도
         * new생성이 가능하기에 기본 생성자를 private으로 설정
         * */
    }
   public void logic(){
       System.out.println("싱글톤 객체 로직 호출");
   }
}
