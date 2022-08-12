package com.duotify.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

 @RunWith(Cucumber.class)
 @CucumberOptions(

         tags = " @regression", //"@smoke and @signup" -> scenarios tagged with both @smoke and @signup
                                      // @smoke or @signup" -> scenarios tagged with either @smoke or @signup
                                      // @smoke or @signup and @regression ->  scenarios tagged with either smoke OR signup and regression (signup and regression evaluated first)
                                      //(@smoke or @signup) and @regression ->  scenarios tagged with either smoke or signup AND regression (smoke or signup evaluated first)
                                      // "not @ui" -> all scenarios that are NOT tagged with @ui

         features = "src/test/resources", // copy the path from the content root ,path to the folder where features files are located
         glue = "com/duotify/stepDefintions", //copy the path from the source root

         //stepNotifications = true, //
         plugin = {
                 "pretty",  // displays more detailed aka prettier output on the console about the result of the scenario run
                 "html:target/built-in-report/cucumber-html-report.html" , // generates built-in html report
                 "json:target/cucumber.json"
         }

         //,dryRun = true // quickly generate snippets without runnig the scenarion
     )
    public class CucumberRunner {
  }
