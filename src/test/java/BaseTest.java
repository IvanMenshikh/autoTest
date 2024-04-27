import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/**
 * Базовая среда для автотестирования, ее будем импортировать в тест кейсы
 */
public class BaseTest {
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();//Установка драйвера fireFox
        Configuration.browser = "FireFox";//Браузер
        Configuration.browserSize = "1920x1080";//Размер окна при запуске теста
        Configuration.timeout = 120000;//Установка Implicit Wait на 2 минуты
    }
    @BeforeMethod //Аннотация используется для инициализации объектов, переменных или состояний перед запуском теста
    public void init(){
        setUp();
    }
    @AfterMethod //Аннотация после завершения методов
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
