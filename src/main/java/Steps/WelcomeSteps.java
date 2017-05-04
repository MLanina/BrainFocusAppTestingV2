package Steps;

import Elements.WelcomeSlidesElements;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 27/04/17.
 */
public class WelcomeSteps extends CommonSteps{

    WelcomeSlidesElements welcomeSlidesElements;

    public WelcomeSteps(AndroidDriver driver) {
        this.welcomeSlidesElements = new WelcomeSlidesElements(driver);
    }

    @Step(value = "Check if Logo element is displayed")
    public WelcomeSteps ifLogoIsDisplayed(){
        checkIfElementIsDisplayed(welcomeSlidesElements.getLogo());
        return this;
    }

    @Step(value = "Check if first line has correct text")
    public WelcomeSteps ifFirstLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(0));
        assertThat("First line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(0).getText(),
                welcomeSlidesElements.getMessages().get(0).getText().equals(text));
        return this;
    }

    @Step(value = "Check if second line has correct text")
    public WelcomeSteps ifSecondLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(1));
        assertThat("Second line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(1).getText(),
                welcomeSlidesElements.getMessages().get(1).getText().equals(text));
        return this;
    }

    @Step(value = "Check if third line has correct text")
    public WelcomeSteps ifThirdLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(2));
        assertThat("Third line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(2).getText(),
                welcomeSlidesElements.getMessages().get(2).getText().equals(text));
        return this;
    }

    @Step(value = "Check if fourth line has correct text")
    public WelcomeSteps ifFourthLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(3));
        assertThat("Third line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(3).getText(),
                welcomeSlidesElements.getMessages().get(3).getText().equals(text));
        return this;
    }


    @Step(value = "Check if fifth line has correct text")
    public WelcomeSteps ifFifthLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(4));
        assertThat("Third line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(4).getText(),
                welcomeSlidesElements.getMessages().get(4).getText().equals(text));
        return this;
    }

    @Step(value = "Check if sixth line has correct text")
    public WelcomeSteps ifSixthLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(5));
        assertThat("Third line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(5).getText(),
                welcomeSlidesElements.getMessages().get(5).getText().equals(text));
        return this;
    }

    @Step(value = "Check if seventh line has correct text")
    public WelcomeSteps ifSSeventhLineHasCorrectTest(String text){
        checkIfElementIsDisplayed(welcomeSlidesElements.getMessages().get(6));
        assertThat("Third line has incorrect text. Expected " + text + " but found " +  welcomeSlidesElements.getMessages().get(6).getText(),
                welcomeSlidesElements.getMessages().get(6).getText().equals(text));
        return this;
    }

    @Step(value = "Click on Forward Button")
    public WelcomeSteps clickOnForwardButton(){
        clickOnElement(welcomeSlidesElements.getForwardButtonCircle());
        return this;
    }

    @Step(value = "Click on Backward Button")
    public WelcomeSteps clickOnBackwardButton(){
        clickOnElement(welcomeSlidesElements.getBackwardButtonCircle());
        return this;
    }

    @Step( value = "Click on Done button")
    public WelcomeSteps clickOnDoneButton(){
        clickOnElement(welcomeSlidesElements.getDoneButton());
        return this;
    }
}
