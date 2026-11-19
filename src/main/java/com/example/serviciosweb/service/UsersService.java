package com.example.serviciosweb.service;

import com.example.serviciosweb.model.Users;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsersService {

    private static final String BASE = System.getenv("SUPABASE_URL");
    private static final String KEY = System.getenv("SUPABASE_KEY");
    private static final String TABLA = "customers";

    public List<Users> obtenerUsuarios() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();

        /*es la peticion que se envia al servidor*/
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE + "/rest/v1/" + TABLA + "?select=*&order=id")).header("apikey", KEY).header("Authorization", "Bearer " + KEY).timeout(Duration.ofSeconds(15)).GET().build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200){
            throw new RuntimeException("Error al obtener los datos del usuario" + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode datos = mapper.readTree(response.body());

        if(!datos.isArray()){
            throw new RuntimeException("Error al obtener los datos del usuario" + response.statusCode());
        }
        List<Users> usuarios = new ArrayList<>();

        for (JsonNode dato : datos) {
            Users usuario = new Users(dato.path("id").asInt(),
                    dato.path("first_name").asText(),
                    dato.path("last_name").asText(),
                    dato.path("email").asText(),
                    dato.path("phone").asText(),
                    dato.path("date_of_birth").asText(),
                    dato.path("city").asText(),
                    dato.path("address").asText(),
                    (float) dato.path("annual_income").asDouble(),
                    dato.path("credit_score").asInt(),
                    dato.path("has_unpaid_debt").asBoolean(),
                    dato.path("unpaid_debt_amount").asText(),
                    dato.path("status").asText(),
                    OffsetDateTime.parse(dato.path("created_at").asText()).toLocalDate(),
                    OffsetDateTime.parse(dato.path("updated_at").asText()).toLocalDate());

            usuarios.add(usuario);

        }
        return usuarios;
    }
}
