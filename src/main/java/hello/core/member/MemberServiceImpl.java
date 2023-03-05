package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Configuration("memberService2") // 이름은 class 앞글자만 소문자로 변경되서 스프링 컨테이너에 등록된다.
@Component
public class MemberServiceImpl implements MemberService{

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 구체적인건 이제 전혀 모르고
    // 생성자를 통해서 들어간다 해서 "생성자 주입" 이라고 한다.
    // 추상화에만 의존한다.
    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
