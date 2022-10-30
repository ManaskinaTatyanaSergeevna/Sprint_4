import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;
import pom.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String userName;
    private final String userSurname;
    private final String dateRental;
    private final String userComment;
    private  final String scooterColor;

    public OrderTest(String userName, String userSurname, String dateRental, String userComment, String scooterColor){
        this.userName = userName;
        this.userSurname = userSurname;
        this.dateRental = dateRental;
        this.userComment = userComment;
        this.scooterColor = scooterColor;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData(){
        return new Object[][]{
                {"Авдотья", "Мажорова", "29.02.2024", "Домофон не работает", "Черный"},
                {"Юлий", "Цезарь", "12.07.2023", "" , "Серый"},
        };
    }

    @Test
    public void scooterOrderByUpperButtonViaFirefoxTest() {
//        System.setProperty(
//                "webdriver.gecko.driver",
//                "C:\\WebDriver\\bin\\geckodriver-v0.32.0-win32\\geckodriver.exe"
//        );
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnUpperOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enteringPersonalUserData(userName, userSurname, "Открытое шоссе,5к11", "88005553535");
        objOrderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        objOrderPage.clickYes();
        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.",1, objOrderPage.getCountTitleOfSuccessfulOrder());
    }

    @Test
    public void scooterOrderByUnderButtonViaFirefoxTest() {
//        System.setProperty(
//                "webdriver.gecko.driver",
//                "C:\\WebDriver\\bin\\geckodriver-v0.32.0-win32\\geckodriver.exe"
//        );
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnUnderOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enteringPersonalUserData(userName, userSurname, "Открытое шоссе,5к11", "88005553535");
        objOrderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        objOrderPage.clickYes();
        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.",1, objOrderPage.getCountTitleOfSuccessfulOrder());
    }

    @Test
    public void scooterOrderByUpperButtonViaChromeTest() {
//        System.setProperty(
//                "webdriver.chrome.driver",
//                "C:\\WebDriver\\bin\\chromedriver_win32\\chromedriver.exe"
//        );
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnUpperOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enteringPersonalUserData(userName, userSurname, "Открытое шоссе,5к11", "88005553535");
        objOrderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        objOrderPage.clickYes();
        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.",1, objOrderPage.getCountTitleOfSuccessfulOrder());
    }

    @Test
    public void scooterOrderByUnderButtonViaChromeTest() {
//        System.setProperty(
//                "webdriver.chrome.driver",
//                "C:\\WebDriver\\bin\\chromedriver_win32\\chromedriver.exe"
//        );
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnUnderOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enteringPersonalUserData(userName, userSurname, "Открытое шоссе,5к11", "88005553535");
        objOrderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        objOrderPage.clickYes();
        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.",1, objOrderPage.getCountTitleOfSuccessfulOrder());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
