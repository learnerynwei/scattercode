package hiho;

import java.util.Iterator;
import java.util.Scanner;

public class hihoKMP {
  private String str = null;
  private String pat = null;
  private int next[] = null;

  public void setUp( String string, String pattern){
    this.str = string;
    this.pat = pattern;
    getNext();
  }

  private void getNext(){
    int parLen = pat.length();
    next = new int[parLen];
    next[0] = -1;
    for( int i=1; i < parLen; ++i){
      int k = next[i-1];
      while( true ){
        if( k == -1){
          next[i] = 0;
          break;
        }else{
          if( pat.charAt(k) == pat.charAt(i-1) ){
            next[i] = k + 1;
            break;
          }else{
            k = next[k];
          }
        }
      }
    }
  }

  public void printNext(){
    System.out.println(pat);
    for (int i : next) {
      System.out.print(i + "\t");
    }
    System.out.println();
  }

  public int match(){
    int res = -1;
    int i, j;
    i = j = 0;

    while( i < str.length() && j < pat.length() ){
      if( str.charAt(i) == pat.charAt(j)){
        i++;
        j++;
      }else{
        if( j == -1){
          i++;
          j = 0;
        }else{
          j = next[j];
        }
      }
    }

    if( j == pat.length() )
      res = i - pat.length();
    return res;
  }

  public int matchTimes(){
    int res = 0;
    int i, j;
    i = j = 0;

    while( i < str.length() ){
      if( j == -1 ||
          j != -1 && str.charAt(i) == pat.charAt(j)){
        i++;
        j++;
        if( j == pat.length() ){
          res++;
          //i = i - pat.length() + 1;
          i = i - 1;
          j = next[j-1];
        }
      }else{
        j = next[j];
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    hihoKMP kmp = new hihoKMP();
    int N = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < N; i++) {
      String pattern = sc.nextLine();
      String string = sc.nextLine();
      kmp.setUp(string, pattern);
      System.out.println(kmp.matchTimes());
    }
  }
}
