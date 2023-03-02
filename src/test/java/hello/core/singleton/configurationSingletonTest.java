package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class configurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // 모두 같다.
        // AppConfig 의 자바 코드를 보면 분명히 2번 new MemoryMemberRepository 호출해서 다른 인스턴스가 생서되어야 하는데?

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configureationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
        //bean = class hello.core.AppConfig$$SpringCGLIB$$0
        // CGLIB 가 붙는다.
        // 내가 만든 클래스가 아니라 스피링이 CGLIB 라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받는 임의의 다른 클래스를 만들고,
        // 다른 클래스를 스프링 빈으로 등록한 것이다.

        // @Configuration 이 없으면 new 로 만든것 들이 스프링 컨테이너에서 관리되고 있는게 아니기 때문에
        // 싱글톤을 보장 하지 않는다.
        // 나중에 @Autowired 로 스프링 컨테이너에 넣으면 또 관리가 되기 때문에 문제 없다.
    }
}
