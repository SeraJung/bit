package java02.test07.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
  ArrayList<String> list = new ArrayList<String>();
  String basePak;
  public ClassFinder(String basePakage){
    this.basePak = basePakage;
  }
  
  public List<String> getClassList(){
    return list;
  }
  
  public void find(String path){
    //System.out.println(path);
    try{
      
      File file = new File(path);
      if(file.isFile()){
        if(file.getName().endsWith(".class")){
          String className = path.substring(6).replace('/', '.')
              .replace('\\', '.').replaceAll("\\.class", "");
          if(className.startsWith(basePak)){
            //System.out.println(className);
            list.add(className);
          }
          //list.add(path);
        }
        return;
      
      } else if(file.isDirectory()){
       
        String[] filenames =  file.list();
        for( String filename : filenames){          
          find(path + "/" +filename);
        }
      }
    }catch (Exception e){
      
    }
   
  }
  
 /* public static void main(String[] args) {
    ClassFinder f = new ClassFinder("java02.test07");
    f.find("./bin");
    List<String> classNames = f.getClassList();
    for(String className: classNames){
      System.out.println(className);
    }
  }*/
}
