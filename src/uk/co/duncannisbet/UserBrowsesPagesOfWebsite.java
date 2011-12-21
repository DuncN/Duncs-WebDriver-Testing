//TODO - refactor class to follow Page Object Pattern
package uk.co.duncannisbet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserBrowsesPagesOfWebsite {

    private static WebDriver driver;
    private WebElement navBarMenu;
    private WebElement banner;

    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void homepageTitleIsCorrect() {

        givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        assertThat("Page Title is wrong", driver.getTitle(), is("Duncan Nisbet Bespoke Testing"));

    }

    @Test
    public void userNavigatesFromHomePageToWhoIAmPage() {
        givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        whenUserClicksOnNavLink("menu-item-93");
        thenPageIsDisplayed("Duncan Nisbet Software Testing Services | Duncan Nisbet");

    }

    @Test
    public void userNavigatesFromWhoIAmPageToHowITest() {
        givenUserIsOnPage("http://www.duncannisbet.co.uk/who-is-duncan-nisbet");
        whenUserClicksOnNavLink("menu-item-91");
        thenPageIsDisplayed("How I will test your software | Duncan Nisbet");
    }

    @Test
    public void userClickingOnBannerIsNavigatedToHome() {
        givenUserIsOnPage("http://www.duncannisbet.co.uk/what-i-test");
        whenUserClicksOnBanner();
        thenPageIsDisplayed("Duncan Nisbet Bespoke Testing");
    }

    private void givenUserIsOnPage(String page) {
        driver.get(page);

    }

    private void whenUserClicksOnNavLink(String navlink) {
        navBarMenu = driver.findElement(By.id(navlink));
        navBarMenu.click();
    }

    private void whenUserClicksOnBanner() {
        banner = driver.findElement(By.xpath("//div[@id='header']/a/img"));
        banner.click();
    }

    private void thenPageIsDisplayed(String page) {
        assertThat("Page Title is wrong", driver.getTitle(), is(page));
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
