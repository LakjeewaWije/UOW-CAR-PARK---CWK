package CarPark;

import java.util.Scanner;

/**
 * Created by Lakjeew on 10/19/2017.
 */
public class Van extends Vehicle {
    private String cargo_Volume;
    private int Slot_no;
    public Van(){

    }



    public Van( String vehicle_Id, String brand, String type, int day, int month, int year, int hour, String cargo_Volume,int slot_no) {
        super( vehicle_Id, brand, type, day, month, year, hour);
        this.cargo_Volume = cargo_Volume;
        this.Slot_no=slot_no;
    }

    public String getCargo_Volume() {
        return cargo_Volume;
    }

    public int getSlot_no() {
        return Slot_no;
    }

    @Override
    public void addVehicle() {
        //date time details

        System.out.println("Enter the day :");
        int day = sc.nextInt();
        System.out.println("Enter the month :");
        int month = sc.nextInt();
        System.out.println("Enter the year :");
        int year = sc.nextInt();
        System.out.println("Enter the hour :");
        int hour = sc.nextInt();

        //vehicle details

        System.out.println("Enter Vehicle ID :");
        String v_ID = sc.next();
        System.out.println("Enter Vehicle brand :");
        String brand = sc.next();
        System.out.println("Enter Vehicle Type :");
        String type = "van";
        System.out.println("Type:van");
        System.out.println("Enter the Cargo Volume :");
        String cargo_Vol = sc.next();

        //checking for empty slots
        for (int i = 0; i < WestMinisterCarParkManager.MAX_SLOTS - 1; i++) {
            if (WestMinisterCarParkManager.Vehicle_Park[i] == null) {
                System.out.print(" |  " + (i + 1));
            }
        }
        int in = sc.nextInt();
        if (WestMinisterCarParkManager.Vehicle_Park[in-1] != null || WestMinisterCarParkManager.Vehicle_Park[in] != null) {
            System.out.println("Enter a vehicle to a empty slot");
        } else {
            if (in == 20 ) {
                System.out.println("You can't add a van to the 20th slot ");
            } else {
                Vehicle v = new Van(v_ID, brand, type, day, month, year, hour, cargo_Vol, in);

                WestMinisterCarParkManager.Vehicle_Park[(in - 1)] = v;

                WestMinisterCarParkManager.Vehicle_Park[in] = v;
            }

        }
    }
}
