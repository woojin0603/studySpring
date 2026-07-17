package hellojpa;

import jakarta.persistence.*;

import java.util.List;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 비영속
          /*  Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속V1
            System.out.println("=== BEFORE === ");
            em.persist(member);
            //em.detach(member);    // member 엔티티를 영속성 컨텍스트에서 분리(준영속 상태)
            //em.remove(member);    // 객체를 삭제한 상태(삭제)
            System.out.println("=== AFTER === ");
*/
/*            // 영속V2
            Member findMember1 = em.find(Member.class, 101L);   // 여기만 SELECT 쿼리가 출력됨(DB에서 찾아서 1차캐시에 등록)
            Member findMember2 = em.find(Member.class, 101L);   // 두 번째부터는 1차캐시에서 바로 찾아서 반환(SELECT X)
            System.out.println("result = " + (findMember1 == findMember2));*/

         /*   // 영속V3
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
            em.persist(member1);
            em.persist(member2);
*/
/*
            // 변경 감지
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            //em.persist(member);   변경 후에 persist 쓰면 안됨(변경 감지로 영속성 컨텍스트가 자동으로 update 쿼리를 날려줌)
            System.out.println("====================================");
*/
/*
            // flush
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();
            System.out.println("====================================");
*/

          /*  // 준영속 상태
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");

            //em.detach(member);  // 준영속 상태로 전환(영속성 컨텍스트에서 분리)(위 경우에서는 분리되었으므로 update 쿼리가 안나감)
            em.clear(); // 영속성 컨텍스트 자체를 초기화

            Member member2 = em.find(Member.class, 150L);
*/
            /*// ORDINAL 예제
            Member member = new Member();
            member.setId(1L);
            member.setUserName("A");
            member.setRoleType(RoleType.USER);

            Member member2 = new Member();
            member2.setId(2L);
            member2.setUserName("B");
            member2.setRoleType(RoleType.ADMIN);

            Member member3 = new Member();
            member3.setId(3L);
            member3.setUserName("C");
            member3.setRoleType(RoleType.GUEST);

            em.persist(member);
            em.persist(member2);
            em.persist(member3);*/

            // 기본키 매핑
           /* Member member = new Member();
            member.setUserName("C");

            System.out.println("===============================");
            em.persist(member);
            System.out.println("member.id = " + member.getId());
            System.out.println("===============================");
*/
            Member member1 = new Member();
            member1.setUserName("A");

            Member member2 = new Member();
            member1.setUserName("B");

            Member member3 = new Member();
            member1.setUserName("C");

            System.out.println("===============================");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());

            System.out.println("===============================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
