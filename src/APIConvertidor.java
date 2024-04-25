import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConvertidor {

    public String cambiarMoneda(String base_code, String target_code, double monto) {
       /*combprobando si recibe parametros*/
      //  System.out.println("Base: "+base_code+" Fin: "+target_code+" Cantidad ingresada: "+monto);

        String direccion="https://v6.exchangerate-api.com/v6/d43e58b8a07f2d11cfaee26f/pair/"+base_code+"/"+target_code+"/"+monto;
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
        //System.out.println(json);

        Gson gson=new Gson();
        //ConstructorConvertidor miCambio=gson.fromJson(json,ConstructorConvertidor.class);
        ConsutrucorConvertidorRecord miCambioRecord=gson.fromJson(json,ConsutrucorConvertidorRecord.class);
     //   System.out.println(miCambioRecord);

        ConstructorConvertidor miCambio= new ConstructorConvertidor(miCambioRecord);
       // System.out.println("Pase::: "+miCambio);


        return  miCambio.getConversion_result();
    }


}
