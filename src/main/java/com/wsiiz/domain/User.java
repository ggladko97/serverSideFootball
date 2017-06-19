package com.wsiiz.domain;

/**
 * Created by ggladko97 on 16.06.17.
 */
public class User {
  private int id;
  private String email;
  private String phone;
  private String team;
  private String password;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (id != user.id) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
    if (team != null ? !team.equals(user.team) : user.team != null) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;

    return true;
  }

  @Override public int hashCode() {
    int result = id;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (team != null ? team.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }
}
