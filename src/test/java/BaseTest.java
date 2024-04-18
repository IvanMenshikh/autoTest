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
        WebDriverManager.edgedriver().setup();//Установка драйвера Edge
        Configuration.browser = "Edge";//Браузер
        Configuration.browserSize = "1920x1080";//Размер окна при запуске теста
        //Configuration.headless = false;//Видимоть теста при запуске, обычно используют на Дженкинсе
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
