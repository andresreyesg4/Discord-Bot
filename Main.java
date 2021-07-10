import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;

public class Main{
    // create an instance to read the token

    // Main method
    public static void main(String[] args) throws LoginException{
        Token token = new Token();
        // Initialize the API to the discord bot in the channel.
        JDA jda = JDABuilder.createDefault(token.getToken()).build();

    }
}
