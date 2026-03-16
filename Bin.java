package wastewise;

public class Bin {

    int binId;
    int capacity;
    int load;

    public Bin(int binId,int capacity){
        this.binId = binId;
        this.capacity = capacity;
        this.load = 0;
    }

    public boolean canAdd(int waste){
        return load + waste <= capacity;
    }

    public void addWaste(int waste){
        load += waste;
    }

    public void empty(){
        load = 0;
    }

    public void display(){
        System.out.println("Bin "+binId+" : "+load+"/"+capacity);
    }
}
