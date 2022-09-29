import java.util.Scanner;

public class UsedCar {
    int i, num;
    String arr[][] = new String[10][5];
    Scanner scan = new Scanner(System.in);

    void inputData() {
        System.out.println("Enter the number of cars : ");
        i = scan.nextInt();
        for (int n = 0; n < i; n++) {
            System.out.println("\nEnter Details for Car " + (n + 1));
            System.out.println("Enter VIN number");
            arr[n][0] = new String(scan.next());
            System.out.println("Enter Make ");
            arr[n][1] = new String(scan.next());
            System.out.println("Enter Year ");
            arr[n][2] = new String(scan.next());
            System.out.println("Enter Mileage ");
            arr[n][3] = new String(scan.next());
            System.out.println("Enter price ");
            arr[n][4] = new String(scan.next());
        }

    }

    void checkInput() {

        for (int n = 0; n < i; n++) {
            try {
                if (arr[n][0].length() != 4) {
                    throw new UsedCarException("Please Enter a Valid VIN");
                } else if (!arr[n][1].equalsIgnoreCase("Ford") && !arr[n][1].equalsIgnoreCase("Honda")
                        && !arr[n][1].equalsIgnoreCase("Toyata") && !arr[n][1].equalsIgnoreCase("Chrysler")) {
                    throw new UsedCarException("Please Enter a Valid Make ");
                } else if (Integer.parseInt(arr[n][2]) <= 1990 || Integer.parseInt(arr[n][2]) >= 2014) {
                    throw new UsedCarException("Please Enter a Valid Year ");
                } else if (Integer.parseInt(arr[n][3]) < 0) {
                    throw new UsedCarException("Please Enter a Valid Mileage ");
                } else if (Integer.parseInt(arr[n][4]) < 0) {
                    throw new UsedCarException("Please Enter a Valid Price");
                }
            } catch (UsedCarException e) {
                System.out.println(e.getMessage());
                arr[n] = null;
            }
        }
    }

    void display() {
        String disp[] = { "VIN", "Make", "Year", "Mileage", "Price" };
        System.out.println("Details of Used Cars with correct Input");
        for (int n = 0; n < i; n++) {
            if (arr[n] == null) {
                continue;
            }
            System.out.println("Details of car " + (n + 1));
            for (int k = 0; k < 5; k++) {
                System.out.println(disp[k] + " : " + arr[n][k]);
            }
        }
    }

    public static void main(String args[]) {
        UsedCar obj = new UsedCar();
        obj.inputData();
        obj.checkInput();
        obj.display();
    }
}
