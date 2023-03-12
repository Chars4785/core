package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false) // 호출 자체를 안한다.
        public void setNoBean1(Member member){
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member2){
            System.out.println("member2 = " + member2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member3){
            System.out.println("member3 = " + member3);
        }
    }
}
