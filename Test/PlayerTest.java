import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
Game game;
Player player1;
Player player2;
    @Before
    public void setUp() throws Exception {
        game = new Game();
        player1 = new Player("Hans", 30000);
        player2 = new Player("Grethe", 30000);
    }
    @Test
    public void receiveMoney() {
       // player1.receiveMoney(2000);
       // assertEquals(32000,player1.getBalance());

    }
}