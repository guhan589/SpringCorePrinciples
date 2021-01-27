package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

@Setter // setter자동 생성
@Getter // getter 자동생성
@ToString //객체 toString() 메소드 자동생성
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        System.out.println("helloLombok = " + helloLombok);
        helloLombok.setName("권구환");
        String name = helloLombok.getName();
        System.out.println("name = " + name);


    }
}
