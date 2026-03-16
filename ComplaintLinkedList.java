package wastewise;

public class ComplaintLinkedList {

    Complaint head;

    public void addComplaint(Complaint c){

        if(head == null){
            head = c;
            return;
        }

        Complaint temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = c;
    }

    public void showComplaints(){

        Complaint temp = head;

        while(temp != null){
            temp.show();
            temp = temp.next;
        }
    }
}
