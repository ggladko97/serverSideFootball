package com.wsiiz.dao;

import com.wsiiz.domain.Competition;
import java.util.List;

/**
 * Created by ggladko97 on 19.06.17.
 */
public interface CompetitionDao {
  void insert(Competition competition);
  void updateCompetition(Competition competition);
  List<Competition> listCompetition();
  Competition getCompetitionById(int id);
  void removeCompetition(int id);
}
