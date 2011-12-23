
package uk.co.duncannisbet.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationElements {

    private WebElement navBarMenu;
    private WebElement banner;
    private WebElement carousel;
    private WebElement sidebar;
    private WebElement olderEntries;
    private WebElement blogPostTitle;
    private WebElement blogPostReadMore;
    private final WebDriver driver;

    public NavigationElements(WebDriver driver) {
        this.driver = driver;
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

    public void whenUserClicksOnOlderEntriesLink(String olderEntriesLink) {
        olderEntries = driver.findElement(By.xpath("//a[@href='http://www.duncannisbet.co.uk/blog/page/2']"));
        olderEntries.click();

    }

    public void andCanSeeBogPost(String post) {
        blogPostTitle = driver.findElement(By.xpath("//a [contains(text(),'" + post + "')]"));

    }

    public void whenUserClicksOnPostTitle(String postTitle) {
        blogPostTitle = driver.findElement(By.xpath("//a [contains(text(),'" + postTitle + "')]"));
        blogPostTitle.click();

    }

    public void whenUserClicksOnReadFullPostLinkFor(String readFullPost, String pageId) {
        blogPostReadMore = driver.findElement(By.xpath("//a[@href='http://www.duncannisbet.co.uk/" + readFullPost + "#more-" + pageId +"']"));
        blogPostReadMore.click();

    }

}
