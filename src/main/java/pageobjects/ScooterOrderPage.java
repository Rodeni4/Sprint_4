package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderPage {
    private WebDriver driver;

    // локатор для поля Имя
    private By nameInputField = By.xpath(".//input[@placeholder='* Имя']");

    // локатор для поля Фамилия
    private By surnameInputField = By.xpath(".//input[@placeholder='* Фамилия']");

    // локатор для поля Адрес
    private By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для поля Телефон
    private By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор для поля Станция метро
    private By metroStationInputField = By.className("select-search__input");

    // локатор для выбора Станции метро
    private By metroStationSelect = By.className("select-search__select");

    // локатор для кнопки Далее
    private By buttonFarther = By.xpath(".//button[text()='Далее']");

    // локатор для поля Когда
    private By whenInputField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // локатор для поля Срок аренды
    private By pentalPeriodInputField = By.className("Dropdown-placeholder");

    // локатор для выбора срока аренды
    private By pentalPeriodInput = By.xpath(".//div[text()='семеро суток']");

    // локатор для выбора цвета
    private By colourField = By.id("black");

    // локатор для комментария курьеру
    private By courierCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // локатор для кнопки заказать
    private By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор для кнопки Да
    private By buttonYes = By.xpath(".//button[text()='Да']");

    // локатор для ообщениея об успешном создании заказа
    private By textMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    // конструктор класса
    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для заполнения поля * Имя
    public void sendNameInput(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    // метод для заполнения поля * Фамилия
    public void sendSurnameInput(String surname) {
        driver.findElement(surnameInputField).sendKeys(surname);
    }

    // метод для заполнения поля * Адрес
    public void sendAddressInput(String address) {
        driver.findElement(addressInputField).sendKeys(address);
    }

    // метод для заполнения поля * Телефон
    public void sendPhoneInput(String phone) {
        driver.findElement(phoneInputField).sendKeys(phone);
    }

    // метод для заполнения станции метро
    public void sendMetroStationInput(String metroStations) {
        driver.findElement(metroStationInputField).click();
        driver.findElement(metroStationInputField).sendKeys(metroStations);
        driver.findElement(metroStationSelect).click();
    }

    // нажатие кнопки далее
    public void clickButtonFarther() {
        driver.findElement(buttonFarther).click();
    }

    // метод для заполнения поля * Когда
    public void sendWhenInput(String whenDate) {
        driver.findElement(whenInputField).sendKeys(whenDate);
        driver.findElement(whenInputField).sendKeys(Keys.ENTER);
    }

    // метод для заполнения поля * Срок аренды
    public void sendRentalPeriodSevenDaysInput() {
        driver.findElement(pentalPeriodInputField).click();
        driver.findElement(pentalPeriodInput).click();
    }

    // метод для выбора цвета
    public void sendColourBlackInput() {
        driver.findElement(colourField).click();
    }

    // метод для коментария курьеру
    public void sendCourierCommentInput(String commentCourier) {
        driver.findElement(courierCommentField).sendKeys(commentCourier);
    }

    // метод нажатия кнопки Заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    // метод нажатия кнопки Да
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    // метод для проверки появления сообщениея об успешном создании заказа
    public void waitTextAppear(String textExpected) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(textMessage, textExpected));
    }

    // метод заполнения полей на первой странице
    public void fillingFieldsFirstPage(String name, String surname, String address, String phone, String metroStations) {
        sendNameInput(name);
        sendSurnameInput(surname);
        sendAddressInput(address);
        sendPhoneInput(phone);
        sendMetroStationInput(metroStations);
    }

    // метод заполнения полей на второй странице
    public void fillingFieldsSecondPage(String whenDate, String commentCourier) {
        sendWhenInput(whenDate);
        sendRentalPeriodSevenDaysInput();
        sendColourBlackInput();
        sendCourierCommentInput(commentCourier);
    }
}
