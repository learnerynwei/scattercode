package fileencode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileEncode {

  public static void writeLog(String logContent, String level) {

    System.out.println(System.getProperty("file.encoding"));
//    System.setProperty("file.encoding", "GBK");
    System.getProperties().put("file.encoding", "GBK");
    System.out.println(System.getProperty("file.encoding"));
    FileWriter resultFile;
    File myFilePath = new File("D://test.txt");
    try {
      // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
      resultFile = new FileWriter(myFilePath, true);
      PrintWriter myFile = new PrintWriter(resultFile);    
      String strContent = " [ " + level + "] :" + logContent + "\n";
      myFile.println(strContent);
      myFile.close();
      resultFile.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      // e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    writeLog("中文才行！！！", "error");
  }

}
