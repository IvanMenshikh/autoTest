package Helper;

import Page.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.Keys.ENTER;

public class MainHelper {

    MainPage mainPage = new MainPage();
    SoftAssertions softly = new SoftAssertions();

    @Step("Операция по создания документа")
    public void createDoc(String doc){
        mainPage.createDoc(doc);
    }

    @Step("Операция по переключению между блоками.")
    public void selectBlock(String block){
        mainPage.getBlock(block).click();
    }

    @Step("Операция проверки блоков на главной странице.")
    public void checkBlock(String block1, String block2, String block3){
        softly.assertThat(mainPage.getBlock(block1).innerText()).as("Блок: Моя Работа").isEqualTo("Моя работа");
        softly.assertThat(mainPage.getBlock(block2).innerText()).as("Блок: Навигатор").isEqualTo("Навигатор");
        softly.assertThat(mainPage.getBlock(block3).innerText()).as("Блок: Отчеты").isEqualTo("Отчеты");
        softly.assertAll();
    }

    @Step("Операция проверки узлов в блоке --> Моя работа.")
    public void checkNodeInTheBlockMyJob(String nodeInBlock1, String nodeInBlock2, String nodeInBlock3){
        softly.assertThat(mainPage.getNodeBlock(nodeInBlock1).innerText()).as("Узел в блоке: Созданные мной документы").isEqualTo("Созданные мной документы");
        softly.assertThat(mainPage.getNodeBlock(nodeInBlock2).innerText()).as("Узел в блоке: Согласовать").isEqualTo("Согласовать");
        softly.assertThat(mainPage.getNodeBlock(nodeInBlock3).innerText()).as("Узел в блоке: Исполнить поручения").isEqualTo("Исполнить поручения");
        softly.assertAll();
    }

    @Step("Операция клика на узел, не имеющий подузлов.")
    public void node_SelectNode(String node){
        mainPage.getNodeBlock(node).click();
    }

    @Step("Операция по проверке отображения выбранного узла по его полям, элементам.")
    public void node_CheckAtributeNode(String atributeNode1, String atributeNode2, String atributeNode3){
        softly.assertThat(mainPage.getAtributeNode(atributeNode1).innerText()).as("Элемент узла: Фильтры").isEqualTo("Фильтры");
        softly.assertThat(mainPage.getAtributeNode(atributeNode2).innerText()).as("Элемент узла: Действия с выбранными").isEqualTo("Действия с выбранными");
        softly.assertThat(mainPage.getAtributeNode(atributeNode3).innerText()).as("Элемент узла: Столбцы").isEqualTo("Столбцы");
        softly.assertAll();
    }

    @Step("Операция поиска документа в таблице и открытие его на редактирование")
    public void clickOnBtnDocEdit(String docStatus, String docNumber){
        mainPage.getDocByNumAndStatus(docStatus, docNumber).hover();
        mainPage.getBtnDocEdit().isDisplayed();
        mainPage.getBtnDocEdit().click();
    }

    @Step("Операция по проверке нужного документа в узле.")
    public void CheckAndOpenTheDocForEditing(String docNumber, String docStatus) {
        boolean docFound = false;
        do {
            mainPage.getFieldSearchDoc().setValue(docNumber).press(ENTER);
            Selenide.sleep(1500);
            mainPage.getModalWindowLoading().shouldNotBe(visible);
            if (mainPage.getDocByNumAndStatus(docStatus, docNumber).exists()) {
                docFound = true;
                }
        } while (!docFound);
        mainPage.getDocByNumAndStatus(docStatus, docNumber).hover();
        mainPage.getBtnDocEdit().isDisplayed();
        mainPage.getBtnDocEdit().click();
    }
}
