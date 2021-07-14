import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Youtube extends ListenerAdapter {
    
    public void execute_command(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("[\s,\r?\na-z]+");


    }
}
