package hello.core.discount;

import hello.core.annotation.MainDisountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

//@Primary // 여러개의 Bean(FixDiscountPolicy, RateDiscountPolicy)이 있을 경우 primary가 우선순위를 갖는다.
//@Qualifier("mainDiscountPolicy") //추가 구분자를 붙여주는 방법, 빈 이름을 변경하는 것이 아님!!!!!!!!!

/*@MainDisountPolicy*/
//또한 문자는 컴파일타임에서 찾을 수 없기 때문에 annotaiton을 만듫어서 사용한다.
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return price*discountPercent / 100;
        else
            return 0;
    }
}
