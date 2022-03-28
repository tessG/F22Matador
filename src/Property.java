public class Property extends Field {
    private int seriesID;
    private Player owner;

    public Property( int id, String label, int cost, int income, int seriesID ) {
        super(id, label, cost, income);
        this.seriesID = seriesID;
    }

    protected String onAccept(Player player) {
        String message = "";
        if (this.currentOption.equals("buy")) {
            message = player.getName() + " købte "+this.label;
            owner = player;
            player.buyProperty(cost,id);
        }else if(this.currentOption.equals("payRent")){
            message = player.getName() + " betalte "+this.income+"kr i husleje til "+this.owner.getName();
            player.payRent(this.income, owner);
        }
        return message;
    }

    protected String onReject(Player player) {
        String message = "";
        if (this.currentOption.equals("buy")) {
            message = player.getName() + " købte IKKE "+this.label;
        }
        return message;
    }

    public String onLand(Player player) {
        String message = super.onLand(player);

        if (owner == null) {
            currentOption = "buy";
            message += "Vil du købe?  \n Tast A for accept, R for reject";
        } else if (owner == player) {
            currentOption = "build"; //Currentoption build
            message += "Du ejer denne grund, vil du opgradere dit grund? \n Tast A for accept, R for for reject";
        } else {
            currentOption = "payRent"; //Currentoption payRent
            message += this.owner.getName()+" ejer denne grund. Betal "+this.income+" i husleje.\n Tast A for accept, R for reject";
        }

        return message;
    }
}
