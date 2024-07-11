package Helper;

import Page.BlockMyJobPage;
import Page.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Condition.visible;
import static org.openqa.selenium.Keys.ENTER;

public class BlockMyJobHelper {

    BlockMyJobPage blockMyJobPage = new BlockMyJobPage();
    MainPage mainPage = new MainPage();
    SoftAssertions softly = new SoftAssertions();

    public void openBlockMyJob() {
        blockMyJobPage.blockMyJob.click();
    }

    @Step("Операция проверки блока 'Моя работа'.")
    public void checkNodeInTheBlockMyJob(String nodeInBlock1, String nodeInBlock2, String nodeInBlock3) {
        softly.assertThat(blockMyJobPage.getNodeBlock(nodeInBlock1).innerText()).as("Узел в блоке: Созданные мной документы").isEqualTo("Созданные мной документы");
        softly.assertThat(blockMyJobPage.getNodeBlock(nodeInBlock2).innerText()).as("Узел в блоке: Согласовать").isEqualTo("Согласовать");
        softly.assertThat(blockMyJobPage.getNodeBlock(nodeInBlock3).innerText()).as("Узел в блоке: Исполнить поручения").isEqualTo("Исполнить поручения");
        softly.assertAll();
    }

    @Step("Операция клика на узел, не имеющий подузлов.")
    public void node_SelectNode(String node) {
        blockMyJobPage.getNodeBlock(node).click();
    }

    @Step("Операция по открытию подузла 'Проекты'.")
    public void node_SelectSubnode_project(String subnode) {
        blockMyJobPage.getExpandNode_DocICreated().click();
        blockMyJobPage.getSubnode(subnode).click();
    }

    @Step("Операция по проверке отображения выбранного узла по его полям, элементам.")
    public void node_CheckAtributeNode(String atributeNode1, String atributeNode2, String atributeNode3) {
        softly.assertThat(blockMyJobPage.getAtributeNode(atributeNode1).innerText()).as("Элемент узла: Фильтры").isEqualTo("Фильтры");
        softly.assertThat(blockMyJobPage.getAtributeNode(atributeNode2).innerText()).as("Элемент узла: Действия с выбранными").isEqualTo("Действия с выбранными");
        softly.assertThat(blockMyJobPage.getAtributeNode(atributeNode3).innerText()).as("Элемент узла: Столбцы").isEqualTo("Столбцы");
        softly.assertAll();
    }

    @Step("Операция по открытию документа на редактирование через узел 'Созданные мной документы' -> 'Проекты'.")
    public void clickOnBtnDocEdit(String docStatus, String docNumber) {
        blockMyJobPage.getDocByNumAndStatus(docStatus, docNumber).hover();
        mainPage.getBtnDocEdit().isDisplayed();
        mainPage.getBtnDocEdit().click();
    }

    @Step("Операция по проверке нужного документа в узле.")
    public void CheckAndOpenTheDocForEditing(String docNumber, String docStatus) {
        boolean docFound = false;
        int retrais = 10;
        do {
            mainPage.getModalWindowLoading().shouldNotBe(visible);
            blockMyJobPage.getFieldSearchDoc().setValue(docNumber).press(ENTER);
            Selenide.sleep(3000);
            mainPage.getModalWindowLoading().shouldNotBe(visible);
            if (blockMyJobPage.getDocByNumAndStatus(docStatus, docNumber).exists()) {
                docFound = true;
            } else retrais--;
            if(retrais == 0){
                throw new RuntimeException("Документ не появился в таблице.");
            }
        } while (!docFound);
        blockMyJobPage.getDocByNumAndStatus(docStatus, docNumber).hover();
        mainPage.getBtnDocEdit().isDisplayed();
        mainPage.getBtnDocEdit().click();
    }

    @Step("Операция по проверке удаленного документа в узле.")
    public void checkDeletedDoc(String docNumber, String docStatus) {
        mainPage.getModalWindowLoading().shouldNotBe(visible);
        blockMyJobPage.getFieldSearchDoc().setValue(docNumber).press(ENTER);
        mainPage.getModalWindowLoading().shouldNotBe(visible);
        if (!blockMyJobPage.getDocByNumAndStatus(docStatus, docNumber).exists()) {
            return;
        } else {
            blockMyJobPage.getFieldSearchDoc().setValue(docNumber).press(ENTER);
            if (!blockMyJobPage.getDocByNumAndStatus(docStatus, docNumber).exists()) {
                return;
            }
        }
    }
}