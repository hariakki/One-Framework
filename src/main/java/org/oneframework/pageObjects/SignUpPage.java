package org.oneframework.pageObjects;

import org.oneframework.helpers.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

import static org.oneframework.logger.LoggingManager.logMessage;

public class SignUpPage extends Page {

    WebDriver driver;
    HashMap<String, HashMap> elePageTitle = new HashMap<>();

    public SignUpPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logMessage("Initializing the "+this.getClass().getSimpleName()+" elements");

        elePageTitle.put("android", new HashMap(){{put("id", "label");}});
        elePageTitle.put("ios", new HashMap(){{put("id", "Log in to WordPress.com using an email address to manage all your WordPress sites.");}});
        elePageTitle.put("web", new HashMap(){{put("xpath", "//div[@class='login__form-header']");}});
        Thread.sleep(1000);
    }

    public String getTitle() throws Exception {
        return getText(driver, elePageTitle);
    }
}
