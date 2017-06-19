package com.wsiiz.controller;

import com.wsiiz.dao.UserDao;
import com.wsiiz.domain.User;
import com.wsiiz.service.FootballExternalService;
import com.wsiiz.service.FootballExternalServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ggladko97 on 16.06.17.
 */
@RestController
@RequestMapping("/")
public class MainController {


  @Autowired
  private FootballExternalService service;


  @RequestMapping(value = "/getCompetition", method = RequestMethod.GET)
  public @ResponseBody String getCompetition ()
      throws MalformedURLException {
    service.getCompetition(2016);
    return "success";
  }

  @RequestMapping(value = "/getTeams", method = RequestMethod.GET)
  public @ResponseBody String getTeams() throws IOException {
    service.getTeam(2015);
    return "success";
  }
  @RequestMapping(value = "/getLegueTable", method = RequestMethod.GET)
  public @ResponseBody String getLegueTable() throws IOException {
    service.getLegueTable(398);
    return "success";
  }
  @RequestMapping(value = "/getFixtures", method = RequestMethod.GET)
  public @ResponseBody String getFixtures() throws IOException {
    service.getFixtures(398,1);
    return "success";
  }

  @RequestMapping(value = "/headToHead", method = RequestMethod.GET)
  public @ResponseBody String headToHead() throws IOException {
    service.headToHead(149461);
    return "success";
  }


}
