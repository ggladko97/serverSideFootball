package com.wsiiz.dao;

import com.wsiiz.domain.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ggladko97 on 16.06.17.
 */
@Repository
public class UserDaoImpl implements UserDao {


  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

 @Transactional
  public void insert(User user) {
    Session session = this.sessionFactory.getCurrentSession();
    session.persist(user);
  }

  @Transactional
  public void updateUser(User user) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(user);
  }

  @Transactional
  public List<User> listUser() {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from com.wsiiz.domain.User");
    List<User> users = query.list();
    return users;
  }

  @Transactional
  public User getUserById(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    User user = (User) session.get(User.class,id);
    return user;
  }

  @Transactional
  public void removeUser(int id) {
    Session session = this.sessionFactory.getCurrentSession();
    User user = (User) session.get(User.class,id);
    if (user != null) {
      session.delete(user);
    }
  }
}
