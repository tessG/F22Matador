public class Board {
    Field[] fields = new Field[40];
    String[] data;


    public Board(String[] data){
        this.data = data;
        createFields(data);
    }

    public void createFields(String[] data){
        for(int i = 0; i < data.length; i++){
            String[] tmpData = data[i].split(",");
            int ID = Integer.parseInt(tmpData[0]);
            int cost = Integer.parseInt(tmpData[3]);
            int income = Integer.parseInt(tmpData[4]);
            int seriesID = Integer.parseInt(tmpData[5]);
            String fieldType = tmpData[1];
            Field field = null;

            switch(fieldType){
                case "Plot":
                        field = new Plot(ID, tmpData[2], cost, income, seriesID);
                        break;
                case "Business":
                        field = new Business(ID, tmpData[2], cost, income, seriesID);
                        break;
                case "Tax":
                        field = new Tax(ID, tmpData[2], cost, income);
                        break;
                        //alle felttyper instansieres  her
            }


            fields[i] = field;
        }
    }

    public Field getField(int num){

        return fields[num-1];
    }

}
