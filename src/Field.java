abstract public class Field {
    protected String label;
    private String fieldType; // skal fjernes senere
    protected int id;
    protected int cost;
    protected int income;


    //Feltet minder om hvad for en dialog den har med spilleren
    protected String currentOption;

    public Field(int id, String label, int cost, int income) {
        this.id = id;
        this.label = label;

        this.cost = cost;
        this.income = income;

    }

    public String onLand(Player player) {
        String message = "Du er  landet på "+this.toString()+"\n";

        return message;
    }

    public String processResponse(Player player, String response) {
        String message = "";
        if (response.equalsIgnoreCase("A")) {
            message =  this.onAccept(player);
        } else if (response.equalsIgnoreCase("R")) {
            message =  this.onReject(player);
        }
        return message;
    }

    abstract protected String onAccept(Player player);
    abstract protected String onReject(Player player);

    @Override
    public String toString() {
        return id + " " + label;
    }

}