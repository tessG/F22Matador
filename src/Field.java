import java.util.Optional;

public class Field {
    private String label;
    private String fieldType; // skal fjernes senere
    private int id;
    private int cost;
    private int income;
    private int seriesID;
    private Player owner;
    private String currentOption;

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
                currentOption = "buy";
                return "Vil du købe? Y for ja, N for nej";
            }else if(owner == player){
                return "Du ejer denne grund";
            }else{
                return "Betal husleje";
            }
        }
        return "Do something else";
    }

    public String onProceess(Player player, String response){
     /*   if(response.equalsIgnoreCase("Y")){
            this.onAccept(player);
        }else{
            this.onReject(player);
        }*
        return null;
    }

    private String onAccept(Player player){
      /*  if(this.currentOption.equals("buy")){
            System.out.println(player.getName()+" desided to buy");
            owner=player;
        }*/
        return null;
    }

    private void onReject(Player player){
      /*  if(this.currentOption.equals("buy")){
            System.out.println(player.getName()+" desided NOT to buy");
        }*/
    }

    @Override
    public String toString(){
        return id + " " + label;
    }

}