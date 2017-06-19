package com.wsiiz.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ggladko97 on 19.06.17.
 */
@Entity
public class Team {
  private int id;
  private String name;
  private String marketValue;
  private String crestUrl;

  @Id
  @Column(name = "id", nullable = false)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name", nullable = false, length = -1)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "marketValue", nullable = false, length = 20)
  public String getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(String marketValue) {
    this.marketValue = marketValue;
  }

  @Basic
  @Column(name = "crestUrl", nullable = false, length = -1)
  public String getCrestUrl() {
    return crestUrl;
  }

  public void setCrestUrl(String crestUrl) {
    this.crestUrl = crestUrl;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Team team = (Team) o;

    if (id != team.id) return false;
    if (name != null ? !name.equals(team.name) : team.name != null) return false;
    if (marketValue != null ? !marketValue.equals(team.marketValue) : team.marketValue != null) {
      return false;
    }
    if (crestUrl != null ? !crestUrl.equals(team.crestUrl) : team.crestUrl != null) return false;

    return true;
  }

  @Override public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (marketValue != null ? marketValue.hashCode() : 0);
    result = 31 * result + (crestUrl != null ? crestUrl.hashCode() : 0);
    return result;
  }
}
