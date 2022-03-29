
import java.util.Random;

public class Dice {
    public int[] rollDice(){
        int[] arr = new int[2];
        Random rd = new Random();
        //arr[0] = rd.nextInt(1,7);
        arr[0] = rd.nextInt(6)+1;
        arr[1] = rd.nextInt(6)+1;
        return arr;
    }

    public int rollDiceSum(){
        int[] arr = rollDice();
        System.out.println(arr[0]+", "+arr[1]);

        return arr[0]+arr[1];
    }
}
