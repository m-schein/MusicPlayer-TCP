import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class SoundPlayer {
    Player player = new Player();
    Pattern vocals = new Pattern();

    public Pattern getVocals(){
        return this.vocals;
    }
    public Player getPlayer(){
        return this.player;
    }

}
