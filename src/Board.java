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

            Field field = new Field(ID, tmpData[2], tmpData[1] , cost, income, seriesID);
            fields[i] = field;
        }
    }

    public Field getField(int num){

        return fields[num-1];
    }

}
