import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

// Class to read the Bot's token to prevent public's use of it.
// The .txt file containing this token is not going to be private.
public class Token {
    // This will hold the token.
    // The only way to access it is to have a txt file with the token in the same directory.
    // The getToken() method will take care of reading the token from the txt file.
    private String[] token;

    // Constructor
    public Token(){
        // The array needs to be of size 4 for each API.
        token = new String[4];
        // read the file and save the API's when instance is called.
        readToken();
    }

    /* This private method will take care of File I/O for the token.
    * Since I am using 4 different tokens/keys an array is simple solution
    * The keys will be in the following order
    *   token[0] Discord
    *   token[1] Youtube
    *   token[2] Twitter
    *   token[3] Reddit
    * */
    private void readToken(){
        int index = 0;
        try {
            File token_file = new File("token.txt");
            Scanner read = new Scanner(token_file);
            while(read.hasNextLine()){
                token[index] = read.nextLine();
                index++;
            }
            read.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    // return's the Discord token's value when called.
    public String getDiscordToken()  {
       return this.token[0];
    }

    // return's the YouTube API key.
    public String getYouTube(){
        return this.token[1];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Token token = new Token();
        System.out.println(token.getDiscordToken());
        System.out.println(token.getYouTube());
    }
}
