import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {


    ArrayList<String> readGameData() {
        File file = new File("src/data_.txt");
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
  /*  ArrayList<String> readFieldData() {

        File file = new File("Field.txt");
        ArrayList<String> field = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                field.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {

            field = null;

        }
        return field;
}*/
}