package com.wsiiz.service;

/**
 * Created by ggladko97 on 19.06.17.
 */
public interface FootballExternalService {
  void getCompetition (int season);
  void getTeam (int competitonId);
  void getLegueTable (int competitonId);
  void getFixtures (int competitonId, int matchDay);
  void headToHead (int fixtureId);
}
