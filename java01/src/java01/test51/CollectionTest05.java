package java01.test51;


class Bucket{
  Object value;
  Bucket next;
}
/* 버킷 관리 */
class MyLinkedList2{

  Bucket start;
  Bucket end;
  int size;
  
  public MyLinkedList2 (){
    start = new Bucket();
    end = start;   
  }
  
  public int add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
    return ++size;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if(index < 0 || index >= this.size) 
      return null;
    
    Bucket cursor = start;
    
    for(int i = 1; i <= index; i++){
      cursor = cursor.next;
    } //for
    return cursor;     
  }
 
  public int insert(int index, String value){
    
    
    if(index < 0 || index > size){ 
      //index가 0보다 크거나 size보다 크면 실행이 안된다.
      System.out.println("인덱스 값을 다시 입력해주세요.. 실행안되요..");
      return -1;      
    }
    Bucket b1 = new Bucket(); //삽입할 값을 넣을 버켓을 생성한다.
    b1.value = value;// 생성한 버켓에 값을 집어 넣는다.
    Bucket cursor = start;
    
    for(int i = 1; i <= index-1; i++){
      cursor = cursor.next;
    }
    size++;
    //삽입할 인덱스 이전의 인덱스 버켓을 찾아온다.
    if(index > 0 && index <= this.size){ 
      //index가 0보다 크거나  size보다 작을때 이 명령문을 실행합니다.
      if(index == size-1){
        cursor.next = b1;  
        end= b1;
      }
      b1.next = cursor.next;
      cursor.next = b1;  
      
    }else if( index == 0){
       //index가 0일때 사용하는 처음에 삽입하는 명령문입니다.
     
      b1.next= start;
      start = b1;
    } 
    
    return 0;   
  }
  
  
  public int remove(int index){
    if(index < 0 || index > size){ 
      //index가 0보다 크거나 size보다 크면 실행이 안된다.
      System.out.println("인덱스 값을 다시 입력해주세요.. 실행안되요..");
      return -1;      
    }
   
    
    Bucket cursor = start; 
    
    
    //삽입할 인덱스 이전의 인덱스 버켓을 찾아온다.
   if( index == 0){
       //index가 0일때 사용하는 처음에 삽입하는 명령문입니다.
     start = start.next;
    }else{
      for(int i = 1; i <= index-1; i++){
        cursor = cursor.next;
      } //삭제할 버켓을 만든다.을 넣을 버켓을 생성한다.

      cursor.next = cursor.next.next;
    }
    size--;
    return 0;   
    
    /*
    Bucket removeBuc =(Bucket) get(index);
    Bucket postCursor = (Bucket) get(index-1);
    if(index < 0 || index > size){ 
      System.out.println("인덱스 값을 잘못 입력하셨어요.");
      return -1;      
    }else if(index > 0 && index < this.size){     
      
      postCursor.next = removeBuc.next;
      
      
    }else if (index == 0){
      Bucket nextBuc = (Bucket) get(1);
      start= nextBuc;
      
    } else if(index == size){
      end  = postCursor;
    }
    size--;
    return 0;    */
   
  }
  
}

public class CollectionTest05 {
  public static void printArray(MyLinkedList4 list) {
    Bucket getValue = new Bucket();
    for (int i = 0; i < list.size(); i++) {
      getValue = (Bucket) list.get(i);      
      System.out.println(getValue.value);
    }// for
  }

  public static void main(String[] args) {
    MyLinkedList4 arr = new MyLinkedList4();
    arr.add("00000");
    arr.add("11111");
    arr.add("22222");
    arr.add("33333");
    arr.add("44444");
    arr.add("55555");
    arr.add("66666");
    arr.add("77777");
   
    System.out.println("-----------------");
    printArray(arr);
    
    System.out.println("-10에 입력: -----------------");
    arr.insert(-10, "-10에 입력");
    printArray(arr);
    
    System.out.println("30에 입력: -----------------");
    arr.insert(30, "30에 입력");
    printArray(arr);
    
    System.out.println("0번에 입력: -----------------");
    arr.insert(0, "!!!!!!");
    printArray(arr);
    
    System.out.println("9번에 입력: -----------------");
    arr.insert(9, "@@@@@@@");
    printArray(arr);
    
    System.out.println("4번에 입력: -----------------");
    arr.insert(4, "######");
    printArray(arr);
    
    System.out.println("-30번 삭제: -------------");
    arr.remove(-30);
    printArray(arr);
    
    System.out.println("30번 삭제: -------------");
    arr.remove(30);
    printArray(arr);
    
    System.out.println("0번 삭제: -------------");
    arr.remove(0);
    printArray(arr);
    
    System.out.println("10번 삭제: -------------");
    arr.remove(10);
    printArray(arr);
    
    System.out.println("4번 삭제: -------------");
    arr.remove(4);
    printArray(arr);
    
    
  }
}












