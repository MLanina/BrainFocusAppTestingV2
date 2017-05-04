package Steps;

import Elements.MainPageElements;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mlanina on 27/04/17.
 */
public class MainPageSteps extends CommonSteps {

    MainPageElements mainPageElements;

    public MainPageSteps(AndroidDriver driver) {
        this.mainPageElements = new MainPageElements(driver);
    }


    @Step(value = "Check if BrainFocus label is displayed")
       public MainPageSteps ifLogoIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getLabel());
        return this;
    }

    @Step(value = "Check if BrainView is displayed")
    public MainPageSteps ifAppLabelIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getBrainView());
        return this;
    }

    @Step(value = "Check if StartButton is displayed")
    public MainPageSteps ifStartButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getStartButton());
        return this;
    }

    @Step(value = "Check if BreakButton is displayed")
    public MainPageSteps ifBreakButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getBreakButton());
        return this;
    }

    @Step(value = "Check if ProgressView is displayed")
    public MainPageSteps ifProgressViewIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getProgressCircle());
        return this;
    }

    @Step(value = "Check if SkipBreak button is displayed")
    public MainPageSteps ifSkipBreakButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getSkipBreakButton());
        return this;
    }

    @Step(value = "Check if Pause button is displayed")
    public MainPageSteps ifPauseButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getPauseButton());
        return this;
    }

    @Step(value = "Check if Stop button is displayed")
    public MainPageSteps ifStopButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getStopButton());
        return this;
    }

    @Step(value = "Check if PlusOne button is displayed")
    public MainPageSteps ifPlusOneButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getPlusOneButton());
        return this;
    }

    @Step(value = "Check if Resume button is displayed")
    public MainPageSteps ifResumeButtonIsDisplayed(){
        checkIfElementIsDisplayed(mainPageElements.getResumeButton());
        return this;
    }

    @Step(value = "Check minutes count is 25 by default")
    public MainPageSteps checkMinutesCountByDefault(){
        checkIfElementIsDisplayed(mainPageElements.getMinutes());
        assertThat("Minutes count is not 25", mainPageElements.getMinutes().getText().equals("25"));
        return this;
    }

    @Step(value = "Check seconds count is 0 by default")
    public MainPageSteps checkSecondsCountByDefault(){
        checkIfElementIsDisplayed(mainPageElements.getSeconds());
        assertThat("Seconds count is not 00", mainPageElements.getSeconds().getText().equals("00"));
        return this;
    }

    @Step(value = "Click on Start Button")
    public MainPageSteps clickOnStartButton() {
        clickOnElement(mainPageElements.getStartButton());
        return this;
    }

    @Step(value = "Click on Break Button")
    public MainPageSteps clickOnBreakButton() {
        clickOnElement(mainPageElements.getBreakButton());
        return this;
    }

    @Step(value = "Click on Pause Button")
    public MainPageSteps clickOnPauseButton() {
        clickOnElement(mainPageElements.getPauseButton());
        return this;
    }

    @Step(value = "Click on Resume button")
    public MainPageSteps clickOnResumeButton() {
        mainPageElements.getResumeButton().click();
        return this;
    }

    @Step(value = "Click on SkipBreak button")
    public MainPageSteps clickOnSkipBreakButton() {
        mainPageElements.getSkipBreakButton().click();
        return this;
    }

    @Step(value = "Click on Stop button")
    public MainPageSteps clickOnStopButton() {
        mainPageElements.getStopButton().click();
        return this;
    }


    @Step(value = "Verify number of minutes has increased after clicking PlusOne button")
    public void checkMinutesNumberIncreased() {
        int currentMinuteValue = Integer.valueOf(mainPageElements.getMinutes().getText());
        mainPageElements.getPlusOneButton().click();
        int minuteValueAfterClick = Integer.valueOf(mainPageElements.getMinutes().getText());
        int dif = minuteValueAfterClick - currentMinuteValue;
        assertThat("Number of minutes hasn't increased", dif == 1);
    }


    @Step(value = "Verify work session started")
    public MainPageSteps checkWorkSessionStarted() {
        assertThat("The countdown has not started", Integer.valueOf(mainPageElements.getMinutes().getText()) < 25);
        return this;
    }

    @Step(value = "Verify break started")
    public void checkBreakStarted() {
        assertThat("The countdown has not started", Integer.valueOf(mainPageElements.getMinutes().getText()) < 5);
    }

    @Step(value = "Verify all the elements are displayed after clicking on Pause Button")
    public void checkElementsAfterClickingOnPause() {
        assertThat("Resume button is not displayed", mainPageElements.getResumeButton().isDisplayed());
        assertThat("SkipBreak button is not displayed", mainPageElements.getSkipBreakButton().isDisplayed());
        assertThat("Stop button is not displayed", mainPageElements.getStopButton().isDisplayed());
    }
}
