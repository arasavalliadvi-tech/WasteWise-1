package wastewise;

import java.util.*;

public class WasteSystem {

    // Array of bins
    Bin bins[];

    // Complaint LinkedList
    ComplaintLinkedList complaintList = new ComplaintLinkedList();

    // Queue for complaints
    Queue<Complaint> complaintQueue = new LinkedList<>();

    // Circular queue for vehicles
    Queue<Vehicle> vehicles = new LinkedList<>();

    // Priority queue for overflow bins
    PriorityQueue<Bin> overflowBins =
            new PriorityQueue<>((a,b)->b.load-a.load);

    // HashMap Bin lookup
    HashMap<Integer,Bin> binMap = new HashMap<>();

    

    int complaintCounter = 1;

    public WasteSystem(){

        bins = new Bin[3];

        bins[0] = new Bin(101,100);
        bins[1] = new Bin(102,100);
        bins[2] = new Bin(103,100);

        for(Bin b : bins)
            binMap.put(b.binId,b);

        vehicles.add(new Vehicle(1,"Ravi"));
        vehicles.add(new Vehicle(2,"Suresh"));
    }

    public void addWaste(int waste){

        for(Bin b : bins){

            if(b.canAdd(waste)){

                b.addWaste(waste);
                System.out.println("Waste added to Bin "+b.binId);
                return;
            }

            else{

                System.out.println("Bin "+b.binId+" exceeded capacity");

                Complaint c =
                        new Complaint(
                                complaintCounter++,
                                b.binId,
                                "Overflow");

                complaintList.addComplaint(c);
                complaintQueue.add(c);

                overflowBins.add(b);

                callVehicle(b);
            }
        }

        System.out.println("All bins full. Add new bin.");
    }

    private void callVehicle(Bin b){

        Vehicle v = vehicles.poll();

        if(v==null){
            System.out.println("No vehicle available");
            return;
        }

        v.collect(b.binId);

        b.empty();

        vehicles.add(v);
    }

    public void showBins(){

        for(Bin b:bins)
            b.display();
    }

    public void showComplaints(){

        complaintList.showComplaints();
    }

    public void showOverflowPriority(){

        System.out.println("Overflow priority bins:");

        for(Bin b:overflowBins)
            b.display();
    }
}
