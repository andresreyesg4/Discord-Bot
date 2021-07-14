import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main{
    // create an instance to read the token
    public static JDA jda;
    // initialize the token reader.
    static Token token = new Token();
    // Main method
    public static void main(String[] args) throws LoginException{
        // Initialize the API to the discord bot in the channel.
        jda = JDABuilder.createDefault(token.getDiscordToken()).build();
    }
}
