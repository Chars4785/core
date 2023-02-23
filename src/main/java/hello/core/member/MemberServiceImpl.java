package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 구체적인건 이제 전혀 모르고
    // 생성자를 통해서 들어간다 해서 "생성자 주입" 이라고 한다.
    // 추상화에만 의존한다.
    private final MemberRepository memberRepository;

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
}
