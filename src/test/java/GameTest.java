import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 50);
        Player anton = new Player(2, "Антон", 60);

        game.register(ivan);
        game.register(anton);
        int actual = game.round("Антон", "Иван");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 50);
        Player anton = new Player(2, "Антон", 60);

        game.register(ivan);
        game.register(anton);
        int actual = game.round("Иван", "Антон");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 50);
        Player anton = new Player(2, "Антон", 50);

        game.register(ivan);
        game.register(anton);
        int actual = game.round("Иван", "Антон");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noFirstPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 50);
        Player anton = new Player(2, "Антон", 50);

        game.register(ivan);
        game.register(anton);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петр", "Антон"));
    }

    @Test
    public void noSecondPlayer() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 50);
        Player anton = new Player(2, "Антон", 50);

        game.register(ivan);
        game.register(anton);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Антон", "Петр"));
    }

    @Test
    public void noTwoPlayers() {
        Game game = new Game();
        Player ivan = new Player(1, "Иван", 50);
        Player anton = new Player(2, "Антон", 50);

        game.register(ivan);
        game.register(anton);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Лев", "Петр"));
    }
}
