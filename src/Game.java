import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();
    private FileIO fileIO= new FileIO();
    private TextUI textUI = new TextUI();
    private Dice dice = new Dice();
    private Player currentPlayer;
    Board board;

    public Game() {
        gameSetup();
    }

    /*
     *    name: gameSetup
     *    description: loads both game state data (for creating players) and data for building the board
     *                 if no state data is found, user will be asked for player names
     *
     */
    private void gameSetup() {
        //**********************
        // Load af spiller data
        // **********************
        ArrayList<String> data;
        data =  fileIO.readGameData();
        if(data == null){

            data = textUI.getPlayerNames("Skriv spillernavn. Tast Q for at quitte");
        }
        this.createPlayers(data);
        //**********************
        // Load af felt data
        // **********************
        String[] fieldData = fileIO.readFieldData();
        board = new Board(fieldData);

    }


    public void playGame() {
        int next = 0;
        String input = "";
        while (!input.equalsIgnoreCase("Q")){

            this.currentPlayer = this.players.get(next);
            textUI.displayMessage(this.currentPlayer.getName() + "'s tur");

            takeTurn();

            next++;
            input = textUI.getUserInput("Klar til en ny runde? \n Tast C for continue eller Q for quit" );

        }
        textUI.displayMessage("Tak for denne gang");
        endGame();
    }


    /**
     * Kast terninger
     * Vis hvad der blev slået
     * opdater spillerens position på brættet
     * Få fat i feltet spilleren er landet på
     * Få fat i den besked spilleren skal se når han lander på det felt
     * Vis beskeden og afvent spillerens svar
     * modtag og send svaret til feltet
     * vis spillerens saldo
     */

    private void takeTurn(){
        int diceValue =  1;//dice.rollDiceSum();
        textUI.displayMessage(this.currentPlayer.getName()+" slog "+diceValue);
        int position = currentPlayer.updatePosition(diceValue);
        Field f = board.getField(position);
        String decisionRequest = f.onLand(currentPlayer);
        String response = textUI.getUserInput(decisionRequest);
        String processedResponse = f.processResponse(currentPlayer, response);
        System.out.println(processedResponse);
    }

    private void createPlayers(ArrayList<String> data){

        for (String s : data) {
            String[] values = s.split(", "); //split arrayet så vi får adskildt de to værdier
            int balance;

            if (values.length > 1) {
                balance = Integer.parseInt(values[1]);
            } else {
                balance = Integer.parseInt("30000");
            }
            Player p = new Player(values[0], balance); // brug de to værdier til at lave en ny Player instans

            players.add(p);                            // tilføj Player instansen til array'et af spillere

        }

    }





    public String getPlayers(){
        return this.players.toString();
    }

    private void endGame() {
        fileIO.saveGameData(players);
    }
}
