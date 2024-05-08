import java.time.LocalDate;
import java.util.HashSet;
public class Pass {
    public static int NEXT_PASS_NUMBER = 1;
    private int credits;
    private int number;
    private boolean active;
    private LocalDate dateActivated;
    private LocalDate dateClosed;
    private Visitor visitor;
    private HashSet<Transaction> transactions;

    public Pass(Visitor aVisitor){
        this.visitor = aVisitor;
        this.credits = 0;
        this.active = false;
        this.dateActivated = null;
        this.dateClosed = null;
        this.transactions = new HashSet<>();

        this.number = Pass.NEXT_PASS_NUMBER;
        Pass.NEXT_PASS_NUMBER++;
    }

    public Visitor getVisitor(){
        return this.visitor;
    }

    public int  getNumber(){
        return this.number;
    }

    public boolean isActive(){
        return this.active;
    }

    /**
     * Activates the pass and records the date
     */
    public void activate(){
        this.active = true;
        this.dateActivated = LocalDate.now();
    }

    /**
     * Deactivates the pass and records the date
     */
    public void deActivate(){
        this.active = false;
        this.dateClosed = LocalDate.now();
    }

    /**
     * Returns the date on which the pass was activated as a string
     * @return the date on which the pass was activated as a string
     */
    public String getDateActivated(){
        String date;

        if (this.dateActivated != null) {
            date = this.dateActivated.toString();
        }
        else{
            date = "The pass has not been activated";
        }

        return date;
    }

    /**
     * Returns the date on which the pass was deactivated as a string
     * @return the date on which the pass was deactivated as a string
     */
    public String getDateDeActivated(){
        String date;

        if (this.dateActivated == null) {
            date = "The pass has not been activated";
        }
        else if (this.dateActivated != null && this.dateClosed == null) {
            date = "The pass is still active";
        }
        else{
            date = this.dateClosed.toString();
        }

        return date;
    }

    public int getCredits(){
        return this.credits;
    }

    public void addCredits(int  numCredits){
        this.credits += numCredits;
    }

    public void useCredits(int numCredits){
        if (numCredits <= this.credits){
            this.credits -= numCredits;
        }
    }

    public int NumberOfTransactions(){
        return this.transactions.size();
    }

    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }

    public void displayDetails(){
        String  status;
        String date;

        if (this.isActive()){
            status = " PASS ACTIVE";
            date = this.getDateActivated();
        }
        else {
            status = " PASS CLOSED";
            date = this.getDateDeActivated();
        }

        System.out.println(this.getVisitor().getNumber() + " credits:" + this.getCredits() + ", " + status + ", " + date);
    }

    public void showTransactions(){
        System.out.println("Type\tCredits\tDate\tDate/time\tID");

        for (Transaction t : this.transactions){
            t.showDetails();
        }
    }
}
