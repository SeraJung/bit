/* 질문 : 
 - 파일을 복제하는 기능을 구현하세요
 - $ Test02 /home/bit/git/bit1/java02/img1.jpeg(엔터)
 - => img1.jpg 파일을 복제하여 img(1).jpg를 생성
 
 - 힌트 : 출력은 FileOutputStream 클래스를 사용하라!
 */
package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
  
  public static void main(String[] args) {
    FileInputStream in = null;
    FileOutputStream out = null;
    try{
      in = new FileInputStream(args[0]);
      
      
     /* split()안에 '\\.'을 쓰는 이유는 '.'만 사용하면 인식하지 못한다.
      * 자세한 내용은 구글에 정규표현식 찾아보기.
       
      String arr[] = args[0].split("\\.");
      String newFileName = arr[arr.length-2]+"-01."+arr[arr.length-1];*/
      int index = args[0].lastIndexOf('.');
      String newFileName = args[0].substring(0, index)+"-01"+
      args[0].substring(index);
      //String newFileName = (String) args[0].replace(".", "-01.");
      out = new FileOutputStream(newFileName);
      
      int b = -1;
      int count = 0;
      //2) read()를 통해 1바이트 읽기
      //리턴 타입이 int라 해서 4바이트를 읽는 것은 아니다.
      while( (b = in.read()) != -1){        
        out.write(b);
      }     
      System.out.println(args[0]+"파일을 복사하여 "+ newFileName
          + "파일을 생성하였습니다.");
    }catch(FileNotFoundException ex){
      System.out.println("img1.jpeg 파일을 찾을 수 없습니다.");
    }catch(IOException ex){
      System.out.println("읽기 오류!");
    }finally{
      // 3) File이나 Databace, Socket 등의 자원을 사용한 다음
      //명시적으로 해제해야한다.
      //close () 하다가 예외 발생시 => 아무것도 안한다.
      try{
        in.close();
        out.close();
        }catch(IOException ex){}
      
    }
  }

}
