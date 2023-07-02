package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidCredentials")
    public static Object[][] dataset(){
        return new Object[][]{
                {"standard_user", "secret"},
                {"standard_user123","secret_sauce"},
                {"    standard_user", "       secret_sauce"}
        };
    }
}
