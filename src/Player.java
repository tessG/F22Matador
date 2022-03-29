public class Player {
    private String name;
    private BankAccount account;
    private int currentPosition = 1;


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


    //Lucas' gruppe

    public int getCurrentPosition(){
        return currentPosition;
    }

    public int updatePosition(int roll){
        currentPosition += roll;
        if(currentPosition > 40){
            currentPosition -= 40;
        }
        return currentPosition;
    }



    public void buyProperty(int amount, int id){
        this.account.doTransaction(-amount);
    }

    private void receiveMoney(int amount){
        this.account.doTransaction(amount);
    }

    public void payRent(int amount, Player recipient){
        boolean result = this.account.doTransaction(-amount);
        if (result) {
            recipient.account.doTransaction(amount);
        }

    }


}
