package totalacesso.clients;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import totalacesso.pojos.Root;
import totalacesso.pojos.Sector;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TotalAcessoClient {

    public List<String> setoresComIngresso() {

        RestAssured.baseURI = "https://api-cart.totalacesso.com";
        RestAssured.useRelaxedHTTPSValidation();

        Root response = given()
                .when()
                .get("/prod/Cart/spfcxaguasantapaulistao/Prepare/")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Root.class);

        List<Sector> sectors = Objects.requireNonNull(response.getEvent().getSessions().stream().findFirst().orElse(null)).getSectors();

        List<String> setoresDisponiveis = sectors.stream()
                .filter(sector -> sector.getStatusId() == 1)
                .map(Sector::getDescription)
                .collect(Collectors.toList());

        System.out.println("Setores disponíveis: " + setoresDisponiveis);

        return setoresDisponiveis;
    }

}
