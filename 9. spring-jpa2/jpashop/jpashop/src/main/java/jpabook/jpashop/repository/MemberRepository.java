package jpabook.jpashop.repository;

import jakarta.validation.constraints.NotEmpty;
import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 구현하지 않아도 실행 시 JpaRepository가
    // select m from Member m where m.name = ? 이라는 쿼리를 자동으로 짜서 넘겨줌
    List<Member> findByName(String name);
}
