import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.Rules();
            int start;
            do {
                start = game.StartPlay();
                if (start == 1) {
                    game.Play();
                }
                else  if (start == 0)break;
                else game.PrintRepeatInput();
            } while (start < 0);
    }
}
