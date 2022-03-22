public class Tax extends Consequence {
    public Tax( int id, String label, int cost, int income ) {
        super(id, label, cost, income);
    }


    @Override
    protected String onAccept(Player player) {
        return null;
    }

    @Override
    protected String onReject(Player player) {
        return null;
    }
}
