@ServicioPetstore
Feature: Funcionalidad servicio Petstore
  Como QA automation
  Quiero automatizar los test del servicio Petstore
  Para poder validar su correcto funcionamiento

  @POST
  Scenario: Petición para agregar una mascota
    Given que configuro las cabeceras
      | header       | value            |
      | Content-Type | application/json |
    And envio los datos que se crearan del archivo "PetStore/post-body.json"
    When ejecuto el servicio para agregar mascota
      | url                                 | method |
      | https://petstore.swagger.io/v2/pet/ | POST   |
    Then valido el codigo de respuesta sea "200"
    And valido el esquema de respuesta sea igual al de "PetStore/post-schema.json"
