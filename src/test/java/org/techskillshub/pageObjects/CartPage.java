package org.techskillshub.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    private WebElement itemName;

    @FindBy(css = ".btn_primary.btn_inventory")
    private WebElement addToCartButton;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getCartBadgeCount() {
        return cartBadge.getText();
    }
}
