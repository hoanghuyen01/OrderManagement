package Utils;

import Objects.Product;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BasePage {
    public BasePage(){

    }
    public JSONObject readFileJson(String pathToFile){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try (FileReader jsonFile = new FileReader(pathToFile))
        {
            jsonObject = (JSONObject) jsonParser.parse(jsonFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
