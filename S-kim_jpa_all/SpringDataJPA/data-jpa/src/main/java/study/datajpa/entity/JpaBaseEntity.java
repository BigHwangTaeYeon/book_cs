package study.datajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {
    @Column(updatable = false)  // (실수로라도)db 값 변경 불가능
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @PrePersist // memberRepository.save(member); 하기 전 작동
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        updateDate = now;
    }

    @PreUpdate  // update 시, 작동(member.setUsername("member2"); em.flush();)
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }
}
