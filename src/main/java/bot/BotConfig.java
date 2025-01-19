package bot;

import lombok.Getter;
import lombok.Setter;



public class BotConfig {
    @Getter
    @Setter
    public static boolean waitingForUserWrite = false;
    @Getter
    @Setter
    public static boolean isWaitingForWriteOvertimes = false;
}
