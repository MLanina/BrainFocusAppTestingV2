package Steps;

import org.openqa.selenium.WebElement;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 04/05/17.
 */
public class CommonSteps {
    public boolean checkIfElementIsDisplayed(WebElement webElement){
        assertThat("Element " + webElement + "is not displayed", webElement.isDisplayed());
        return webElement.isDisplayed();
    }

    public void clickOnElement(WebElement webElement){
        checkIfElementIsDisplayed(webElement);
        webElement.click();
    }
}
