package com.bdd.api.step;

import com.bdd.generic.ServiceDOM;
import io.cucumber.datatable.DataTable;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ServicioPetstoreStep extends ServiceDOM {

    private Headers headers;
    private String body;
    private Response response;
    private String idMascota;

    public void configurarCabeceras(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        headers = new Headers(formatHeaders(list));
    }

    public void enviarDatos(String ruta) {
        body = getBody(ruta);
    }

    public void ejecutarServicio(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        Map<String, String> rowContent = list.get(0);

        String url = rowContent.get("url");
        String method = rowContent.get("method");

        switch (method.toUpperCase()) {
            case "GET":
                response = get(headers, url + idMascota);
                break;
            case "POST":
                response = post(headers, body, url);
                break;
            case "PUT":
                response = put(headers, body, url);
                break;
        }
    }

    public void validarEstado(int estado) {
        System.out.println("Code status ---> "+response.getStatusCode());
        Assert.assertTrue("El codigo de respuesta es incorrecto",response.getStatusCode() == estado);
    }

    public void verificarSchema(String path) {
        validarSchema(response , path);
    }

    public void enviarIdMascota(String id) {
        idMascota = id;
    }
}
