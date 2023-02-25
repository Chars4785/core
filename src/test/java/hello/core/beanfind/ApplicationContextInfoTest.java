package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "objcet" + bean);
//            name = appConfigobjcethello.core.AppConfig$$SpringCGLIB$$0@51133c06
//            name = memberServiceobjcethello.core.member.MemberServiceImpl@4b213651
//            name = getMemberRepositoryobjcethello.core.member.MemoryMemberRepository@4241e0f4
//            name = orderServiceobjcethello.core.order.OrderServiceImpl@4ebff610
//            name = discountPolicyobjcethello.core.discount.RateDiscountPolicy@60410cd

        } 
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLCATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTRUE: 스프링이 내부에서 사용하는 빈
//                name = org.springframework.context.annotation.internalConfigurationAnnotationProcessorobjcetorg.springframework.context.annotation.ConfigurationClassPostProcessor@73302995
//                name = org.springframework.context.annotation.internalAutowiredAnnotationProcessorobjcetorg.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@1838ccb8
//                name = org.springframework.context.annotation.internalCommonAnnotationProcessorobjcetorg.springframework.context.annotation.CommonAnnotationBeanPostProcessor@6c2ed0cd
//                name = org.springframework.context.event.internalEventListenerProcessorobjcetorg.springframework.context.event.EventListenerMethodProcessor@7d9e8ef7
//                name = org.springframework.context.event.internalEventListenerFactoryobjcetorg.springframework.context.event.DefaultEventListenerFactory@f107c50
            if( beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "objcet" + bean);
            }
        }
    }
}
