package com.imdb;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverConfig {
    public ChromeDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        System.out.println("СТАРТУЕМ");

    }

    @AfterTest
    public void close(){
        System.out.println("ЗАКОНЧИЛИ");
        driver.close();
    }
}
