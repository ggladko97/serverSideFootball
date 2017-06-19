package com.wsiiz.controller;

import com.wsiiz.dao.UserDao;
import com.wsiiz.domain.User;
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


  private UserDao dao;

  @Autowired
  public void setDao(UserDao dao) {
    this.dao = dao;
  }

  @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
  public @ResponseBody String doLogin() throws IOException {

    URL url = new URL("http://api.football-data.org/v1/competitions/398/teams");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setRequestProperty("X-Auth-Token","1be70cdea5d2462ba93c20e11c19675b");

    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

    StringBuffer jsonString = new StringBuffer();
    String line;

    while ((line = br.readLine()) != null) {
      jsonString.append(line);
    }


    JSONObject responseObject = new JSONObject(jsonString);
    System.out.println("Response: " + responseObject);
    br.close();
    connection.disconnect();

    return "success";
  }



}
