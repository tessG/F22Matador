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
        runGameLoop();
        endGame();
    }

    private void endGame() {
        fileIO.saveGame(players);
    }


    private void runGameLoop() {
        int next = 0;
        String input = "";
        while (!input.equalsIgnoreCase("Q")){

            this.currentPlayer = this.players.get(next);
            textUI.displayMessage(this.currentPlayer + "'s tur");
            takeTurn();
            next++;
            input = textUI.getUserInput("Klar til en ny runde? \n Tast C for continue eller Q for quit" );

        }
        textUI.displayMessage("Tak for denne gang");
    }

    private void gameSetup() {
        //**********************
        // Load af spiller data
        // **********************
        ArrayList<String> data;
        data =  fileIO.readGameData();
        // på hver plads i data står der et navn og en saldo fx. "Tobias: 30000"
        if(data == null){
            System.out.println("vi fandt ikke noget data, spørg brugeren");
            //hent data fra brugerinterfacet dvs. spørg brugeren
            data = textUI.getPlayerNames("Skriv spillernavn. Tast Q for at quitte");
        }
        this.createPlayers(data);
        //**********************
        // Load af felt  data
        // **********************
        String[] fieldData = fileIO.readFieldData();
        board = new Board(fieldData);

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
                balance = Integer.parseInt(values[1]); // todo: hvis values[1] == null, skal den sættes til 30000 (maxbeløb)

             } else {
                 balance = Integer.parseInt("30000");
             }
             Player p = new Player(values[0], balance); // brug de to værdier til at lave en ny Player instans

             players.add(p);                            // tilføj Player instansen til array'et af spillere

         }

     }


    /**
     * Kast terninger
     * Vis hvad der blev slået
     * opdater spillerens position på brættet
     * Få fat i feltet spilleren er landet på
     * Få fat i den besked spilleren skal se når han lander på det felt
     * Vis beskeden og gem spillerens svar
     * send svaret til feltet
     * vis spillerens saldo
     *
     */
  /*  private void doTurn(){
        Player currentPlayer = players.get(0); //til test anvender vi bare den første spiller i arrayet
        int diceValue = dice.rollDiceSum();
        textUI.displayMessage(currentPlayer.getName() + (" slog " + diceValue));
        //"Kjeld slog 3"
        int currentPosition =  currentPlayer.updatePosition(diceValue);
        Field f = board.getField(currentPosition); //
        String decisionRequest = f.onLand();
        String onResponseMessage = "";
        if(f.currentOption != null){
            String response = textUI.getUserInput(decisionRequest);
            //"Kjeld er landet på Hvidovrevej"
            onResponseMessage = f.processesResponse(response); //"Handling accepteret"
        }
        textUI.displayMessage(onResponseMessage+"\n"+currentPlayer.getName()+"'s saldo: "+currentPlayer.getBalance());
        //Handling accepteret
        //Kjeld's saldo: 28000
    }*/


    public String getPlayers(){
        return this.players.toString();
     }

}
