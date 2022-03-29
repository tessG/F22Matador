public class BankAccount {
    private int balance;

    public BankAccount(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public boolean doTransaction(int amount) {
        //int balanceA = balance + amount;
        this.balance = balance + amount;


        if (balance > 0) {
         //   System.out.println("True");
            return true;
        }
        return false;

    }
}
