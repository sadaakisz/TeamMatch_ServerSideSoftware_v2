package com.teammatch;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},features = {"classpath:features/"},
        glue = {"com.teammatch"})

public class TeammatchApplicationTests {


}
