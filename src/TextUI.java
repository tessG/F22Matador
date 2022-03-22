import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {


    public ArrayList<String> getPlayerNames(String message) {
        ArrayList<String> data = new ArrayList<>();
        //Vis brugeren beskeden

        String input = "";
        Scanner scan = new Scanner(System.in);


        while(data.size() < 6){
            System.out.println(message);

            input = scan.nextLine(); //Programmet går i stå og venter på at brugeren taster enter
         //MED MINDRE
            if(input.equalsIgnoreCase("Q")) {
               break;
               }
            data.add(input);

        }

        return data;

    }


    public void displayMessage(String msg){

        System.out.println(msg);
    }


    public String getUserInput(String message)
    {
        displayMessage(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(input.equalsIgnoreCase("Y")|| input.equalsIgnoreCase("N"))
        {
            System.out.println("Dit svar er ikke gyldigt. Dit svar skal være y eller n. Prøv igen");
            getUserInput(message);
        }

        return input;
    }


}
