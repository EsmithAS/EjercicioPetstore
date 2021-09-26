package com.bdd.generic;

import io.cucumber.messages.internal.com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServiceDOM {

    protected Response get(Headers cabecera, String url) {
        Response response = RestAssured.given().headers(cabecera).when().get(url, new Object[0]);
        return response;
    }

    protected Response post(Headers cabecera, String objBody, String url) {
        Response response = RestAssured.given().headers(cabecera).body(objBody).when().post(url);
        return response;
    }

    protected Response put(Headers cabecera, String objBody, String url) {
        Response response = RestAssured.given().headers(cabecera).body(objBody).when().put(url);
        return response;
    }

    protected List<Header> formatHeaders(List<Map<String, String>> list) {
        List<Header> headerList = new LinkedList<>();
        list.forEach(stringStringMap -> {
            String property = stringStringMap.get("header");
            String value = stringStringMap.get("value");
            Header header = new Header(property, value);
            headerList.add(header);
        });
        return  headerList;
    }

    protected String getBody ( String pathFile ) {
        String path = "src/test/resources/Requests/"+ pathFile;
        String fileContent = null;
        try {
            FileReader reader = new FileReader(path);
            JsonParser jsonParser = new JsonParser();
            fileContent = jsonParser.parse(reader).toString();
        }  catch (Exception e) {

        }
        return  fileContent;
    }

    protected void validarSchema( Response response , String path ) {
        File schema = new File(System.getProperty("user.dir")+"/src/test/resources/Requests/"+path);
        System.out.println(response.getBody().asString());
        Assert.assertThat(response.getBody().asString() , JsonSchemaValidator.matchesJsonSchema(schema));
    }

}
