package Helper;

import Page.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class MainHelper {

    MainPage mainPage = new MainPage();

    @Step("Операция по создания документа")
    public void createDoc(String doc){
        mainPage.createDoc(doc);
    }

    @Step("Операция по переключению между блоками.")
    public void selectBlock(String block){
        mainPage.getBlock(block).click();
    }

    @Step("Операция проверки узлов в блоке.")
    public void checkBlockMyJob(String node1, String node2, String node3){
    mainPage.getNodeBlock(node1).shouldBe(visible);
    mainPage.getNodeBlock(node2).shouldBe(visible);
    mainPage.getNodeBlock(node3).shouldBe(visible);
    }

    @Step("Операция клика на узел, не имеющий подузлов.")
    public void node_SelectNode(String node){
        mainPage.getNodeBlock(node).click();
    }

    @Step("Операция по проверке отображения узла.")
    public void node_CheckAtributeNode(String atributeNode1, String atributeNode2, String atributeNode3){
        mainPage.getAtributeNode(atributeNode1).shouldBe(visible);
        mainPage.getAtributeNode(atributeNode2).shouldBe(visible);
        mainPage.getAtributeNode(atributeNode3).shouldBe(visible);
    }
}
