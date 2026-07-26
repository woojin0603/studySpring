package study.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.data_jpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String name, int age);   // 구현하지 않아도 query method 기능을 자동으로 써서 동작함.

    List<Member> findTop3HelloBy();

    // @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

}
