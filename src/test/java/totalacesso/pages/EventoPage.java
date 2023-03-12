package totalacesso.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class EventoPage extends BasePage {

    private static final String URL = "https://cart.totalacesso.com/spfcxaguasantapaulistao";

    @FindBy(tagName = "app-product-item")
    private List<WebElement> setores;

    @FindBy(id = "buttonContinue")
    private WebElement botaoContinuar;

    @FindBy(css = "a[aria-label=\"dismiss cookie message\"]")
    private WebElement botaoCookie;

    @FindBy(id = "swal2-html-container")
    private WebElement mensagemConfirmacao;

    public void abrirPagina() {
        driver.get(URL);
        botaoCookie.click();
    }

    @SneakyThrows
    public void selecionarDuasCadeiras(List<String> setoresDisponiveis) {
        String setorAptoParaCompra = encontrarSetorAptoParaCompra(setoresDisponiveis);
        WebElement elementoSetor = encontrarSetorNaPagina(setorAptoParaCompra);

        WebElement incrementar = elementoSetor.findElement(By.cssSelector("button[data-cy=\"product-quantity-increment\"]"));
        incrementar.click();
        incrementar.click();

        wait.until(ExpectedConditions.elementToBeClickable(botaoContinuar));
        botaoContinuar.click();
    }

    private String encontrarSetorAptoParaCompra(List<String> setoresDisponiveis) throws Exception {
        return setoresDisponiveis.stream()
                .filter(setorDisponivel -> {
                    WebElement setorFiltrado = setores.stream()
                            .filter(setor -> {
                                String css = String.format("label[title=\"%s - Inteira\"]", setorDisponivel);
                                return setor.findElements(By.cssSelector(css)).size() > 0;
                            }).findFirst().orElse(null);
                    return Optional.ofNullable(setorFiltrado).isPresent();
                })
                .findFirst()
                .orElseThrow(() -> new Exception("Não existe setor apto para compra"));
    }

    private WebElement encontrarSetorNaPagina(String setorAptoParaCompra) throws Exception {
        return setores.stream()
                .filter(setor -> {
                    String css = String.format("label[title=\"%s - Inteira\"]", setorAptoParaCompra);
                    return setor.findElements(By.cssSelector(css)).size() > 0;
                })
                .findFirst().orElseThrow(() -> new Exception("Não existe elemento para o setor " + setorAptoParaCompra));
    }

    public String obterMensagemConfirmacao() {
        wait.until(ExpectedConditions.visibilityOf(mensagemConfirmacao));
        return mensagemConfirmacao.getText();
    }

}
