import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubEnterprisePage {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void menuHoverAndHeaderChekTest() {
        open("");
        $("[aria-label='Global']").$(withText("Solutions")).hover();
        $("[href='/enterprise']").click();
        sleep (3000);
        $("#hero-section-brand-heading").shouldHave(Condition.partialText("The AI-powered"));

    }




}
