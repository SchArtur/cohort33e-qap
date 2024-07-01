import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//features - нужно указать где лежат feature фаилы (тест)
//glue - где лежат стэпы (шаги)

//plugin - надо просто запомнить, настройки того, где лежит отчет об АТ
//tags - тэги для запуска
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@all",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner {
}
