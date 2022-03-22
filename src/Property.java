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
            message = player.getName() + " decided to buy";
            owner = player;
               player.buyProperty(cost,id);
        }
        return message;
    }

    protected String onReject(Player player) {
        String message = "";
        if (this.currentOption.equals("buy")) {
            message = player.getName() + " decided NOT to buy";
        }
        return message;
    }

    public String onLand(Player player) {
        String message = super.onLand(player);

        if (owner == null) {
            currentOption = "buy";
            message += "Vil du købe? Y for ja, N for nej";
        } else if (owner == player) {
            currentOption = "build"; //Currentoption build
            message += "Du ejer denne grund, vil du opgradere dit grund? Y for ja, N for nej";
        } else {
            currentOption = "payRent"; //Currentoption payRent
            message += "Betal husleje";
        }

        return message;
    }
}
