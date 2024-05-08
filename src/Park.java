import java.util.HashSet;
public class Park {
    private HashSet<Pass> passes;
    private HashSet<Visitor> visitors;
    private HashSet<Transaction> transactions;

    public Park(){
        this.passes = new HashSet<>();
        this.visitors = new HashSet<>();
        this.transactions = new HashSet<>();
    }

    public void addPass(Pass p){
        this.passes.add(p);
    }

    public void addVisitor(Visitor v){
        this.visitors.add(v);
    }

    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }

    public int numberOfPasses(){
        return this.passes.size();
    }

    public int numberOfVisitors(){
        return this.visitors.size();
    }

    public int numberOfTransactions(){
        return this.transactions.size();
    }

    public void listVisitors(){
        System.out.println("Visitor ID\tName\tAddress\tPost Code\tDate of birth");

        for (Visitor v : this.visitors){
            v.displayDetails();
        }
    }

    public void listPasses(){
        System.out.println("Visitor ID\tCredits\tStatus");

        for (Pass p : this.passes){
            p.displayDetails();
        }
    }

    public Visitor getVisitor (int visitorNumber){
        Visitor visitor = null;

        for (Visitor v : this.visitors){
            if (v.getNumber() == visitorNumber){
                visitor = v;
            }
        }

        return visitor;
    }

    public Pass getPass (int passNumber){
        Pass pass = null;

        for (Pass p : this.passes){
            if (p.getNumber() == passNumber){
                pass = p;
            }
        }

        return pass;
    }


}
