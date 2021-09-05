import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Robo {
    static LocalTime standardDayStart;
    static LocalTime standardDayEnd;
    static long standardDayPrice;
    static LocalTime standardNightStart;
    static LocalTime standardNightEnd;
    static long standardNightPrice;
    static LocalTime extraDayStart;
    static LocalTime extraDayEnd;
    static long extraDayPrice;
    static LocalTime extraNightStart;
    static LocalTime extraNightEnd;
    static long extraNightPrice;

    Robo(JSONObject robodetails){
        JSONObject standardDayJSON =  (JSONObject) robodetails.get("standardDay");
        this.standardDayStart = LocalTime.parse((String) standardDayJSON.get("start"));
        this.standardDayEnd = LocalTime.parse((String) standardDayJSON.get("end"));
        this.standardDayPrice = (long) standardDayJSON.get("value");

        JSONObject standardNightJSON =  (JSONObject) robodetails.get("standardNight");
        this.standardNightStart = LocalTime.parse((String) standardNightJSON.get("start"));
        this.standardNightEnd = LocalTime.parse((String) standardNightJSON.get("end"));
        this.standardNightPrice = (long) standardNightJSON.get("value");

        JSONObject extraDayJSON =  (JSONObject) robodetails.get("extraDay");
        this.extraDayStart = LocalTime.parse((String) extraDayJSON.get("start"));
        this.extraDayEnd = LocalTime.parse((String) extraDayJSON.get("end"));
        this.extraDayPrice = (long) extraDayJSON.get("value");

        JSONObject extraNightJSON =  (JSONObject) robodetails.get("extraNight");
        this.extraNightStart = LocalTime.parse((String) extraNightJSON.get("start"));
        this.extraNightEnd = LocalTime.parse((String) extraNightJSON.get("end"));
        this.extraNightPrice = (long) extraNightJSON.get("value");
    }

}
