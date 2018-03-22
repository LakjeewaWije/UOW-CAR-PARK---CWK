package CarPark;


import java.util.Scanner;

/**
 * Created by Lakjeew on 10/19/2017.
 */
public abstract class Vehicle {
   static Scanner sc= new Scanner(System.in);

    private String vehicle_Id;
    private String brand;
    private String type;
    DateTime d_t  = new DateTime();


    public Vehicle(){

    }

    public Vehicle( String vehicle_Id, String brand, String type, int day, int month, int year, int hour) {

        this.vehicle_Id = vehicle_Id;
        this.brand = brand;
        this.type = type;
        d_t.setDay(day);
        d_t.setMonth(month);
        d_t.setYear(year);
        d_t.setHour(hour);
        
    }
    

    public abstract void addVehicle();


    public String getVehicle_Id() {
        return vehicle_Id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

   
}
