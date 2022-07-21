package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/TestTask.feature"
		,glue={"stepdefinitions"},monochrome = false,dryRun = false,tags="@smoke"
		)

public class Runner {

}
