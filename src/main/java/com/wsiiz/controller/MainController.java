package com.wsiiz.controller;

import com.wsiiz.domain.Team;
import com.wsiiz.service.FootballExternalService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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

  @RequestMapping(value = "/getTeams-season-{season}", method = RequestMethod.GET)
  public @ResponseBody List<Team> getTeams(@PathVariable int season) throws IOException {
    service.getTeam(season);
    return service.listTeam();
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
