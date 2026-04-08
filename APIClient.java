import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class APIClient {
    //convert zip code to latitude and longitude
    //https://zippopotam.us/
    //https://api.weather.gov/
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a zip code: ");
        String zipCode = input.nextLine();
        input.close();
        
        String url = "https://api.zippopotam.us/us/" + zipCode; //add zip code to url
        HttpClient client = HttpClient.newHttpClient(); //create http client
        HttpRequest request = HttpRequest.newBuilder() //build http request
                .uri(URI.create(url)) //create URI from url
                .build(); //build request
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //send the request
            String responseBody = response.body(); //parses to get latitude and longitude
            
            //split body to get longitude and latitude
            String[] parts = responseBody.split("\""); //split with double quotes to get the latitude and longitude
            String latitude = "";
            String longitude = "";
            for (int i = 0; i < parts.length; i++) { //loop through parts to find latitude and longitude 
                if (parts[i].equals("latitude")) { //if part is latitude get value
                    latitude = parts[i + 2]; 
                } else if (parts[i].equals("longitude")) {
                    longitude = parts[i + 2];
                }
            }
            //get weather data 
            String weatherUrl = "https://api.weather.gov/points/" + latitude + "," + longitude; //create url for weather data 
            HttpRequest weatherRequest = HttpRequest.newBuilder()
                    .uri(URI.create(weatherUrl))
                    .build();
            HttpResponse<String> weatherResponse = client.send(weatherRequest, HttpResponse.BodyHandlers.ofString());
            String weatherResponseBody = weatherResponse.body();
            String forecastUrl = weatherResponseBody.split("\"forecast\": \"")[1].split("\"")[0]; //get forecast url from weather response
            HttpRequest forecastRequest = HttpRequest.newBuilder() //create request
                    .uri(URI.create(forecastUrl))
                    .build();   
            HttpResponse<String> forecastResponse = client.send(forecastRequest, HttpResponse.BodyHandlers.ofString()); //send the request 
            String forecastResponseBody = forecastResponse.body();
            System.out.println("Forecast data for zip code " + zipCode + ":");
            System.out.println(forecastResponseBody);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
       
    }
}
