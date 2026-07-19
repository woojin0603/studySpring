package hellojpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


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
           /* Member member1 = new Member();
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

            System.out.println("===============================");*/

         /*   // 저장
            Team team = new Team();
            team.setName("TeamA");
 //           team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUserName("member1");
          //  member.changeTeam(team);
          //  member.setTeam(team);   // 연관관계에 주인에 값을 넣음(mappedBy에 넣으면 값이 안들어간다.)
            em.persist(member);

            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("======================");
            System.out.println("members = " + findTeam);
            System.out.println("======================");*/


          /*  Member findMember = em.find(Member.class, member.getId());
           *//* Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());*//*

            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("m = " + m.getUserName());
            }*/

            /*Member member = new Member();
            member.setUserName("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);*/

           /* // 고급 매핑 학습
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Item item = em.find(Item.class, movie.getId());
            System.out.println("item = " + item.getId());
*/
            /*// MappedSuperclass 학습
            Member member = new Member();
            member.setUserName("user1");
            member.setCreateBy("kim");
            member.setCreateDate(LocalDateTime.now());

            em.persist(member);
            em.flush();
            em.clear();*/

            // 프록시 학습
         /*   Member member1 = new Member();
            member1.setUserName("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());
            refMember.getUserName();    // 프록시 강제 초기화
            Hibernate.initialize(refMember);

            System.out.println("refMember = " + refMember.getClass());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));*/

            /*Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team1.setName("teamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUserName("member1");
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUserName("member2");
            member2.setTeam(team2);
            em.persist(member2);

            em.flush();
            em.clear();

           // Member m = em.find(Member.class, member1.getId());
            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();
*/
           /* Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);
*/

            /*Address address = new Address("city", "street", "10000");

            Member member = new Member();
            member.setUserName("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);
*/

           /*
            // 1번 멤버의 값만 newCity로 바꾸려는 의도지만 1,2번 모두 newCity로 바뀜
            member.getHomeAddress().setCity("newCity");*/

            Member member = new Member();
            member.setUserName("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================= START ====================");
            Member findMember = em.find(Member.class, member.getId());

            // homeCity -> newCity
            //findMember.getHomeAddress().setCity("newCity");   // 사이드 이펙트 발생 가능

           /* Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            // 치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));*/

           /* // Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            // 루트 클래스(조회를 시작할 클래스
            Root<Member> m = query.from(Member.class);

            // 쿼리 생성
            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();
*/
            em.createNativeQuery("select MEMBER_ID, city, street, zipcodem USERNAME from MEMBER")
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("e = " + e);
        } finally {
            em.close();
        }
        emf.close();
    }


}
