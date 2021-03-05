package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
// Runner class for running Tests

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/featureFile/buyPillow.feature",
					 glue= {"stepDefination"},
					 monochrome=true,
					 plugin = {"pretty","html:target/HtmlReports","html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml"},
					 tags = "@smoke"							
	)
	public class TestRunner {
	
}
