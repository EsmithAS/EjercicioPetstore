package com.bdd.api.stepDefinition;

import com.bdd.api.step.ServicioPetstoreStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServicioPetstoreStepDefinition {

    private Scenario scenario;

    private ServicioPetstoreStep servicioPetstoreStep = new ServicioPetstoreStep();

    @Before
    public void Before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("que configuro las cabeceras")
    public void queConfiguroLasCabeceras(DataTable dt) {
        servicioPetstoreStep.configurarCabeceras(dt);
    }

    @And("envio los datos que se crearan del archivo {string}")
    public void envioLosDatosQueSeCrearanDelArchivo(String ruta) {
        servicioPetstoreStep.enviarDatos(ruta);
    }

    @When("ejecuto el servicio para agregar mascota")
    public void ejecutoElServicioParaAgregarMascota(DataTable dt) {
        servicioPetstoreStep.ejecutarServicio(dt);
    }

    @Then("valido el codigo de respuesta sea {string}")
    public void validoElCodigoDeRespuestaSea(String estado) {
        servicioPetstoreStep.validarEstado( Integer.parseInt(estado) );
    }

    @And("valido el esquema de respuesta sea igual al de {string}")
    public void validoElEsquemaDeRespuestaSeaIgualAlDe(String path) {
        servicioPetstoreStep.verificarSchema(path);
    }
}
