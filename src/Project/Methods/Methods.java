package Project.Methods;

import java.util.Scanner;

public class Methods {

    static Scanner sc = new Scanner(System.in);

    public static int readInt() {
        int i = 0;
        while (true) {

            try {
                i = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Enbart numeriska tecken. Försök igen!");
            }


        }
        return i;
    }

    public static double readDouble() {
        double d = 0;
        while (true) {

            try {
                d = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Enbart numeriska tecken. Försök igen!");
            }


        }
        return d;
    }

    public static String readString() {
        String input = sc.nextLine();
        return input;
    }

    public static String fixString(int wantedSize, String stringToFix) {

        if (stringToFix.length() < wantedSize) {

            while (stringToFix.length() < wantedSize) {

                stringToFix = stringToFix + " ";
            }

            return stringToFix + "   ";
        } else
            return stringToFix.substring(0, wantedSize) + "   ";
    }/**/

    public static void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue: ");
        Methods.sc.nextLine();
    }
}


