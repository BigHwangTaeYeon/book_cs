package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    @Autowired TeamRepository teamRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("")
    public void testMember() throws Exception {
        System.out.println("memberRepository = " + memberRepository.getClass());
        //given
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(savedMember.getId()).get();
        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    @DisplayName("")
    public void basicCRUD() throws Exception {
        //given
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        // 단건 조회 검사
        //when
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        //then
        AssertionsForClassTypes.assertThat(findMember1).isEqualTo(member1);
        AssertionsForClassTypes.assertThat(findMember2).isEqualTo(member2);

        // 수정
//        findMember1.setUsername("member!!");

        // 리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        AssertionsForClassTypes.assertThat(all.size()).isEqualTo(2);

        // count 검증
        long count = memberRepository.count();
        AssertionsForClassTypes.assertThat(count).isEqualTo(2);

        // 삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);
        long deletedCount = memberRepository.count();
        AssertionsForClassTypes.assertThat(deletedCount).isEqualTo(0);
    }


    @Test
    @DisplayName("")
    public void findByUsernameAndAgeGreaterThen() throws Exception{
        //given
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("AAA", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("AAA", 15);
        //then
        AssertionsForClassTypes.assertThat(result.get(0).getUsername()).isEqualTo("AAA");
        AssertionsForClassTypes.assertThat(result.get(0).getAge()).isEqualTo(20);
        AssertionsForClassTypes.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("")
    public void findHeloBy() throws Exception {
        //given
        List<Member> top3HelloBy = memberRepository.findTop3HelloBy();
        //when

        //then

    }

    @Test
    @DisplayName("")
    public void namedQuery() throws Exception {
        //given
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findByUsername("AAA");
        Member findMember = result.get(0);
        //then
        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    @DisplayName("")
    public void testQuery() throws Exception {
        //given
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findUser("AAA", 10);
        //then
        assertThat(result.get(0)).isEqualTo(member1);
    }

    @Test
    @DisplayName("")
    public void findUsernameList() throws Exception {
        //given
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<String> usernameList = memberRepository.findUsernameList();
        //then
        for (String s : usernameList) {
            System.out.println("s = " + s);
        }
    }

    @Test
    @DisplayName("")
    public void findMemberDto() throws Exception {
        //given
        Team team = new Team("teamA");
        teamRepository.save(team);

        Member member1 = new Member("AAA", 10);
        member1.setTeam(team);
        memberRepository.save(member1);
        //when
        List<MemberDto> usernameList = memberRepository.findMemberDto();
        //then
        for (MemberDto memberDto : usernameList) {
            System.out.println("dto = " + memberDto);
        }
    }

    @Test
    @DisplayName("")
    public void findByNames() throws Exception {
        //given
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> byNames = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));
        //then
        for (Member byName : byNames) {
            System.out.println("member = " + byName);
        }
    }

    @Test
    @DisplayName("")
    public void returnType() throws Exception {
        //given
        Member member1 = new Member("AAA", 10);
        Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> listMember = memberRepository.findListByUsername("AAA");
        Member member = memberRepository.findMemberByUsername("AAA");
        Optional<Member> optional = memberRepository.findOptionalByUsername("AAA");
        //then
        for (Member member3 : listMember) {
            System.out.println("listMember : " + listMember);
        }
        System.out.println("member : " + member);
        System.out.println("optional : " + optional);

        List<Member> result = memberRepository.findListByUsername("sdfsd");
        System.out.println("result = " + result);   // null 이 아니다. 컬렉션은 주의할 것.
    }

    @Test
    @DisplayName("")
    public void paging() throws Exception {
        //given
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
//        PageRequest pageRequest = PageRequest.of(0, 3);
        //when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);

        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), member.getTeam().getName()));

        //then
        List<Member> content = page.getContent();

        assertThat(content.size()).isEqualTo(3);
        assertThat(page.getTotalElements()).isEqualTo(5);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.isFirst()).isTrue();
        assertThat(page.hasNext()).isTrue();
    }

    @Test
    @DisplayName("")
    public void slice() throws Exception {
        //given
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
//        PageRequest pageRequest = PageRequest.of(0, 3);
        //when
        Slice<Member> page = memberRepository.findSliceByAge(age, pageRequest);
        //then
        List<Member> content = page.getContent();

        assertThat(content.size()).isEqualTo(3);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.isFirst()).isTrue();
        assertThat(page.hasNext()).isTrue();
    }

    @Test
    @DisplayName("")
    public void bulkAgePlus() throws Exception {
        //given
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 19));
        memberRepository.save(new Member("member3", 20));
        memberRepository.save(new Member("member4", 21));
        memberRepository.save(new Member("member5", 40));
        //when
        // 20살 이상인 사람은 모두 +1
        int resultCount = memberRepository.bulkAgePlus(20);

        List<Member> member5 = memberRepository.findByUsername("member5");
        System.out.println("member5 : " + member5.get(0));

        //then
        AssertionsForClassTypes.assertThat(resultCount).isEqualTo(3);
    }

    @Test
    @DisplayName("")
    public void findMemberLazy() throws Exception {
        //given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();
        //when
//        List<Member> members1 = memberRepository.findAll();
//        List<Member> members2 = memberRepository.findMemberEntityGraph();
        List<Member> members3 = memberRepository.findEntity1GraphByUsername("member1");
        //then
//        for (Member member : members1) {
//            System.out.println("member : " + member.getUsername());
//            System.out.println("member.getTeam().getClass : " + member.getTeam().getClass());
//            System.out.println("member.getTeam() : " + member.getTeam().getName());
//        }
//        for (Member member : members2) {
//            System.out.println("member : " + member.getUsername());
//            System.out.println("member.getTeam().getClass : " + member.getTeam().getClass());
//            System.out.println("member.getTeam() : " + member.getTeam().getName());
//        }
        for (Member member : members3) {
            System.out.println("member : " + member.getUsername());
            System.out.println("member.getTeam().getClass : " + member.getTeam().getClass());
            System.out.println("member.getTeam() : " + member.getTeam().getName());
        }
    }

    @Test
    @DisplayName("")
    public void queryHint() throws Exception {
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear(); // 영속성 컨텍스트가 다 날라가서 이후에 조회는 DB 에서 가져온다.
        //when
        Member findMember = memberRepository.findById(member1.getId()).get();
        findMember.setUsername("member2");
        em.flush(); // 변경감지로 데이터 수정
        // 원본 데이터는 member1 이고 member2 로 변경하면 1에서 2로 변경된것을 알기 위해서 두 데이터를 모두 가져야하는 메모리 리스크가 있다.
        // 조회만 사용한다면 원본은 필요없다 이 기능을 spring data jpa 에서 제공한다.
        //then
    }

    @Test
    @DisplayName("")
    public void queryHint1() throws Exception {
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear(); // 영속성 컨텍스트가 다 날라가서 이후에 조회는 DB 에서 가져온다.
        //when
        Member findMember = memberRepository.findReadOnlyByUsername("member1");
        findMember.setUsername("member2");
        em.flush(); // 변경감지로 데이터 수정
        // 원본 데이터는 member1 이고 member2 로 변경하면 1에서 2로 변경된것을 알기 위해서 두 데이터를 모두 가져야하는 메모리 리스크가 있다.
        // 조회만 사용한다면 원본은 필요없다 이 기능을 spring data jpa 에서 제공한다.
        //then
    }

    @Test
    @DisplayName("")
    public void lock() throws Exception {
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear(); // 영속성 컨텍스트가 다 날라가서 이후에 조회는 DB 에서 가져온다.
        //when
        List<Member> member11 = memberRepository.findLockByUsername("member1");
    }

    @Test
    @DisplayName("")
    public void callCustom() throws Exception {
        //given
        List<Member> result = memberRepository.findMemberCustom();
        //when

        //then

    }
}