package app.iskandar_idris.com.sunshine.Controllers;

/**
 * Created by Iskandar Idris on 11/5/2016.
 */

public class CloudUrl {
    final static public String BASE_URL="http://api.openweathermap.org/data/2.5/weather?";
    final static public String API_KEY="37d3b45761839f039b4907f8eebcba16";

    public String getCurrentWeather(String location){
        return BASE_URL + "q=" + location + "&appid=" + API_KEY;
    }

}
