package wastewise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WasteSystem system = new WasteSystem();

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n---- WasteWise ----");
            System.out.println("1 Add Waste");
            System.out.println("2 Show Bins");
            System.out.println("3 Show Complaints");
            System.out.println("4 Show Overflow Priority");
            System.out.println("5 Exit");

            int ch = sc.nextInt();

            switch(ch){

                case 1:
                    System.out.print("Enter waste: ");
                    int w = sc.nextInt();
             
                    system.addWaste(w);
                    break;

                case 2:
                    system.showBins();
                    break;

                case 3:
                    system.showComplaints();
                    break;

                case 4:
                    system.showOverflowPriority();
                    break;

               

                case 7:
                    return;
            }
        }
    }
}