
public class ld165 {

  public static int compareVersion(String version1, String version2) {
    if (version1 == null || version2 == null)
      return 0;
    int dotIn1 = version1.indexOf('.');
    int dotIn2 = version2.indexOf('.');

    if (dotIn1 > dotIn2)
      return 1;
    else if (dotIn1 < dotIn2)
      return -1;
    else {
      if (dotIn1 != -1) {
        String sub1 = version1.substring(0, dotIn1);
        int res = sub1.compareTo(version2.substring(0, dotIn2));
        if (res != 0)
          return res;
      }
      int index1 = dotIn1 + 1;
      int index2 = dotIn2 + 1;
      while( index1 < version1.length() && index2 < version2.length() ){
        char a = version1.charAt(index1);
        char b = version2.charAt(index2);
        if( a == b){
          index1++;
          index2++;
        }else if( a > b)
          return 1;
        else
          return -1;
      }
      //todo
      if( index1 == version1.length() && index2 == version2.length())
        return 0;
      else if( index1 == version1.length())
        return -1;
      else 
        return 1;
    }
  }
  
  public static int compareVersion2(String version1, String version2) {
    String av1[] = version1.split("\\.");
    String av2[] = version2.split("\\.");
    if( av1.length == 0){
      av1 = new String[1];
      av1[0] = version1;
    }
    if( av2.length == 0){
      av2 = new String[1];
      av2[0] = version2;
    }
    int len = Math.max(av1.length, av2.length);
    for (int i = 0; i < len; i++) {
      Integer str1 =  av1.length <= i ? 0 : Integer.parseInt(av1[i]);
      Integer str2 =  av2.length <= i ? 0 : Integer.parseInt(av2[i]);
      int res = str1.compareTo(str2);
      if( res != 0)    return res;
    }
    return 0;
  }
  
  //error  when: "1.0" "1"
  public static int compareVersion3(String version1, String version2) {
    String av1[] = version1.split("\\.");
    String av2[] = version2.split("\\.");
    if( av1.length == 0){
      av1 = new String[1];
      av1[0] = version1;
    }
    if( av2.length == 0){
      av2 = new String[1];
      av2[0] = version2;
    }
    int len = Math.min(av1.length, av2.length);
    for (int i = 0; i < len; i++) {
      Integer str1 =  Integer.parseInt(av1[i]);
      Integer str2 =  Integer.parseInt(av2[i]);
      int res = str1.compareTo(str2);
      if( res > 0) return 1;
      else if( res < 0) return -1;
    }
    if( av1.length > av2.length) return 1;
    else if( av1.length < av2.length) return -1;
    return 0;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      String version1, version2;
      version1 = ArrayUtils.createVersion();
      System.out.println("Version1: " + version1);
      version2 = ArrayUtils.createVersion();
      System.out.println("Version2: " + version2);
      System.out.println(compareVersion2(version1, version2));
      System.out.println(compareVersion3(version1, version2));
    }
  }
}
