import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    @Before
    public void setUp() throws Exception {
        game = new Game();
    }
    @Test
    public void getPlayers(){
       String s = game.getPlayers();
       //expected should reflect data in src/data.txt
       assertEquals("[Tobias: 30000, Jesper: 5000, Tess: 30]",s);
    }
    @Test
    public void getBoard(){

    }
}