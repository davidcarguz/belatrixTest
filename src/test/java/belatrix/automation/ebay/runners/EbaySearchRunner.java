package belatrix.automation.ebay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features = "src/test/resources/features/searches"
,glue = "belatrix.automation.ebay.definitions"
,tags = "@shoes_search"
,monochrome = true
,snippets = SnippetType.CAMELCASE
		)

public class EbaySearchRunner {

}
 