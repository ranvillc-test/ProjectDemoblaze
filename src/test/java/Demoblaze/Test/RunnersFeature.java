package Demoblaze.Test;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = { "src/test/resources/features/Purchase.feature" },
                 glue = { "Demoblaze.Definitions" },
                 tags = "@tag1"
)

public class RunnersFeature {

}