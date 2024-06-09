package study.datajpa.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    /*
     * pk 로 조회를 외부에 공개해서 하는 것이 안좋다 생각하여 권장하지 않는다.
     * 간단할 때만 사용할 수 있고, 복잡해지면 사용이 불가능하다.
     * 조회 용으로만 사용하자.
     */

    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member){
        return member.getUsername();
    }

    // http://localhost:8080/members3?page=0&size=3&sort=id,desc&username,desc
    // default 가 20개 씩
    @GetMapping("/members3")
    public Page<Member> list(Pageable pageable) {
        //public class PageRequest extends AbstractPageRequest
        return memberRepository.findAll(pageable);
    }

    // yml 에서 글로벌 설정을 하고 특별하게 다른 값을 넣어주고 싶을 때, @PageableDefault 사용한다.
    // 중요한건 Page 는 반환해도 되지만 Member Entity 그대로 노출하면 안된다 DTO 꼭 사용할 것.
    @GetMapping("/members3-1")
    public Page<MemberDto> list1(@PageableDefault(size = 5) Pageable pageable) {
        //public class PageRequest extends AbstractPageRequest
        Page<Member> page = memberRepository.findAll(pageable);
//        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));
        Page<MemberDto> map = page.map(MemberDto::new);
        return map;
    }
    /*
     * index 0 이 아닌 1 부터 시작하고 싶다면
     * Pageable 을 직접 구현하거나,
     * one-indexed-parameters: true 글로벌 설정으로 page 1부터 시작하게 할 수 있다.
     * 하지만 content 데이터 제외하고 pageNumb 등 설정이 같이 맞춰지지 않는다.
     * 그래서 그냥 index 0 부터 사용하는 것이 좋다.
     */

//    @PostConstruct
    public void init() {
        for(int i=0; i<100; i++) {
            memberRepository.save(new Member("user"+i, i));
        }
    }
}
