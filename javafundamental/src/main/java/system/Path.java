package system;

import java.io.File;

public class Path {

  public static void testUserDir(){
    String path = System.getProperty("user.dir");
    File file = new File(path);
    String parentPath = file.getParent();
    String logPath = parentPath + "/20151104/taskid";
    System.out.println( logPath );
  }
  
  public static void testOS(){
    String os = System.getProperty("os.name");
    if (os != null && os.startsWith("Windows")) { 
      System.out.println("Windows!");
    }else if( os != null && os.indexOf("Linux") > 0){
      System.out.println("Linux!");
    }
  }
  public static void main(String[] args) {
    testOS();
  }

}
