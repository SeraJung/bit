/* 명령을 처리하는 매서드를 별도의 클래스 분리 -> command패턴
 * 새로운 멸영어를 추가하더라도 기존코드르 손대지 않고
 * 명령을 처리하는 메서드 클래스도 만든다.
 * 클래스는 외부 파일이기 때문에 추가하기 쉽다.
 */
package java02.test06.command;

import java.util.Map;
import java02.test06.Command;
import java02.test06.Score;
import java02.test06.ScoreDao;

public class ListCommand implements Command {

  public String getCommandInfo() {
    return "list";
  }

  public void service(Map<String, Object> params) throws Exception {
    ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
    int index = 0;
    for (Score score : scoreDao.getList() ){
      System.out.printf("%-3d %-10s %3d %3d %3d\n",
      index, score.getName(), score.getKor()
      , score.getEng(), score.getMath());
      index ++;
    }

  }

}
