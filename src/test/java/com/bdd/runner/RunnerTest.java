package com.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/report/cucumber-html-report.html",
                "pretty:target/report/cucumber-pretty.txt",
                "json:target/report/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"com.bdd"},
        tags = "@ServicioPetstore"
)
public class RunnerTest {
}
