package hello.core.singletone;

import org.junit.jupiter.api.Test;

public class StatefulService {
//    private int price;//상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;

//        this.price = price;
    }

//    public int getPrice() {
//        return price;
//    }
}
