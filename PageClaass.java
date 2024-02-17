package PomPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClaass {

    WebDriver driver;

    @FindBy(css = "[placeholder='Enter Your Name']")
    private WebElement alertBox;
    @FindBy(id = "alertbtn")
    private WebElement alertButton;
    @FindBy(css = "#mousehover")
    private WebElement hover;
    @FindBy(xpath = "//div[@class='mouse-hover-content']/a")
    private WebElement top;
    @FindBy(xpath = "//table[@id='product']/tbody/tr[3]/td[2]")
    private WebElement webTable;



    public PageClaass (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setAlertBox(String name) {
    alertBox.sendKeys(name);
    }
    public void setAlertButton(){
        alertButton.click();
    }
    public void setHover(){
        Actions action=new Actions(driver);
        action.moveToElement(hover).build().perform();

        top.click();
    }
    public String setWebTable(){
       return webTable.getText();

    }


}
