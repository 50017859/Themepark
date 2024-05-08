import java.time.LocalDateTime;
public class Transaction {
    private static int NEXT_TRANSACTION_ID = 1;
    private int id;
    private int credits;
    private LocalDateTime datetime;
    private TransactionType type;

    public Transaction(TransactionType aType, int numCredits){
        this.type = aType;
        this.credits = numCredits;
        this.datetime  = LocalDateTime.now();

        this.id = Transaction.NEXT_TRANSACTION_ID;
        Transaction.NEXT_TRANSACTION_ID++;
    }

    public int getCredits(){
        return this.credits;
    }

    public LocalDateTime getDateTime(){
        return this.datetime;
    }

    public TransactionType getType(){
        return this.type;
    }

    public void showDetails(){
        System.out.println(this.type.toString() + "\t" + this.credits + "\t" + this.datetime.toString() + "\t" + id);
    }
}
