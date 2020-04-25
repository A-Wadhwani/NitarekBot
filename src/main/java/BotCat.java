import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BotCat extends BotEvent {
    public BotCat() {
        super("nit cat");
    }

    @Override
    String getOutputMessage() {

        try {
            String getCat = "https://api.thecatapi.com/v1/images/search";
            URL request = new URL(getCat);
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.openStream()));
            String jsonString = reader.readLine();
            reader.close();
            jsonString = jsonString.substring(1, jsonString.length() - 1);
            JSONObject json = new JSONObject(jsonString);
            String catImage = (String) json.get("url");
            return catImage;
        } catch (IOException ignored) {
        }
        return "Working on bringing you cats in the future.";
    }
}
