package java02.test09.command;

import java.util.Map;
import java02.test09.Score;
import java02.test09.ScoreDao;
import java02.test09.annotation.Command;
import java02.test09.annotation.Component;

@Component("list")
public class ListCommand  {
  //총괄 관리자한테 의존 객체를 주입 받고 싶으면 setter 메서드를 준비하라.
  ScoreDao scoreDao;
  
  //이메서드는 Test01에서 주입한다.
  public void setScoreDao(ScoreDao scoreDao) {
    //System.out.println("List.setScoreDao() 확실히 호출됨.");
    this.scoreDao = scoreDao;
  }

  @Command
  public void doList(Map<String, Object> params) throws Exception {
    //이 메서드가 호출되기 전에 SCoreDao 의존 객체가 저장될 것이기 때문에
    // 다음 코드는 제거한다.
    //ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
    
    int index = 0;
    for (Score score : scoreDao.getList()) {
      System.out.printf("%-3d %-10s %3d %3d %3d\n", 
          index, score.getName(), score.getKor(), 
          score.getEng(), score.getMath());
      index++;
    }
  }
}










