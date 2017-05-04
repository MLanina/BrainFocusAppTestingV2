package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mlanina on 04/05/17.
 */
public class AbstractElement {

    WebDriver webDriver;

    public AbstractElement(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
}
