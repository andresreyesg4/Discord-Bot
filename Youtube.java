import jdk.nashorn.internal.runtime.ListAdapter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Youtube extends ListAdapter{
    
    public void execute_command(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("[\s,\r?\na-z]+");

        
    }
}
