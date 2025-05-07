package java8.way.to.call.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Java8HttpClientExample {

    public static void main(String[] args) throws Exception {
        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder jsonResponse = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            jsonResponse.append(line);
        }

        conn.disconnect();

        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(jsonResponse.toString(), new TypeReference<List<User>>() {});

        users.forEach(user ->
            System.out.println(user.name + " | " + user.email + " | " + user.company.name)
        );
    }
}
