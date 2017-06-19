package com.wsiiz.dao;

import com.wsiiz.domain.User;
import java.util.List;

public interface UserDao {
  void insert(User blog);
  void updateUser(User blog);
  List<User> listUser();
  User getUserById(int id);
  void removeUser(int id);
}
