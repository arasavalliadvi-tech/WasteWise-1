package wastewise;

public class Complaint {

    int complaintId;
    int binId;
    String message;

    Complaint next;

    public Complaint(int id,int bin,String msg){
        complaintId = id;
        binId = bin;
        message = msg;
        next = null;
    }

    public void show(){
        System.out.println("Complaint "+complaintId+
                " | Bin "+binId+
                " | "+message);
    }
}
