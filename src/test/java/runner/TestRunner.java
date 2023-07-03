package runner;

import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
        (
                features = "src/test/features",
                glue = "stepsDef",
                // tags = "@smoke",
                plugin = { "pretty",
                        "html:target/cucumber.html",
                        "html:target/cucumber-reports.html"
                }
//                        "json:target/cucumber.json",
//                        "junit:target/cukes.xml",
//                        "rerun:target/rerun.txt", }
//                    ,dryRun = true
        )
public class TestRunner extends TestBase {
}
