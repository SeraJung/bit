package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Score {		
	String name;
	 int index=0;
	int kor;
	int eng;
	int math;
	
	public Score() {}
	
	public Score(String n, int k, int e, int m) {
		
		name = n; kor = k; eng = e; math = m;
	}
}
public class Exam01 {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Score> list = new ArrayList<Score>();
	static int index = -1;
	static Score score = null;
	
	public static void help(){
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");
	}
	public static void add(String[] str){
		
		
		list.add( new Score( str[1], Integer.parseInt(str[2]),
				Integer.parseInt(str[3]),Integer.parseInt(str[3])));
		System.out.println("저장되었습니다.");
	
	}
	
	
	public static void list(){
		
		 for (int i = 0; i < list.size(); i++) {
		      score = (Score)list.get(i);
		      System.out.print(i + " ");
		      System.out.print(score.name+ " ");
		      System.out.print(score.kor+ " ");
		      System.out.print(score.eng+ " ");
		      System.out.println(score.math);
		    }
	}
	public static void view(int index){
		
		 
		      score = (Score)list.get(index);
		      int sum = score.kor + score.eng + score.math;
		      float average = sum / 3.0f;
		      System.out.println("인덱스 : " +index );
		      System.out.println("이름 : " + score.name);
		      System.out.println("국어 : " + score.kor);
		      System.out.println("영어 : " + score.eng);
		      System.out.println("수학 : " + score.math);
		      System.out.println("합계 : " + sum);
		      System.out.println("평균 : " + average);
		      
		    
	}
	public static void delete(int index){
		if(index>=list.size()){
			System.out.println("존재하지 않는 인덱스 입니다.");
			return;
		}
		System.out.println(list.get(index).name +"의 성적을 삭제하겠습니까?(y/n)");
		if(scanner.nextLine().equals("y")){
			list.remove(index);
			System.out.println("삭제되었습니다.");
		}
	}
	public static void update(int index){
		if(index>=list.size()){
			System.out.println("존재하지 않는 인덱스 입니다.");
			return;
		}
		score = list.get(index);
		String name,kor,eng,math;
		System.out.println("이름 (" + score.name + ") ?");
		name= scanner.nextLine();
		System.out.println("국어(" + score.kor + ") ?");
		kor = scanner.nextLine();
		System.out.println("영어(" + score.eng + ") ?");
		eng = scanner.nextLine();
		System.out.println("수학(" + score.math + ") ?");
		math = scanner.nextLine();
		System.out.println("정말 변경하겠습니까?(y/n)");
		if(scanner.nextLine().equals("y")){
			if(! name.equals(""))
				score.name = name;
			if(!kor.equals(""))
				score.kor = Integer.parseInt(kor);
			if(!eng.equals(""))
				score.eng = Integer.parseInt(eng);
			if(! math.equals(""))
				score.math = Integer.parseInt(math);
		}
		
	}
	public static void exit () throws IOException {
		FileOutputStream out = new FileOutputStream("score1.dat");
	   ObjectOutputStream out2 = new ObjectOutputStream(out);
	    
        ArrayList<Score> list2 = new  ArrayList<Score>();
	    
	    out2.writeObject(list);  
	    
	    for(int i=0;i < list2.size() ; i++){
	    	System.out.println(list2.get(i).name + list2.get(i).kor
	    			+ list2.get(i).eng + list2.get(i).math);
	    }
	    
	    out2.close(); 
	    out.close();
	    System.exit(0);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("score1.dat");
		if(file.exists()){
		 FileInputStream in = new FileInputStream("score1.dat");
		 ObjectInputStream in2 = new ObjectInputStream(in);		 
		 list = (ArrayList<Score>) in2.readObject();
		}
		
		while(true){
			System.out.print("\n명령> ");
			String str1 = scanner.nextLine();
			String[] str2 = str1.split(" ");
			/*for(int i = 0; i< str2.length; i++)
				System.out.print(str2[i]+ "  ");*/
			switch(str2[0]){
			case "help" : help(); break;
			case "add" : add(str2); break;
			case "list" : list(); break;
			case "view" : view(Integer.parseInt(str2[1]));break;			
			case "delete" : delete(Integer.parseInt(str2[1]));break;
			case "update" : update(Integer.parseInt(str2[1]));break;
			case "exit" : exit();
			
			}
			
		}

	}

}
