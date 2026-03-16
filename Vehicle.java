package wastewise;

public class Vehicle {

    int vehicleId;
    String driver;

    public Vehicle(int id,String driver){
        vehicleId = id;
        this.driver = driver;
    }

    public void collect(int binId){

        System.out.println(
            "Vehicle "+vehicleId+
            " Driver "+driver+
            " collecting waste from Bin "+binId
        );
    }
}
