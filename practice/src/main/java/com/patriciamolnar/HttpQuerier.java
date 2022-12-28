package com.patriciamolnar;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpQuerier {
    public static final String API_URL = "https://jsonplaceholder.typicode.com/todos/1";
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder()
                                .GET()
                                .header("accept", "application/json")
                                .uri(URI.create(API_URL))
                                .build(); 
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
            System.out.println(response.body());
        } catch(IOException | InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
