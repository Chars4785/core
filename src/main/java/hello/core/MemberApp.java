package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // Spring 이 Appconfig 안에 있는 파일들을 Spring Container 안에 넣는다.
        // AnnotationConfigApplicationContext => interface applicationContext 를 기반으로 개발
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 첫번째는 이 객체 찾을꺼야, 그리고 반환 타입을 넣어준다.
        // 키는 memberService 로 value는 MemberService로 들어간다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
