package com.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/build/cucumber-html-report",
                "pretty:target/build/cucumber-pretty.txt",
                "json:target/build/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"com.bdd"},
        tags = "@PUT"
)
public class RunnerTest {
}
