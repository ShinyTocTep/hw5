import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
    }

    @Test
    void dragAndDropTest() {
        open("");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("A"));
    }
}
