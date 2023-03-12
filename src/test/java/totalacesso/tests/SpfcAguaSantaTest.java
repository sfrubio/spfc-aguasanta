package totalacesso.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import totalacesso.clients.TotalAcessoClient;
import totalacesso.pages.EventoPage;
import totalacesso.pages.RevisarPedidoPage;
import totalacesso.pages.TermosPage;
import totalacesso.utils.DriverFactory;
import totalacesso.utils.ExtentReportManager;
import totalacesso.utils.ExtentTestManager;

import java.util.List;

public class SpfcAguaSantaTest {

    private WebDriver driver;
    private TotalAcessoClient totalAcessoClient;
    private EventoPage eventoPage;
    private RevisarPedidoPage revisarPedidoPage;
    private TermosPage termosPage;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver();
        totalAcessoClient = new TotalAcessoClient();
        eventoPage = new EventoPage();
        revisarPedidoPage = new RevisarPedidoPage();
        termosPage = new TermosPage();
    }

    @Test
    public void comprarIngresso() {
        ExtentReportManager.getInstance();
        ExtentReportManager.createTest("Tentativa de compra de ingresso");

        List<String> setoresComIngresso = totalAcessoClient.setoresComIngresso();
        eventoPage.abrirPagina();
        eventoPage.selecionarDuasCadeiras(setoresComIngresso);
        revisarPedidoPage.continuar();
        termosPage.aceitarTermo();

        Assert.assertNotEquals(eventoPage.obterMensagemConfirmacao(), "Os produtos não estão mais disponíveis");
    }


    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver();
        ExtentReportManager.closeReport();
    }
}
