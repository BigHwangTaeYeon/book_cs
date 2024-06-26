package study.datajpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.repository.MemberRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {
    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("")
    public void testEntity() throws Exception {
        //given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        // 초기화
        em.flush();
        em.clear();
        //when
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        //then
        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.team = " + member.getTeam());
        }
    }

    @Test
    @DisplayName("")
    public void JpaEventBaseEntity() throws Exception {
        //given
        Member member = new Member("member1");
        memberRepository.save(member);  // @PrePersist 발생

        Thread.sleep(100);
        member.setUsername("member2");

        em.flush(); // @PreUpdate
        em.clear();
        //when
        Member findMember = memberRepository.findById(member.getId()).get();
        //then
        System.out.println("findMember = " + findMember.getCreateDate());
        System.out.println("findMember = " + findMember.getLastModifyDate());
        System.out.println("findMember = " + findMember.getCreateBy());
        System.out.println("findMember = " + findMember.getLastModifyBy());
    }
}