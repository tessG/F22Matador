import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {


    ArrayList<String> readGameData() {
        File file = new File("src/data.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());//“Egon: 30000”
            }
        } catch (FileNotFoundException e) {
            data = null;
        }
        return data;
    }




    //Gruppens arbejde:
    public String[] readFieldData() {

        File file = new File("src/fieldData.csv");
        String[] data = new String[40];

        try {
            Scanner scan = new Scanner(file);
            int i = 0; //counter variabel

           String header = scan.nextLine();//Ignorer header
            System.out.println(header);
            while (scan.hasNextLine()) {
                data[i]=scan.nextLine();
                i++;
               // data.add();
            }
        } catch (FileNotFoundException e) {

            data = null;

        }
        return data;
        }

    public void saveGame(ArrayList<Player> players) {

        StringBuilder data = new StringBuilder();
        for(Player p : players){
            data.append(p.getName()).append(":").append(p.getBalance()).append(":").append(p.getCurrentPosition()).append("\n");
        }
        FileWriter writer= null;

        try {
            writer = new FileWriter("src/data.txt");
            writer.write(data.toString());

        }catch (IOException e){
            System.out.println("Could not write to file");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (NullPointerException | IOException e) {
                System.out.println("Couldn't close the FileWriter in saveGameData()");
                e.printStackTrace();
          }
       }
    }
}