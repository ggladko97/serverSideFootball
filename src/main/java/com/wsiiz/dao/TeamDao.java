package com.wsiiz.dao;

import com.wsiiz.domain.Team;
import java.util.List;


public interface TeamDao {
  void insert(Team team);
  void updateTeam(Team team);
  List<Team> listTeam();
  Team getTeamById(int id);
  void removeTeam(int id);
}
