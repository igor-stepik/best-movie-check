package com.imdb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverConfig {
    public ChromeDriver driver;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("СТАРТУЕМ");


    }

    @AfterTest
    public void close(){
        System.out.println("ЗАКОНЧИЛИ");
        driver.close();
    }
}
