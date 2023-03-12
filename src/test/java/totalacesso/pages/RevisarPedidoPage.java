package totalacesso.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RevisarPedidoPage extends BasePage {

    @FindBy(css = "button[data-cy=\"review-button-continue\"]")
    private WebElement botaoContinuar;

    public void continuar() {
        wait.until(ExpectedConditions.visibilityOf(botaoContinuar));
        botaoContinuar.click();
    }
}
