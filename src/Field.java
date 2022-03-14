public class Field {
    private String label;
    private String fieldType; // skal fjernes senere
    private int id;
    private int cost;
    private int income;
    private int seriesID;
    private Player owner;
    public Field(int id, String label,String fieldType, int cost,int income,int seriesID){
        this.id = id;
        this.label = label;
        this.fieldType = fieldType;
        this.cost = cost;
        this.income = income;
        this.seriesID = seriesID;
    }

    public String onLand(Player player){
        if(fieldType == "plot"){
            if(owner==null){
                return "Vil du købe? Y for ja, N for nej";
            }else if(owner == player){
                return "Du ejer denne grund";
            }else{
                return "Betal husleje";
            }
        }
        return "Do something else";
    }

    public String onProceess(String response){
        return null;
    }

    private String onAccept(Player player){
        return null;
    }

    private void onReject(Player player){

    }

    @Override
    public String toString(){
        return id + " " + label;
    }

}