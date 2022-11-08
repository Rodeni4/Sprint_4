import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.ScooterHomePage;
import pageobjects.ScooterOrderPage;

public class ScooterTestOrdering {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    // Тестовые данные
    private final String name = "Сергей";
    private final String surname = "Роденко";
    private final String address = "ул. Ленина д. 1 кв. 1";
    private final String phone = "89132995050";
    private final String metroStations = "Соколиная Гора";
    private final String whenDate = "31.12.2022";
    private final String commentCourier = "шире шаг почтальон!";
    private final String textExpected = "Заказ оформлен";
    @Test
    // тест нажатия верхней кнопки заказать в Google Chrome
    public void pressTopButtonOrdering() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.clickTopButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // тест нажатия нижней кнопки заказать в Google Chrome
    public void pressBottomButtonOrdering() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // тест нажатия верхней кнопки заказать в FireFox
    public void pressTopButtonOrderingFireFox() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.clickTopButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // тест нажатия нижней кнопки заказать в FireFox
    public void pressBottomButtonOrderingFireFox() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.openGetHomePage();
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        ScooterOrderPage objOrderPage = new ScooterOrderPage(driver);
        objOrderPage.fillingFieldsFirstPage(name, surname, address, phone, metroStations);
        objOrderPage.clickButtonFarther();
        objOrderPage.fillingFieldsSecondPage(whenDate, commentCourier);
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
