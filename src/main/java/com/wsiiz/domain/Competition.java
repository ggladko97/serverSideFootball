package com.wsiiz.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ggladko97 on 19.06.17.
 */
@Entity
public class Competition {
  private int id;
  private String caption;
  private String league;
  private int year;
  private int numberOfTeams;
  private int numberOfGames;

  @Id @Column(name = "id", nullable = false)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "caption", nullable = false, length = 50)
  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  @Basic
  @Column(name = "league", nullable = false, length = -1)
  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  @Basic
  @Column(name = "year", nullable = false)
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Basic @Column(name = "numberOfTeams", nullable = false)
  public int getNumberOfTeams() {
    return numberOfTeams;
  }

  public void setNumberOfTeams(int numberOfTeams) {
    this.numberOfTeams = numberOfTeams;
  }

  @Basic @Column(name = "numberOfGames", nullable = false)
  public int getNumberOfGames() {
    return numberOfGames;
  }

  public void setNumberOfGames(int numberOfGames) {
    this.numberOfGames = numberOfGames;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Competition that = (Competition) o;

    if (id != that.id) return false;
    if (year != that.year) return false;
    if (numberOfTeams != that.numberOfTeams) return false;
    if (numberOfGames != that.numberOfGames) return false;
    if (caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
    if (league != null ? !league.equals(that.league) : that.league != null) return false;

    return true;
  }

  @Override public int hashCode() {
    int result = id;
    result = 31 * result + (caption != null ? caption.hashCode() : 0);
    result = 31 * result + (league != null ? league.hashCode() : 0);
    result = 31 * result + year;
    result = 31 * result + numberOfTeams;
    result = 31 * result + numberOfGames;
    return result;
  }
}
