package label;

public class TestLabel {

  public static int testBreak() {
    int res = 0;

    // 50
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (j % 6 == 5)
          break;
        res++;
      }
    }
    return res;
  }

  // 5
  public static int testBreakLabel() {
    int res = 0;

    breakLabel: {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          if (j % 6 == 5)
            break breakLabel;
          res++;
        }
      }
    }
    return res;
  }

  // 95 
  public static int testContinue() {
    int res = 0;

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (j % 6 == 5)
          continue;
        res++;
      }
    }
    return res;
  }

  public static int testContinueLabel() {
    int res = 0;

    continueLabel: for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (j % 6 == 5)
          continue continueLabel;
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Break: " + testBreak());
    System.out.println("Break Label: " + testBreakLabel());
    System.out.println("Continue: " + testContinue());
    System.out.println("Continue Label: " + testContinueLabel());
  }

}
