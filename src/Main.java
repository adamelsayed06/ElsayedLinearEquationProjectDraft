import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.println("Enter coordinate 1: ");
        String coords = scan.nextLine();
        int a = coords.indexOf(",");
        int len1 = coords.length();

        String x1 = (coords.substring(1, a));
        String y1 = (coords.substring(a+1, len1-1));

        System.out.println("Enter coordinate 2: ");
        String coords2 = scan.nextLine();
        int b = coords2.indexOf(",");
        int len2 = coords2.length();

        String x2 = (coords2.substring(1,b));
        String y2 = (coords2.substring(b+1,len2-1));

        int x1asInt = Integer.parseInt(x1);
        int x2asInt = Integer.parseInt(x2);
        int y1asInt = Integer.parseInt(y1);
        int y2asInt = Integer.parseInt(y2);

        LinearEquation calc = new LinearEquation (x1asInt,y1asInt,x2asInt,y2asInt);


    }
}
