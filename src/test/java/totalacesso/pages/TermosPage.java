package totalacesso.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TermosPage extends BasePage {

    @FindBy(id = "tuPpEvent")
    private WebElement aceiteTermos;

    @FindBy(css = "button[data-cy=\"review-button-continue\"]")
    private WebElement botaoContinuar;

    public void aceitarTermo() {
        wait.until(ExpectedConditions.visibilityOf(aceiteTermos));
        aceiteTermos.click();
        botaoContinuar.click();
    }
}
