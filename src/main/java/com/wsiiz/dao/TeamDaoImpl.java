package com.wsiiz.dao;

import com.wsiiz.domain.Team;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggladko97 on 19.06.17.
 */
public class TeamDaoImpl {


  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void insert(Team team) {
    Session session = this.sessionFactory.getCurrentSession();
    session.persist(team);
  }

  @Transactional
  public void updateTeam(Team team) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(team);
  }

  @Transactional
  public List<Team> listTeam() {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from com.wsiiz.domain.Team");
    List<Team> teams = query.list();
    return teams;
  }

  @Transactional
  public Team getTeamById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Team team = (Team) session.get(Team.class,id);
    return team;
  }

  @Transactional
  public void removeTeam(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Team team = (Team) session.get(Team.class,id);
    if (team != null) {
      session.delete(team);
    }
  }
}
