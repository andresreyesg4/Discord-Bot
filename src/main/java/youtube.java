import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.model.Video;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.VideoListResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.*;

public class Youtube extends ListenerAdapter {

    private static String PROPERTIES_FILENAME = "youtube.properties";
    private static Properties properties = new Properties();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();


    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        try {
            String[] videolist = new String[5];
            String[] args = event.getMessage().getContentRaw().split("[\\\\s,]+");
            if(args[0].equalsIgnoreCase("!" + "yt")){
                yt_command(videolist);
            }
            for(int i = 0; i < videolist.length; i++){
                if(videolist[i] != null){
                    event.getChannel().sendMessage(videolist[i]).queue();
                }
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void yt_command(String[] list) throws GeneralSecurityException, IOException, IllegalArgumentException {
        String[] videoList = new String[5];
        getVieos(videoList);
        // send the list to the channel.
        for (int i = 0; i < videoList.length; i++) {
                try {
                    if(videoList[i] != null) {
                        list[i] = videoList[i];
                    }
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
        }
    }


    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        InputStream in = Youtube.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
        properties.load(in);
        return new YouTube.Builder(httpTransport, JSON_FACTORY, new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest httpRequest) throws IOException {}
        }).setApplicationName("Trending-Bot").build();
    }

    /**
     * Call function to create API service object. Define and
     * execute API request. Print API response.
     *
     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
     */
    public void getVieos(String[] videos) throws GeneralSecurityException, IOException{
        YouTube youtubeService = getService();
        // Define and execute the API request

        YouTube.Videos.List request = youtubeService.videos().list(Collections.singletonList("contentDetails"));
        request.setKey(properties.getProperty("youtube.apikey"));
        List<VideoListResponse> json = Collections.singletonList(request.setChart("mostPopular").setRegionCode("US").execute());
        VideoListResponse response = request.setChart("mostPopular")
                .setRegionCode("US")
                .execute();
        List<Video> list = response.getItems();
        // save the links to the list.
        for(int i = 0; i < list.size(); i++){
            System.out.println("https://youtu.be/" + list.get(i).get("id"));
            videos[i] = "https://youtu.be/" + list.get(i).get("id");
        }
    }
}
