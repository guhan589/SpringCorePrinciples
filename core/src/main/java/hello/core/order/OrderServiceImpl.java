package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{


    /**
     * 필드주입 (단, 필드주입은 권장하지 않음.)
     * */
    /*@Autowired private final MemberRepository memberRepository;
    @Autowired private final DiscountPolicy discountPolicy;*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    /**
     * 의존관계 주입은 4가지 종류가 있다
     * (생성자 주입, 수정자주입(setter), 필드 주입, 일반 메서드 주입)
     * */
    @Autowired//생성자가 하나이기에 생략가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository:"+memberRepository);
        System.out.println("discountPolicy:"+discountPolicy);

        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * setter 주입
     */
    /*@Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }*/

    /**
     *
     * 일반메소드를 통해서 다음과 같이 주입을 받을 수 있다.
     * */
    /*@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //테스트용
    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
