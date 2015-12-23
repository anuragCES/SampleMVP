package unittests;

import org.junit.Test;

import snippets.sample.mvp.samplemvptest.Login.Interface.ILoginListener;
import snippets.sample.mvp.samplemvptest.Login.LoginInteractor;
import snippets.sample.mvp.samplemvptest.Login.LoginPresenter;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by anuragsharma on 12/20/15.
 */
public class UTLoginInteractor {

    @Test
    public void validateLoginCredentials(){

        // Class tested
        LoginInteractor interactorTester = new LoginInteractor();

        // assert statements
        assertEquals(true, interactorTester.isCredentialValid("test@mvp.com", "test"));
        assertEquals(false, interactorTester.isCredentialValid("test1@mvp.com", "test"));
        assertEquals(false, interactorTester.isCredentialValid("test@mvp.com", "test12"));
    }


}
