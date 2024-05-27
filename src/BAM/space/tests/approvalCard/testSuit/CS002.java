package tests.approvalCard.testSuit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import data.Users;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.armPage.ArmPage;
import pages.authPage.AuthPage;
import pages.docPage.DocPage;
import tools.Config;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.Keys.ENTER;

public class CS002 extends Config {

    @Test //(/*invocationCount = 1, threadPoolSize = 1*/)
    public void testRun() {
        // step 1
        AuthPage authPage = open(baseUrl, AuthPage.class);
        ArmPage armPage = authPage.goAuth(authPage.getFortest1());
        armPage.userMenuName().shouldHave(innerText("Фортест1"));
        armPage.selectParentNode("Созданные мной документы");
        armPage.selectNode("Проекты");
        armPage.checkDocInTableAndStatus("У-48119-24", "Проект");
        DocPage docPage = armPage.clickDocInTable("У-48119-24");
        String docNum =  docPage.getDocNumberText();
        authPage.outAuth();
    }

}
