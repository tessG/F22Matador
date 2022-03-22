public abstract class Consequence extends Field {

    public Consequence(int id, String label, int cost, int income) {
        super(id, label, cost, income);

    }

    public String onLand(Player player) {
        String message = "Du er  landet på " + this.toString() + "\n";
        return message;

    }
}



