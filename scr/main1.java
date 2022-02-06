import java.util.Scanner;

public class main1{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Веди команду выход:");
    while(true) {
      String str = sc.next();


      if("выход".equals(str)) {
        break;
      }
    }
  }
}
