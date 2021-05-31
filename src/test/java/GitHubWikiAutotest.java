import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubWikiAutotest {
    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test

    void findPages1() {

        open("https://github.com/selenide/selenide");
        $(byText("Wiki")).click();
        $(byText("Soft assertions")).shouldBe(visible).click();
        $$("#wiki-body").findBy(text("Using JUnit5 extend test class:")).shouldBe(visible);
    }

    @Test

    void findPages2() {
        open("https://github.com/selenide/selenide");
        $("nav[aria-label='Repository']").$("ul li", 4).click();
        $("#wiki-content").shouldHave(text("Welcome to the selenide wiki!"));
        //$(byLinkText("Soft assertions")).click();
        $$(".markdown-body ul li a").findBy(text("Soft assertions")).click();
        $("#wiki-wrapper h1").shouldHave(text("SoftAssertions"));
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}



