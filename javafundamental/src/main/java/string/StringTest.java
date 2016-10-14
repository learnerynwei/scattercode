package string;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTest {
  public static void subString(String str){
    int start = -1;
    String date = null;
    start = str.indexOf("%");
    if( start == -1){
      start = str.indexOf("#");
      if( start >= 0){
        date = str.substring(start + 1, str.indexOf(".dat"));
      }
    }else{
      date = str.substring(start + 1, str.indexOf(".dat"));
    }

    if( start >= 0)
      System.out.println(date);
  }
  
  public static void TTToString(){
    Timestamp ts = new Timestamp(System.currentTimeMillis());   
    String tsStr = "";   
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
    try {   
        //方法一   
        tsStr = sdf.format(ts);   
        System.out.println(tsStr);   
        //方法二   
        tsStr = ts.toString();   
        System.out.println(tsStr);   
    } catch (Exception e) {   
        e.printStackTrace();   
    }  
  }
  
  public static void StringToDate(){
    String dateStr = "2010/05/04 12:34:23";   
    Date date = new Date();   
    //注意format的格式要与日期String的格式相匹配   
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
    try {   
        date = sdf.parse(dateStr);   
        System.out.println(date.toString());   
    } catch (Exception e) {   
        e.printStackTrace();   
    }  
  }
  
  /**
   * 将日期格式的字符串转换为长整型
   * 
   * @param date
   * @param format
   * @return
   */
  public static long convert2long(String date, String format) {
     format = "yyyy/MM/dd HH:mm";
     SimpleDateFormat sf = new SimpleDateFormat(format);
     try {
      return sf.parse(date).getTime()/1000;
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0L;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    StringTest.StringToDate();
    StringTest.TTToString();
    String str = "2016-6-28 10:48:00";
    Timestamp tt = Timestamp.valueOf(str);
    System.out.println(tt);
    
    str = "2016/6/28 10:49:10";
    System.out.println(convert2long(str, ""));
    
    
    String flagName  = "test.dat";
    String flagPattern = flagName.substring(0, flagName.lastIndexOf(".dat")) 
        + "%.*%" + flagName.substring( flagName.lastIndexOf(".dat"));
    System.out.println(flagPattern);
//    String str = "test0#20151101185021.dat";
//    char a = 0x20;
//    System.out.println(" aa".replace(a, 'b'));
//    
//    StringTest.subString(str);
//    
//    String s;
//    int i;
//    System.out.println("s=" + s);
  }

}
