package CarPark;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lakjeew on 10/20/2017.
 */
public class WestMinisterCarParkManager implements CarParkManager{
    public static Scanner sc= new Scanner(System.in);
    public static final int MAX_SLOTS =20;
    public static Vehicle [] Vehicle_Park = new Vehicle[MAX_SLOTS];
    public static ArrayList<Vehicle> Vehicles_Left = new ArrayList<>();

    /*
    Adding a vehicle to the Car Park
     */
    @Override
    public void AddVehicle() {
        try{
        for(int i=0;i<=MAX_SLOTS;i++) {

            if (Vehicle_Park[i] == null && Vehicle_Park[i + 1] == null) {


                System.out.println("Choose Type of the Vehicle by entering following...");
                System.out.println("Press \"c\" for car \"v\" for van \"b\" motorbike ");
                char in = sc.next().charAt(0);
                if (in == 'c' | in == 'C') {
                    Vehicle cr = new Car();
                    System.out.println();
                    cr.addVehicle();
                    System.out.println();
                    break;

                } else if (in == 'v' | in == 'V') {
                    Vehicle v = new Van();
                    v.addVehicle();
                    
                    break;
                } else if (in == 'b' | in == 'B') {
                    Vehicle b = new MotorBike();
                    b.addVehicle();
                    System.out.println();
                    
                    break;
                }
            }

            else if (Vehicle_Park[i] == null && Vehicle_Park[i +1] != null && Vehicle_Park[i +2] ==null) {

                System.out.println("Choose Type of the Vehicle by entering following...");
                System.out.println("Press \"c\" for car \"v\" for van \"b\" motorbike ");
                char in = sc.next().charAt(0);
                if (in  == 'c' | in == 'C') {
                    Vehicle k = new Car();
                    k.addVehicle();
                    break;
                }
                else if (in == 'v' | in == 'V') {
                    Vehicle x = new Van();
                    System.out.println();
                    x.addVehicle();
                    break;
                } else if (in == 'b' | in == 'B') {
                    Vehicle b = new MotorBike();
                    b.addVehicle();
                    break;

                }
            }

            else if ((Vehicle_Park[i] == null && Vehicle_Park[i + 1] != null && Vehicle_Park[i -1] != null) ||
                    (Vehicle_Park[i] == null && Vehicle_Park[i + 1] != null && Vehicle_Park[i -1] == null)) {

                System.out.println("!!! NOT FOR VANS !!!");
                System.out.println("Choose Type of the Vehicle by entering following...");
                System.out.println("Press \"c\" for car  \"b\" motorbike ");
                char in = sc.next().charAt(0);
                if (in == 'c' | in == 'C') {
                    Vehicle c = new Car();
                    //Car cr = (Car) cr;
                    c.addVehicle();
                    
                    break;
                } else if (in == 'b' | in == 'B') {
                    Vehicle b = new MotorBike();
                    b.addVehicle();
                    
                    break;
                }
            }

            else if (Vehicle_Park[i] == null) {

                System.out.println("Choose Type of the Vehicle by entering following...");
                System.out.println("Press \"c\" for car \"v\" for van \"b\" motorbike ");
                char in = sc.next().charAt(0);
                if (in  == 'c' | in == 'C') {
                    Vehicle c = new Car();
                    c.addVehicle();
                    
                    break;
                } else if (in == 'v' | in == 'V') {
                    Vehicle v = new Van();
                    v.addVehicle();
                    
                    break;
                } else if (in == 'b' | in == 'B') {
                    Vehicle b = new MotorBike();
                    b.addVehicle();
                    break;

                }
            }
            else {

            }


        }
        }catch (Exception e){

        }

    }
    /*
    Delete a vehicle from the Park
     */
    @Override
    public void RemoveVehicle() {
        System.out.println("Type the Vehicle ID to Remove the vehicle from the park");
        String in=sc.next();
        WestMinisterCarParkManager d = new WestMinisterCarParkManager();

        try {

            for (int i = 0; i < MAX_SLOTS; i++) {

                if(Vehicle_Park[i] !=null){
                if (Vehicle_Park[i].getVehicle_Id().equals(in)) {

                    if (Vehicle_Park[i].getType().equals("car")) {
                        Car c = (Car) Vehicle_Park[i];
                        System.out.println("Enter Leaving time :");
                        int hour = sc.nextInt();

                        //Adding specific car to a new Vehicle Array
                        Vehicles_Left.add(c);

                        //Inserting the leaving time and calculating the cost
                        System.out.println("Parking Bill is " + d.charge(hour, c));
                        Vehicle_Park[i] = null;//deleting the current Vehicle

                    }
                    if (Vehicle_Park[i].getType().equals("bike")) {
                        MotorBike b = (MotorBike) Vehicle_Park[i];

                        //Inserting the leaving time
                        System.out.println("Enter Leaving time :");
                        int hour = sc.nextInt();

                        Vehicles_Left.add(b);



                        System.out.println("Parking Bill is " + d.charge(hour, b));
                        Vehicle_Park[i] = null;//deleting the object
                    }
                    if (Vehicle_Park[i].getType().equals("van")) {
                        Van v = (Van) Vehicle_Park[i];

                        //Inserting the leaving time
                        System.out.println("Enter Leaving time :");
                        int hour = sc.nextInt();

                        //adding the vehicle to a new array
                        Vehicles_Left.add(v);

                        //printing the price
                        System.out.println("Parking bill is " + d.charge(hour, v));
                        Vehicle_Park[i] = null;//deleting the current vehicle from the array
                        int x = (i + 1);
                        Vehicle_Park[x] = null;//deleting the object
                    }
                }else {
                        System.out.println("Invalid ID or Not available");
                    }

                }
            }
        }catch (Exception e){

        }
    }

    /*
    Display Currently Parked Vehicles
     */
    @Override
    public void Print_Parked_Vehicles() {
        System.out.println("_________________________________");
        System.out.println("       ~ PARKED VEHICLES ~");
        System.out.println("_________________________________");
        Vehicle[] temp_vehicles = new Vehicle[MAX_SLOTS];
        int count=0;
        for(int i=0;i<MAX_SLOTS;i++){
            if(Vehicle_Park[i] !=null){
                temp_vehicles[count]=Vehicle_Park[i];
                count++;
            }
        }

        WestMinisterCarParkManager obj= new WestMinisterCarParkManager();
        obj.outTime_Sort(temp_vehicles);

                try {

                    for (int i = 0; i < MAX_SLOTS; i++) {

                        if (temp_vehicles[i].getType().equals("car")) {
                            Car cr = (Car) temp_vehicles[i];
                            System.out.println("Vehicle Type :" + cr.getType());
                            System.out.println("vehicle ID :" + cr.getVehicle_Id());
                            System.out.println(cr.d_t.getDateandTime());
                            System.out.println("Vehicle Brand :" + cr.getBrand());
                            System.out.println("Vehicle Color :" + cr.getColor());
                            System.out.println("No of doors :" + cr.getNo_of_doors());
                            System.out.println("slot Number/s :" + (cr.getSlot_no() ));

                        }
                        if (temp_vehicles[i].getType().equals("van")) {
                            Van vn = (Van) temp_vehicles[i];
                            Van v_nextSlot = (Van) temp_vehicles[i + 1];
                            System.out.println("Vehicle Type :" + vn.getType());
                            System.out.println("vehicle ID :" + vn.getVehicle_Id());
                            System.out.println(vn.d_t.getDateandTime());
                            System.out.println("Vehicle Brand :" + vn.getBrand());
                            System.out.println("Vehicle Cargo Volume :" + vn.getCargo_Volume());
                            System.out.println("slot Number/s :" + (vn.getSlot_no() ) + " and " + (v_nextSlot.getSlot_no() + 1));
                            i++;


                        }
                        if (temp_vehicles[i].getType().equals("bike")) {
                            MotorBike bk = (MotorBike) temp_vehicles[i];
                            System.out.println("Vehicle Type :" + bk.getType());
                            System.out.println("vehicle ID :" + bk.getVehicle_Id());
                            System.out.println(bk.d_t.getDateandTime());
                            System.out.println("Vehicle Brand :" + bk.getBrand());
                            System.out.println("Vehicle Cargo Volume :" + bk.getEngine_size());
                            System.out.println("slot Number/s :" + (bk.getSlot_no() ));

                        }
                        if (Vehicle_Park[i] == null) {

                        }
                        System.out.println("_______________________________");

                    }
                    } catch(Exception e){

                    }



    }

    /*
    Options processing method
     */
    @Override
    public void options(String opt) {
        WestMinisterCarParkManager op = new WestMinisterCarParkManager();
        switch (opt){
            case "1":
                op.AddVehicle();
                break;
            case "2":
                op.Print_Parked_Vehicles();
                break;
            case "3":
                op.RemoveVehicle();
                break;
            case "4":
                op.Vehicle_Percentages();
                break;
            case "5":
                op.longTime_Parked();
                break;
            case "6":
                op.lastVehicle();
                break;
            case "7":
                op.specificDay_Vehicles();
                break;
            case "X":
            case "x":
                System.exit(0);
                break;
        }

    }

    /*
    Displaying the Percentages of currently Parked Vehicles
     */
    @Override
    public void Vehicle_Percentages() {

        ArrayList<Vehicle> tot_vehicles = new ArrayList<>();
        
        int c_count=0;
        int b_count=0;
        int v_count=0;

        for(int x=0;x<MAX_SLOTS;x++){
            if(Vehicle_Park[x] !=null){
                tot_vehicles.add(Vehicle_Park[x]);

            }
        }
        for(Vehicle k :tot_vehicles){
            if(k.getType().equals("car")){
                c_count++;
            }
            if(k.getType().equals("bike")){
                b_count++;
            }
            if(k.getType().equals("van")){
                v_count++;
            }
        }

        double v_new =v_count/2;
        double tot_count=c_count+b_count+v_new;
        System.out.println("Percentage of Vehicles : ");
        System.out.println("Cars  : "+(c_count/tot_count)*100 +" % ");
        System.out.println("Bikes  : "+(b_count/tot_count)*100 +" % ");
        System.out.println("Vans  : "+(v_new/tot_count)*100 +" % ");

    }

    /*
    Displaying the vehicle tha is parked for a long time in the park
     */
    @Override
    public void longTime_Parked() {
        System.out.println("Vehicle that is parked for a long time  ");
        System.out.println("Enter the current time ");
        int t= sc.nextInt();
        Vehicle[] temp_vehicles = new Vehicle[MAX_SLOTS];
        int count=0;
        for(int x=0;x<MAX_SLOTS;x++){
            if(Vehicle_Park[x] !=null){
                temp_vehicles[count]=Vehicle_Park[x];
                count++;
            }
        }
        leaveTime_Srt(temp_vehicles,t);
        System.out.println("Vehicle that has been parked for a long time is  "+"" +
                "Vehicle ID :"+temp_vehicles[0].getVehicle_Id()+" Type : "+temp_vehicles[0].getType()+" Entry time :"+temp_vehicles[0].d_t.getHour());

    }

    /*
    Displaying the lst vehicle that is  parked in the Park
     */
    @Override
    public void lastVehicle() {
        Vehicle[] temp_vehicles = new Vehicle[MAX_SLOTS];
        int count=0;
        for(int x=0;x<MAX_SLOTS;x++){
            if(Vehicle_Park[x] !=null){
                temp_vehicles[count]=Vehicle_Park[x];
                count++;
            }
        }
        outTime_Sort(temp_vehicles);
        try {
            System.out.println("Last Vehicle that was parked is " +
                    "Vehicle ID :" + temp_vehicles[0].getVehicle_Id() + " Type : " + temp_vehicles[0].getType() + " Entry time :" + temp_vehicles[0].d_t.getHour());
        }catch (Exception e){
            System.out.println("No any Vehicles");
        }
    }

    /*
    Displaying the List of vehicles that was parked in a specific day in a specific year
     */
    @Override
    public void specificDay_Vehicles() {
        System.out.println("Enter the year :");
        int year = sc.nextInt();
        System.out.println("Enter the day :");
        int day = sc.nextInt();
        for(Vehicle v :Vehicles_Left){
            if(v.d_t.getDay()==day && v.d_t.getYear()==year){


                if(v.getType().equals("car")){
                    Car n = (Car) v;
                    System.out.println("Vehicle Id :"+n.getVehicle_Id());
                    System.out.println("Vehicle type :"+n.getType());
                    System.out.println("Vehicle brand :"+n.getBrand());
                }
                else if(v.getType().equals("bike")){
                    MotorBike n = (MotorBike) v;
                    System.out.println("Vehicle Id :"+n.getVehicle_Id());
                    System.out.println("Vehicle type :"+n.getType());
                    System.out.println("Vehicle brand :"+n.getBrand());
                }
                else if(v.getType().equals("van")){
                    Van n = (Van) v;
                    System.out.println("Vehicle Id :"+n.getVehicle_Id());
                    System.out.println("Vehicle type :"+n.getType());
                    System.out.println("Vehicle brand :"+n.getBrand());
                }
                System.out.println("");
                System.out.println("-------------------------------------------------------");

            }
            else {
                System.out.println("No Vehicles has been parked on that day ");
            }

        }


    }


    /*
    Method to sort out the arrays according to last in vehicle
     */
    public void leaveTime_Srt(Vehicle arr[],int currentTime) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1]!=null && arr[j]!=null) {
                    if (currentTime-arr[j - 1].d_t.getHour() < currentTime-arr[j].d_t.getHour()) {
                        //swap
                        Vehicle tmp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
    }

    /*
    method to sort out the arrays according to the order vehicles came in
     */
    public void outTime_Sort(Vehicle arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1]!=null && arr[j]!=null) {
                    if (arr[j - 1].d_t.getHour() <  arr[j].d_t.getHour()) {
                        //swap
                        Vehicle tmp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
    }

    /*
    calculating the amount  charged for the park
     */
    public String charge(int hr,Vehicle v){
        if(hr-v.d_t.getHour()<=3){
            int h = hr-v.d_t.getHour();
            int tot=h*3;
            return tot +" euros";
        }
        if((hr-v.d_t.getHour())>3){
            int h=(hr-v.d_t.getHour())-3;
            int tot=9+(h*1);
            return tot +" euros";
        }
        return null;
    }
    
    public static void main(String[] args) {
       WestMinisterCarParkManager obj = new WestMinisterCarParkManager();

        do {
            System.out.println("________________________________________________________________");
            System.out.println("                            ~ MENU ~ ");
            System.out.println("________________________________________________________________");
            System.out.println("Choose an Option From the followings ...");
            System.out.println("");
            System.out.println("Add Vehicle - 1");
            System.out.println("View the List of Parked Vehicles - 2");
            System.out.println("Delete any Vehicle From the Park - 3 ");
            System.out.println("View the percentage of Vehicles that are currently parked  - 4 ");
            System.out.println("View Vehicle which is parked for a longest time - 5");
            System.out.println("View the last vehicle that is parked  - 6");
            System.out.println("View the Vehicles that are parked in a specific day according to users demand - 7");
            System.out.println("Exit the Application - x or X");
            System.out.println("Enter the specific letter or number to get that service ");
            System.out.println("________________________________________________________________");
            String in = sc.next();
            obj.options(in);
        }while (sc.hasNextLine());
    }
}
