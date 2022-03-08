import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {


    public ArrayList<String> getPlayerNames(String message) {
        ArrayList<String> data = new ArrayList<>();
        //Vis brugeren beskeden

        String input = "";
        Scanner scan = new Scanner(System.in);


        while(!input.equals("Q")){
            System.out.println(message);
            input = scan.nextLine(); //Programmet går i stå og venter på at brugeren taster enter
            data.add(input);
        }

        return data;

    }
}
