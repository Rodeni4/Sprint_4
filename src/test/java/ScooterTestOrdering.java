import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ScooterTestOrdering {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    private final String textExpected = "Заказ оформлен";


    @Test
    // тест нажатия верхней кнопки заказать в Google Chrome
    public void  pressTopButtonOrdering() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickTopButtonOrder();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.sendNameInput();
        objOrderPage.sendSurnameInput();
        objOrderPage.sendAddressInput();
        objOrderPage.sendPhoneInput();
        objOrderPage.sendMetroStationInput();
        objOrderPage.clickButtonFarther();
        objOrderPage.sendWhenInput();
        objOrderPage.sendRentalPeriodInput();
        objOrderPage.sendСolourInput();
        objOrderPage.sendCourierCommentInput();
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // тест нажатия нижней кнопки заказать в Google Chrome
    public void  pressBottomButtonOrdering() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.sendNameInput();
        objOrderPage.sendSurnameInput();
        objOrderPage.sendAddressInput();
        objOrderPage.sendPhoneInput();
        objOrderPage.sendMetroStationInput();
        objOrderPage.clickButtonFarther();
        objOrderPage.sendWhenInput();
        objOrderPage.sendRentalPeriodInput();
        objOrderPage.sendСolourInput();
        objOrderPage.sendCourierCommentInput();
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // тест нажатия верхней кнопки заказать в FireFox
    public void  pressTopButtonOrderingFireFox() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickTopButtonOrder();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.sendNameInput();
        objOrderPage.sendSurnameInput();
        objOrderPage.sendAddressInput();
        objOrderPage.sendPhoneInput();
        objOrderPage.sendMetroStationInput();
        objOrderPage.clickButtonFarther();
        objOrderPage.sendWhenInput();
        objOrderPage.sendRentalPeriodInput();
        objOrderPage.sendСolourInput();
        objOrderPage.sendCourierCommentInput();
        objOrderPage.clickButtonOrder();
        objOrderPage.clickButtonYes();
        objOrderPage.waitTextAppear(textExpected);
    }

    @Test
    // тест нажатия нижней кнопки заказать в FireFox
    public void  pressBottomButtonOrderingFireFox() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.scrollBottomButtonOrder();
        objHomePage.clickBottomButtonOrder();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.sendNameInput();
        objOrderPage.sendSurnameInput();
        objOrderPage.sendAddressInput();
        objOrderPage.sendPhoneInput();
        objOrderPage.sendMetroStationInput();
        objOrderPage.clickButtonFarther();
        objOrderPage.sendWhenInput();
        objOrderPage.sendRentalPeriodInput();
        objOrderPage.sendСolourInput();
        objOrderPage.sendCourierCommentInput();
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
