package com.imdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get("https://www.imdb.com");
    }

    public void navigateToTopMoviesPage() throws InterruptedException {

        WebElement navigationButton = driver.findElement(By.xpath("/html/body/div[2]/nav/div[2]/label[2]/div"));
        navigationButton.click();
        Thread.sleep(2000);
        WebElement top250button = driver.findElement(By.xpath("/html/body/div[2]/nav/div[2]/aside/div/div[2]/div/div[1]/span/div/div/ul/a[3]/span"));
        top250button.click();
        String topMoviesPageTitle = driver.getTitle();
        Assert.assertEquals(topMoviesPageTitle, "Top 250 Movies - IMDb");
    }
}
