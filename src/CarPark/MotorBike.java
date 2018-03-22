package CarPark;

/**
 * Created by Lakjeew on 10/20/2017.
 */
public class MotorBike extends Vehicle {
    private String engine_size;
    private int Slot_no;

    public int getSlot_no() {
        return Slot_no;
    }

    public String getEngine_size() {
        return engine_size;
    }
    public MotorBike(){

    }


    public MotorBike(String vehicle_Id, String brand, String type, int day, int month, int year, int hour, String engine_size,int slot_no) {

        super(vehicle_Id, brand, type, day, month, year, hour);
        this.engine_size = engine_size;
        this.Slot_no=slot_no;
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
        String type = "bike";
        System.out.println("Type:bike");
        System.out.println("Enter Engine Size :");
        String engine_size = sc.next();

        for (int i = 0; i < WestMinisterCarParkManager.MAX_SLOTS; i++) {
            if (WestMinisterCarParkManager.Vehicle_Park[i] == null) {
                System.out.print(" |  " + (i + 1));
            }
        }
        int in = sc.nextInt();
        if (WestMinisterCarParkManager.Vehicle_Park[in - 1] != null) {
            System.out.println("You can't enter a bike to an occupied slot");
        } else {
            Vehicle b = new MotorBike(v_ID, brand, type, day, month, year, hour, engine_size, in);

            WestMinisterCarParkManager.Vehicle_Park[(in - 1)] = b;

        }
    }
}
