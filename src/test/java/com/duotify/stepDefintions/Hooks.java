package com.duotify.stepDefintions;

import com.duotify.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {


    @Before ("not @db")
    public void setup(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Before ("@db")
    public void setupDB(){


        System.out.println("Setting up DB");
    }



    @After ("not @db")        // another option  @After ("@ui")
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshotAs = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs,"image/png", "screenshotOfFailure");
        }



        Driver.quitDriver();
    }

    @After ("@db")
    public void tearDownDB(){

        System.out.println("Tearing down db connection");
    }
}
