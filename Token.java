import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

// Class to read the Bot's token to prevent public's use of it.
// The .txt file containing this token is not going to be private.
public class Token {
    // This will hold the token.
    // The only way to access it is to have a txt file with the token in the same directory.
    // The getToken() method will take care of reading the token from the txt file.
    private String token;

    // Constructor
    public Token(){
        token = "";
    }

    // return's the token's value when called.
    public String getToken()  {
        try {
            File token_file = new File("token.txt");
            Scanner read = new Scanner(token_file);
            while(read.hasNextLine()){
                token = read.nextLine();
            }
            read.close();
            return token;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Token token = new Token();
        System.out.println(token.getToken());
    }
}
