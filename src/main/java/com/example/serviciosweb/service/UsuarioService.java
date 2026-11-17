package com.example.serviciosweb.service;

import com.example.serviciosweb.model.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private static final String URL = "https://jsonplaceholder.typicode.com/users";

    public List<Usuario> obtenerUsuarios() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();

        /*es la peticion que se envia al servidor*/
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).timeout(Duration.ofSeconds(15)).GET().build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200){
            throw new RuntimeException("Error al obtener los datos del usuario" + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode datos = mapper.readTree(response.body());

        if(!datos.isArray()){
            throw new RuntimeException("Error al obtener los datos del usuario" + response.statusCode());
        }
        List<Usuario> usuarios = new ArrayList<>();

        for (JsonNode dato : datos) {
            Usuario usuario = new Usuario(dato.path("id").asInt(),
                                        dato.path("name").asText(),
                                        dato.path("username").asText(),
                                        dato.path("email").asText(),
                                        dato.path("phone").asText(),
                                        dato.path("address").path("city").asText(),
                                        dato.path("Company").path("name").asText()
                    );

            usuarios.add(usuario);

        }
        return usuarios;
    }


}
