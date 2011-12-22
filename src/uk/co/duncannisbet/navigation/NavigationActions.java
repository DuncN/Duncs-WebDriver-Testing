
package uk.co.duncannisbet.navigation;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationActions {

    private WebElement navBarMenu;
    private WebElement banner;
    private WebElement carousel;
    private WebElement sidebar;
    private WebElement olderEntries;
    private final WebDriver driver;

    public NavigationActions(WebDriver driver) {
        this.driver = driver;
    }

    public void givenUserIsOnPage(String page) {
        driver.get(page);

    }

    public void whenUserClicksOnNavLink(String navlink) {
        navBarMenu = driver.findElement(By.id(navlink));
        navBarMenu.click();
    }

    public void whenUserClicksOnSidebarLink(String sidebarlink) {
        sidebar = driver.findElement(By.id(sidebarlink));
        sidebar.click();
    }

    public void whenUserClicksOnBanner() {
        banner = driver.findElement(By.xpath("//div[@id='header']/a/img"));
        banner.click();
    }

    public void whenUserClicksCarouselLink() {
        carousel = driver.findElement(By.xpath("//a[@title='Autotrader']/img"));
        carousel.click();
    }

    public void thenPageIsDisplayed(String page) {
        assertThat("Page Title is wrong", driver.getTitle(), is(page));
    }

    public void whenUserClicksOnOlderEntriesLink(String olderEntriesLink) {
        olderEntries = driver.findElement(By.xpath("//a[@href='http://www.duncannisbet.co.uk/blog/page/2']"));
        olderEntries.click();

    }

}
