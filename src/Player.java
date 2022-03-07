public class Player {
    private String name;
    private BankAccount account;

    public Player(String name, int balance){
        this.name = name;
        //instantier en bankaccount her
        this.account =  new BankAccount(balance);
    }
    public String getName(){
        return name;
    }
    public int getBalance(){
        return account.getBalance();
    }
    @Override
    public String toString(){
        return name+": "+ account.getBalance();

    }

}
