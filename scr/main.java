import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner scannerStr = new Scanner(System.in);
    System.out.println("это тестовый код проверял пуш в репозиторий  и + у меня полетела JDC !");
    String n = "напиши чет- имя например: ) ";
    for (int i = 0; i < 1; i++) {
      try {
        Thread.sleep(1000);
      }catch (InterruptedException e){
        e.printStackTrace();
      }
      System.out.print(n);
    }
    String name = scannerStr.nextLine();
    System.out.println(name + " аккуратно обновляйте JDC)");


  }
}
