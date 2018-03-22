package CarPark;

import java.util.Scanner;

/**
 * Created by Lakjeew on 10/19/2017.
 */
public class Car extends Vehicle {
    private int no_of_doors;
    private String color;
    private int Slot_no;

    public Car(){

    }

    public Car( String vehicle_Id, String brand, String type, int day, int month, int year, int hour,int no_of_doors,String color,int slot_no) {
        super( vehicle_Id, brand, type, day, month, year, hour);
        this.no_of_doors=no_of_doors;
        this.color=color;
        this.Slot_no=slot_no;

    }

    public int getSlot_no() {
        return Slot_no;
    }

    public void addVehicle() {
        //date time details
        try {
            System.out.println("Enter the day :");
            int day = 12;
            sc.nextInt();
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
            String type = "car";
            System.out.println("Type:car");
            System.out.println("Enter the number of doors :");
            int no_of_doors = sc.nextInt();
            System.out.println("Enter the color :");
            String color = sc.next();
            System.out.println("Select a slot from the following free slots");
            for (int i = 0; i < WestMinisterCarParkManager.MAX_SLOTS; i++) {
                if (WestMinisterCarParkManager.Vehicle_Park[i] == null) {
                    System.out.print(" |  " + (i + 1));
                }
            }
            int in = sc.nextInt();
            if (WestMinisterCarParkManager.Vehicle_Park[in - 1] != null) {
                System.out.println("You can't enter a car to an occupied slot");
            } else {

                Vehicle c = new Car(v_ID, brand, type, day, month, year, hour, no_of_doors, color, in);
                WestMinisterCarParkManager.Vehicle_Park[(in - 1)] = c;


            }
        }catch (Exception e){

        }

    }
    public int getNo_of_doors() {
        return no_of_doors;
    }

    public String getColor() {
        return color;
    }
}
