package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, 
features = {"./featureFiles/ERP.feature"},
glue = {"stepDefination"},
tags = "@Suppliers or @Customer",
plugin = {"pretty","html:target/report/cucumber.html",
		"junit:target/report/cucumber.xml",
		"json:target/report/cucumber.json"})
public class AppTest extends AbstractTestNGCucumberTests {

}
