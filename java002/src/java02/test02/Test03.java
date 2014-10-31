/* 질문 : 
 - 예외 처리 강화
 파일을 읽을때 
 1) 파일이 존재하지 않으면 다음 문장 출력
   xxx.xxx 파일이 존재 하지 않습니다.
 2) 디렉토리라면
   xxx.xxx 는 파일이 아니라 디렉토리 입니다.
 파일을 쓸때
 1) 파일이 이미 존재한다면, 
    xxx.xxx 파일이 이미 존재합니다. 덮어 쓰시겠습니까?(y/n)y
    xxx.xxx파일을 출력하였습니다.
 2) 파일이 존재 하지 않는다면.
   xxx.xxx를 출력하였습니다.
   
 */
package java02.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test03 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FileInputStream in = null;
    FileOutputStream out = null;

    try {
      File file = new File(args[0]);
      if (!file.exists()) {
        System.out.println(args[0] + " 파일이 존재 하지 않습니다.");
        return;
      } else if (file.isDirectory()) {
        System.out.println(args[0] + " 파일이 아니라 디렉토리 입니다.");
        return;
      }

      int index = args[0].lastIndexOf('.');
      String newFileName = args[0].substring(0, index) + "-01"
          + args[0].substring(index);

      File outputFile = new File(newFileName);
      if(outputFile.exists()) {
        System.out.println(newFileName + "파일이 이미 존재합니다. 덮어 쓰시겠습니까?(y/n)");

        if (! scanner.nextLine().equals("y")) {
          return;
        }
      }
      in = new FileInputStream(args[0]);
      out = new FileOutputStream(newFileName);

      int b = -1;

      while ((b = in.read()) != -1) {
        out.write(b);
      }

      System.out.println(args[0] + "파일을 복사하여 " + newFileName
          + "파일을 생성하였습니다.");



    } catch (IOException ex) {
      System.out.println("읽기 오류!");
    } finally {
      try {in.close();} catch (Exception ex) {}
    try {out.close();} catch (Exception ex) {}

    }
  }

}
