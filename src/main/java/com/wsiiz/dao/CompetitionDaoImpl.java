package com.wsiiz.dao;

import com.wsiiz.domain.Competition;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggladko97 on 19.06.17.
 */
public class CompetitionDaoImpl {


  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void insert(Competition competition) {
    Session session = this.sessionFactory.getCurrentSession();
    session.persist(competition);
  }

  @Transactional
  public void updateCompetition(Competition competition) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(competition);
  }

  @Transactional
  public List<Competition> listCompetition() {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from com.wsiiz.domain.Competition");
    List<Competition> competitions = query.list();
    return competitions;
  }

  @Transactional
  public Competition getCompetitionById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Competition competition = (Competition) session.get(Competition.class,id);
    return competition;
  }

  @Transactional
  public void removeCompetition(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    Competition competition = (Competition) session.get(Competition.class,id);
    if (competition != null) {
      session.delete(competition);
    }
  }
}
