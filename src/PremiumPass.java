public class PremiumPass extends Pass{
    PremiumPass(Visitor aVisitor){
        super(aVisitor);
    }

    @Override
    public void addCredits(int numCredits){
        int bonusPoints = numCredits / 100 * 20;

        super.addCredits(numCredits + bonusPoints);
    }

    
}
