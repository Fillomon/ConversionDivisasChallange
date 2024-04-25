import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PruebaBusqueda {

    public static void main(String[] args) {
        String bI="USD";
        String bF="MXN";
        Double mon=250.00;
        String direccion="https://v6.exchangerate-api.com/v6/d43e58b8a07f2d11cfaee26f/pair/"+bI+"/"+bF+"/"+mon;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json=response.body();
        System.out.println(json);

        Gson gson=new Gson();
       // double conversion_result =gson.fromJson(json,ConstructorConvertidor.class);










        System.out.println(response.body());

    }
}
