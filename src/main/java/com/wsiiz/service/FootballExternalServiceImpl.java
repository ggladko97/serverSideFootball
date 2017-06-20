package com.wsiiz.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wsiiz.dao.CompetitionDaoImpl;
import com.wsiiz.dao.TeamDao;
import com.wsiiz.dao.TeamDaoImpl;
import com.wsiiz.domain.Competition;
import com.wsiiz.domain.Team;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ggladko97 on 19.06.17.
 */
@Service
public class FootballExternalServiceImpl implements FootballExternalService {

  @Autowired
  private TeamDaoImpl teamDao;

  @Autowired
  private CompetitionDaoImpl competitionDao;

  @Override
  public void getCompetition(int season) throws MalformedURLException {
    URL url = new URL("http://api.football-data.org/v1/competitions/?season" + season);
    JsonArray jsonObject = (JsonArray) performRequest(url);
    for (int i = 0; i < jsonObject.size(); i++) {
      JsonObject singleObj = jsonObject.get(i).getAsJsonObject();
      Competition competition = new Competition();
      competition.setId(singleObj.get("id").getAsInt());
      competition.setCaption(singleObj.get("caption").getAsString());
      competition.setLeague(singleObj.get("league").getAsString());
      competition.setYear(singleObj.get("year").getAsInt());
      competition.setNumberOfGames(singleObj.get("numberOfGames").getAsInt());
      competition.setNumberOfTeams(singleObj.get("numberOfTeams").getAsInt());
      competitionDao.insert(competition);
    }

    System.out.println("GET COMPETITION " + jsonObject);
  }

  @Override public void getTeam(int competitonId) throws MalformedURLException  {
    URL url = new URL("http://api.football-data.org/v1/competitions/398/teams");
    JsonObject jsonObject = (JsonObject) performRequest(url);
    System.out.println("GET TEAM " + jsonObject);
    JsonArray teams = jsonObject.get("teams").getAsJsonArray();

    for (int i = 0; i < teams.size(); i++) {
      JsonObject singleTeam = teams.get(i).getAsJsonObject();
      Team team = new Team();
      team.setName(singleTeam.get("name").getAsString());
      team.setMarketValue("undef");
      team.setCrestUrl(singleTeam.get("crestUrl").getAsString());
      teamDao.insert(team);
    }
    System.out.println("GET TEAM ARRAY OF TEAMS: " + teams);
  }

  @Override public void getLegueTable(int competitonId) throws MalformedURLException  {
    URL url = new URL("http://api.football-data.org/v1/competitions/" + competitonId + "/leagueTable");
    JsonObject jsonObject = (JsonObject) performRequest(url);
    System.out.println("GET Table " + jsonObject);
  }

  @Override public void getFixtures(int competitonId, int matchDay) throws MalformedURLException {
    URL url = new URL(" http://api.football-data.org/v1/competitions/"+
        competitonId+ "/fixtures?matchday="+ matchDay);
    JsonObject jsonObject = (JsonObject) performRequest(url);
    System.out.println("GET fix " + jsonObject);
  }

  @Override public void headToHead(int fixtureId) throws MalformedURLException {
    URL url = new URL("http://api.football-data.org/v1/fixtures/" + fixtureId);
    JsonObject jsonObject = (JsonObject) performRequest(url);
    System.out.println("GET HtH " + jsonObject);
  }

  private Object performRequest (URL url) {

    try {
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput(true);
      connection.setDoOutput(true);
      connection.setRequestProperty("X-Auth-Token", "1be70cdea5d2462ba93c20e11c19675b");

      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

      StringBuffer jsonString = new StringBuffer();
      String line;

      while ((line = br.readLine()) != null) {
        jsonString.append(line);
      }

      JsonParser parser = new JsonParser();
      Object obj = new Object();
      if (parser.parse(jsonString.toString()).isJsonObject()) {
        obj = parser.parse(jsonString.toString()).getAsJsonObject();
      } else if (parser.parse(jsonString.toString()).isJsonArray()) {
        obj = parser.parse(jsonString.toString()).getAsJsonArray();
      }


      System.out.println("Response: " + obj);
      br.close();
      connection.disconnect();
      return obj;
    } catch (IOException e) {

    }
    return null;
  }

  public void setTeamDao(TeamDaoImpl teamDao) {
    this.teamDao = teamDao;
  }

  public TeamDaoImpl getTeamDao() {
    return teamDao;
  }

  @Override public void insert(Team team) {
    teamDao.insert(team);
  }

  @Override public void updateTeam(Team team) {
    teamDao.updateTeam(team);
  }

  @Override public List<Team> listTeam() {
    return teamDao.listTeam();
  }

  @Override public Team getTeamById(int id) {
    return teamDao.getTeamById(id);
  }

  @Override public void removeTeam(int id) {
    teamDao.removeTeam(id);
  }
}
