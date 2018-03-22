package CarPark;

/**
 * Created by Lakjeew on 10/20/2017.
 */
public interface CarParkManager {

    public  abstract void AddVehicle();
    public abstract void RemoveVehicle();
    public abstract void Print_Parked_Vehicles();
    public abstract void options(String opt);
    public abstract void Vehicle_Percentages();
    public abstract void longTime_Parked();
    public abstract void lastVehicle();
    public abstract void specificDay_Vehicles();
}
