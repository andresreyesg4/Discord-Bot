import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main{
    // create an instance to read the token
    public static JDA jda;
    // initialize the token reader.
    static Properties properties = new Properties();
    // Main method
    public static void main(String[] args) throws LoginException, IOException {
        // Initialize the API to the discord bot in the channel.
        InputStream in = Main.class.getResourceAsStream("/" + "tokens.properties");
        properties.load(in);
        jda = JDABuilder.createDefault(properties.getProperty("discord.token")).build();
        // register event listener.
        jda.addEventListener(new youtube());
    }
}
