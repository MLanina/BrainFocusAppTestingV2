package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mlanina on 27/04/17.
 */
public class PopUpElements extends AbstractElement{

    public PopUpElements(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

    @FindBy(id = "android:id/button2")
    private WebElement cancelButton;

    @FindBy(id = "android:id/message")
    private WebElement question;

    public WebElement getOkButton(){
        return okButton;
    }

    public WebElement getCancelButton(){
        return cancelButton;
    }

    public WebElement getQuestion(){
        return question;
    }
}
