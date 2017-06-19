package com.wsiiz.service;

import java.net.MalformedURLException;

/**
 * Created by ggladko97 on 19.06.17.
 */
public interface FootballExternalService {
  void getCompetition (int season) throws MalformedURLException;
  void getTeam (int competitonId) throws MalformedURLException;
  void getLegueTable (int competitonId) throws MalformedURLException;
  void getFixtures (int competitonId, int matchDay) throws MalformedURLException;
  void headToHead (int fixtureId) throws MalformedURLException;
}
