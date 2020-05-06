package test.testCases.DataProviderPack;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {
	
	@DataProvider(name = "data-provider-one")
    public Object[][] dataProviderMethodOne() {
        return new Object[][] { { "data three" }, { "data four" } };
    }

}
