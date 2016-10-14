package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
  
  public static void testDate(String dateStr){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
    try {
      Date date = sdf.parse(dateStr);
      Date date2 = sdf.parse(dateStr);

      System.out.println(dateStr + " : " + date.toString());
      Calendar ca = Calendar.getInstance();
      ca.setTime(date);
      System.out.println("is after " + ca.getTime().compareTo(date2));
      ca.add(Calendar.DATE, -1);
      System.out.println("is after " + ca.getTime().compareTo(date2));
      //ca.add(Calendar.DATE, -2);
      
      System.out.println(sdf.format(ca.getTime()));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  
    
  }
  
  public static void main(String[] args) {
    testDate("20151130");
  }
}
