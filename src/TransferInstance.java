import java.util.Date;

public class TransferInstance {

    private double amount;
    private String receiver;
    private String sender;
    private Date date;

    TransferInstance(double amount, String receiver, String sender, Date date){
        this.amount = amount;
        this.receiver = receiver;
        this.sender = sender;
        this.date = date;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getReceiver(){
        return this.receiver;
    }

    public String getSender(){
        return this.sender;
    }

    public Date getDate(){
        return this.date;
    }
}
