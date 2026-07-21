package hellojpa.jpql;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);


            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(0);
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(0);
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(0);
            member3.setTeam(teamB);
            em.persist(member3);

            // FLUSH
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            em.clear();
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getAge());

            System.out.println("resultCount = " + resultCount);
            System.out.println("member1.getAge() = " + member1.getAge());
            System.out.println("member2.getAge() = " + member2.getAge());
            System.out.println("member3.getAge() = " + member3.getAge());


           /* List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "회원1")
                    .getResultList();

            for (Member member : resultList) {
                System.out.println("member = " + member);
            }*/
/*
           // String query = "select m From Member m join fetch m.team";
            String query = "select m From Member m where m.team = :team";
            List<Member> members = em.createQuery(query, Member.class)
                    .setParameter("team", teamA)
                    .getResultList();

            for (Member member : members) {
                System.out.println("member = " + member);
            }
*/

            /*for (Member member : result) {
                System.out.println("team = " + member.getName() + "|members=" + member.getMembers().size());
                for (Member member : member.getMembers()) {
                    System.out.println("- member = " + member);
                }
                // 회원1, 팀A(SQL)
                // 회원2, 팀A(1차캐시)
                // 회원3, 팀B(SQL)

                // 회원 100명 -> N + 1
            }*/

            /*Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.setType(MemberType.ADMIN);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String query = "select index(t.members) From Team t";
            List<Integer> result = em.createQuery(query, Integer.class)
                    .getResultList();
            for (Integer s : result) {
                System.out.println("s = " + s);
            }*/

            /*String query = "select nullif(m.username, '관리자') as username from Member m";
            List<String> resultList = em.createQuery(query, String.class)
                    .getResultList();
            for (String s : resultList) {
                System.out.println("s = " + s);
            }*/

           /* String query =
                    "select " +
                            "case when m.age <= 10 then '학생요금' " +
                            "     when m.age >= 60 then '경로요금' " +
                            "     else '일반요금' " +
                            "end " +
                            "from Member m";
            List<String> result = em.createQuery(query, String.class)
                    .getResultList();
            for (String s : result) {
                System.out.println("s = " + s);
            }*/

           /* String query = "select m.username, 'HELLO', TRUE From Member m " +
                    "where m.type = :userType";
            List<Object[]> result = em.createQuery(query)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();

            for (Object[] objects : result) {
                System.out.println("objects = " + objects[0]);
                System.out.println("objects = " + objects[1]);
                System.out.println("objects = " + objects[2]);
            }*/

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
