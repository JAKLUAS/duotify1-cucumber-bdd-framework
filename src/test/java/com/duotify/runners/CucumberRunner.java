package com.duotify.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
 @CucumberOptions(

         tags = "smoke",
        features = "src/test/resources", // copy the path from the content root ,path to the folder where features files are located
         glue = "com/duotify/stepDefintions" //copy the path from the source root

         // ,dryRun = true // quickly generate snippets without runnig the scenarion
     )
    public class CucumberRunner {
  }
