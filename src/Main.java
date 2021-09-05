import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("src/test.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject shiftJSON =  (JSONObject) jsonObject.get("shift");
            LocalDateTime startTime = LocalDateTime.parse((String) shiftJSON.get("start"));
            LocalDateTime endTime   = LocalDateTime.parse((String) shiftJSON.get("end"));

            JSONObject roboRateJSON =  (JSONObject) jsonObject.get("roboRate");
            Robo robo = new Robo(roboRateJSON);

            Calculate cal = new Calculate(startTime, endTime, robo);
            System.out.println(cal.calculateFees());



        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
