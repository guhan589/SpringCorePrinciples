package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {


    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "membeA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
