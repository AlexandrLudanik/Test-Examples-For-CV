package package_1;

import java.io.IOException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageObjectTest {

	@Test
	public void M0initializeDriver() throws IOException {
		Assert.assertTrue(PageObjectModel.initializeDriver());
	}
	
	@Test
	public void M1PageFactoryInit() throws IOException {
		Assert.assertTrue(PageObjectModel.PageFactoryInit());
	}
	
	@Test
	public void M2homePage() throws IOException {
		Assert.assertTrue(PageObjectModel.homePage());
	}
    
	@Test
	public void M3vrPage() throws IOException {
		Assert.assertTrue(PageObjectModel.vrPage());
	}
	
	@Test
	public void M4topSellersPage() throws IOException {
		Assert.assertTrue(PageObjectModel.topSellersPage());
	}
	
	@Test
	public void M5gamePageCheckDiscountPrice() throws IOException {
		Assert.assertTrue(PageObjectModel.gamePageCheckDiscountPrice());
	}
	
	@Test
	public void M6gamePagePressInstallSteamButton() throws IOException {
		Assert.assertTrue(PageObjectModel.gamePagePressInstallSteamButton());
	}
	
	@Test
	public void M7downloadPage() throws IOException {
		Assert.assertTrue(PageObjectModel.downloadPage());
	}
	
	
}