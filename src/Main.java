//Lav flg klassehierarki:
        //Game has Player has Account
        //Game has TextUI
        //Game has FileIO

//Giv Game klassen flg private felter:
    //  TextUI textui
    //  ArrayList<Player> players
    //  (FileIO fileIO)

//Game klassens konstruktor
    // 1. instanstier TextUI, FileIO og players
    // (kald en privat instansmetode, boolean hasGameData(), som tjekker om der er gamedata på spillet)
        // (gamedata true:  continueOrStartNewDdiaglog())
        // gamedata false: start void registerUsersDialog() på textui
                // 2. Kald FileIO klassens readGameData(),  kald private instansmetode runLoop();

//FileIO klassens readGameData()
    // 3. for hver linje, instantier player(navn og saldo)
    // læg player i Game.players


//NEXT

// Add a Board class with String[] fielddata in constructor


public class Main {
    static Game game;

    public static void main(String[] args) {
	    // instantier Game
        game = new Game();
        System.out.println(game.players);
    }

}



//Game klassens run metode
  // tjek om der er gamedata på spillet
        // Ingen gamedata

