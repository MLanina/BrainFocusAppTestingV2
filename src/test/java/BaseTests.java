import Steps.MainPageSteps;
import Steps.PopUpSteps;
import Steps.SettingsSteps;
import Steps.WelcomeSteps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Created by mlanina on 24/04/17.
 */

public class BaseTests  {
    protected AppiumConfiguration appiumConfiguration = new AppiumConfiguration();
    protected AndroidDriver driver;
    protected DriverInstance driverInstance = new DriverInstance();
    protected static Logger LOG = Logger.getLogger(BaseTests.class.getName());
    protected MainPageSteps mainPageSteps;
    protected WelcomeSteps welcomeSteps;
    protected PopUpSteps popUpSteps;
    protected SettingsSteps settingsSteps;

    private static final String newWorkDuration = "35";
    private static final String newBreakDuration = "10";
    private static final String firstSlideFirstLine = "Work Smarter";
    private static final String firstSlideSecondLine = "Stop procrastinating! Do more faster!";
    private static final String firstSlideThirdLine = "This application will help you improve your productivity.";
    private static final String secondSlideFirstLine = "First step : Start a work session";
    private static final String secondSlideSecondLine = "Work on a project, study, do whatever work you want.";
    private static final String thirdSlideFirstLine = "Second step : Take a break";
    private static final String thirdSlideSecondLine = "Relax, stand up, walk, go grab water, do whatever you want. Then start a new work session.";
    private static final String fourthSlideFirstLine = "After 4 work sessions, it is time for a longer break!";
    private static final String fourthSlideSecondLine = "Go walk outside, grab something to eat or take a nap.";
    private static final String fifthSlideFirstLine = "Customizable";
    private static final String fifthSlideSecondLine = "Tweak the application until you reach the best work vs break ratio for you.";
    private static final String sixthSlideFirstLine = "Timer Controls";
    private static final String sixthSlideSecondLine = "Start a work session";
    private static final String sixthSlideThirdLine = "Start a break session";
    private static final String sixthSlideFourthLine = "Stop session";
    private static final String sixthSlideFifthLine = "Pause a session";
    private static final String sixthSlideSixthLine = "Resume a session";
    private static final String sixthSlideSeventhLine = "Skip a session";

    @BeforeSuite
    public void setConfiguration() {
        appiumConfiguration.startAppiumServer();
        driver = driverInstance.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOG.info("DriverInstance was configured");
        mainPageSteps = new MainPageSteps(driver);
        welcomeSteps = new WelcomeSteps(driver);
        popUpSteps = new PopUpSteps(driver);
        settingsSteps = new SettingsSteps(driver);
        LOG.info("MainPageSteps instance was successfully created");
    }

    @Test
    public void launchApp() {
        LOG.info("App is launched");

        welcomeSteps.ifLogoIsDisplayed()
                .ifFirstLineHasCorrectTest(firstSlideFirstLine)
                .ifSecondLineHasCorrectTest(firstSlideSecondLine)
                .ifThirdLineHasCorrectTest(firstSlideThirdLine)
                .clickOnForwardButton()
                .ifLogoIsDisplayed()
                .ifFirstLineHasCorrectTest(secondSlideFirstLine)
                .ifSecondLineHasCorrectTest(secondSlideSecondLine)
                .clickOnForwardButton()
                .ifLogoIsDisplayed()
                .ifFirstLineHasCorrectTest(thirdSlideFirstLine)
                .ifSecondLineHasCorrectTest(thirdSlideSecondLine)
                .clickOnForwardButton()
                .ifLogoIsDisplayed()
                .ifFirstLineHasCorrectTest(fourthSlideFirstLine)
                .ifSecondLineHasCorrectTest(fourthSlideSecondLine)
                .clickOnForwardButton()
                .ifLogoIsDisplayed()
                .ifFirstLineHasCorrectTest(fifthSlideFirstLine)
                .ifSecondLineHasCorrectTest(fifthSlideSecondLine)
                .clickOnForwardButton()
                .ifFirstLineHasCorrectTest(sixthSlideFirstLine)
                .ifSecondLineHasCorrectTest(sixthSlideSecondLine)
                .ifThirdLineHasCorrectTest(sixthSlideThirdLine)
                .ifFourthLineHasCorrectTest(sixthSlideFourthLine)
                .ifFifthLineHasCorrectTest(sixthSlideFifthLine)
                .ifSixthLineHasCorrectTest(sixthSlideSixthLine)
                .ifSSeventhLineHasCorrectTest(sixthSlideSeventhLine)
                .clickOnDoneButton();

    }

    @Test(dependsOnMethods = "launchApp")
    public void checkMainPage() {
        mainPageSteps.ifLogoIsDisplayed()
                .ifAppLabelIsDisplayed()
                .ifStartButtonIsDisplayed()
                .ifBreakButtonIsDisplayed()
                .ifProgressViewIsDisplayed()
                .checkMinutesCountByDefault()
                .checkSecondsCountByDefault();

    }

    @Test(dependsOnMethods = {"checkMainPage"})
    public void performWorkSession() {
        mainPageSteps.clickOnStartButton()
                .ifProgressViewIsDisplayed()
                .ifSkipBreakButtonIsDisplayed()
                .ifPauseButtonIsDisplayed()
                .ifStopButtonIsDisplayed()
                .ifPlusOneButtonIsDisplayed()
                .checkWorkSessionStarted()
                .clickOnPauseButton()
                .ifResumeButtonIsDisplayed()
                .ifSkipBreakButtonIsDisplayed()
                .ifStopButtonIsDisplayed()
                .clickOnResumeButton()
                .ifProgressViewIsDisplayed()
                .ifSkipBreakButtonIsDisplayed()
                .ifPauseButtonIsDisplayed()
                .ifStopButtonIsDisplayed()
                .ifPlusOneButtonIsDisplayed()
                .checkWorkSessionStarted();
    }

    //TO DO: Refactor according to Page Object

    @Test(dependsOnMethods = "performWorkSession")
    public void moveFromWorkSessionToBreak() {
        mainPageSteps.clickOnSkipBreakButton();
        //mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkBreakStarted();
    }

    @Test(dependsOnMethods = "moveFromWorkSessionToBreak")
    public void moveFromBreakToWorkSession() {
        mainPageSteps.clickOnSkipBreakButton();
       // mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkWorkSessionStarted();
    }

    @Test(dependsOnMethods = "moveFromBreakToWorkSession")
    public void increaseSessionDuration(){
       mainPageSteps.checkMinutesNumberIncreased();
    }

    @Test(dependsOnMethods = "increaseSessionDuration")
    public void skipWorkSession() {
        mainPageSteps.clickOnStopButton();
        popUpSteps.verifyElementsInPopUp();
        popUpSteps.clickOnCancelButton();
        mainPageSteps.clickOnStopButton();
        popUpSteps.verifyElementsInPopUp();
        popUpSteps.clickOnOKButton();
       // mainPageSteps.checkMainPageEementsAreDisplayed();
    }

    @Test(dependsOnMethods = "skipWorkSession")
    public void takeBreak() {
        mainPageSteps.clickOnBreakButton();
       // mainPageSteps.checkElementsArePresentAfterSessionStarts();
        mainPageSteps.checkBreakStarted();
        mainPageSteps.clickOnPauseButton();
        mainPageSteps.checkElementsAfterClickingOnPause();
        mainPageSteps.clickOnResumeButton();
       // mainPageSteps.checkElementsArePresentAfterSessionStarts();
    }

    @Test(dependsOnMethods = "takeBreak")
    public void checkSettingsExist() {
        settingsSteps.clickOnSettings();
        settingsSteps.checkSettingListDisplay();
        LOG.info("Settings are opened");
    }

    @Test(dependsOnMethods = "checkSettingsExist")
    public void adjustSettings() {
        settingsSteps.clickOnSettingsOption();
        settingsSteps.checkDurationSettingsAreDisplayed();
    }

    @Test(dependsOnMethods = "adjustSettings")
    public void changeWorkDuration() {
        settingsSteps.changeWorkDuration(newWorkDuration);
    }

    @Test (dependsOnMethods = "changeWorkDuration")
    public void changeBreakDuration(){
        settingsSteps.changeBreakDuration(newBreakDuration);
    }


    @AfterSuite
    public void stopAppiumServer() {
        driver.pressKeyCode(AndroidKeyCode.HOME);
        appiumConfiguration.stopAppiumServer();
    }
}
