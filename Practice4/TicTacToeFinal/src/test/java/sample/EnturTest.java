package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnturTest {
    Gson gson = new Gson();

    @Test
    public void useEntur() throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.entur.io/mobility/v1/scooters?lat=59.909&lon=10.746")
                .addHeader("ET-Client-Name", "asbjorn - test")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);


            Type listType = new TypeToken<List<EnturResponse>>(){}.getType();
            String responseString = response.body().string();

            List<EnturResponse> enturResponse = gson.fromJson(responseString, listType);

            System.out.println(enturResponse);

            assertEquals(200, response.code());
        }



    }

}

class EnturResponse{
    String id;
    String operator;
    float lat;
    float lon;
    String code;
    int battery;

    public EnturResponse() {
    }

    public EnturResponse(String id, String operator, float lat, float lon, String code, int battery) {
        this.id = id;
        this.operator = operator;
        this.lat = lat;
        this.lon = lon;
        this.code = code;
        this.battery = battery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}