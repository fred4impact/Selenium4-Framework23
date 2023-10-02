package org.techskillshub.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemNames;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (WebElement itemName : itemNames) {
            names.add(itemName.getText());
        }
        return names;
    }
}
