package DropDown;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownMenu {
	private ChromeDriver driver;

	private static final String URL = "https://the-internet.herokuapp.com/dropdown";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void tearDown() {
		driver.quit();	
	}
	@Test
	public void canSelectDropDownOptionTest() throws InterruptedException {
		openHomePage();
		Assert.assertEquals(driver.getCurrentUrl(), URL);
		
		WebElement dropdownElement = selectDropDownMenu();
		
		Select dropdown = new Select(dropdownElement);
		
		Thread.sleep(2000);
		selectOption2(dropdown);
		
		Thread.sleep(2000);
		selectOption1(dropdown);
		
		Thread.sleep(2000);
		
	}
	private void selectOption1(Select dropdown) {
		dropdown.selectByVisibleText("Option 1");
	}
	private void selectOption2(Select dropdown) {
		dropdown.selectByVisibleText("Option 2");
	}
	private WebElement selectDropDownMenu() {
		By dropdownId = By.id("dropdown");
		WebElement dropdownElement = driver.findElement(dropdownId);
		return dropdownElement;
	}
	private void openHomePage() {
		driver.get(URL);
	}
	
	
}


