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
            // 변경 감지
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            //em.persist(member);   변경 후에 persist 쓰면 안됨(변경 감지로 영속성 컨텍스트가 자동으로 update 쿼리를 날려줌)
            System.out.println("====================================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
