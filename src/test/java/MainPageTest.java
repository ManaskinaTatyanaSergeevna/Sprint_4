import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;

@RunWith(Parameterized.class)
public class MainPageTest {
    private WebDriver driver;
    private final String arrowText;
    private final String arrowDescription;

    public MainPageTest(String arrowText, String arrowDescription){
        this.arrowDescription = arrowDescription;
        this.arrowText = arrowText;
    }

    @Parameterized.Parameters
    public static Object[][] getTexts(){
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. " +
                        "Если хотите покататься с друзьями, можете просто " +
                        "сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. " +
                        "Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, " +
                        "когда вы оплатите заказ курьеру. Если мы " +
                        "привезли самокат 8 мая в 20:30, суточная аренда " +
                        "закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно " +
                        "позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. " +
                        "Этого хватает на восемь суток — даже если будете " +
                        "кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, " +
                        "объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void textAndArrowMatchForFirefoxTest(){
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\WebDriver\\bin\\geckodriver-v0.32.0-win32\\geckodriver.exe"
        );
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        Assert.assertEquals("Текст стрелки '" + arrowText + "' не соответствует ожидаемому результату.",
                arrowDescription, objMainPage.getTextUnderArrow(arrowText));

    }

    @Test
    public void textAndArrowMatchForChromeTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\WebDriver\\bin\\chromedriver_win32\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        Assert.assertEquals("Текст стрелки '" + arrowText + "' не соответствует ожидаемому результату.",
                arrowDescription, objMainPage.getTextUnderArrow(arrowText));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
