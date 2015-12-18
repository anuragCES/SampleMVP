package snippets.sample.anuragsharma.samplemvptest.Login;

import android.util.Log;

import snippets.sample.anuragsharma.samplemvptest.Login.Interface.ILoginListener;
import snippets.sample.anuragsharma.samplemvptest.Login.Interface.ILoginPresenter;

/**
 * Created by anuragsharma on 12/18/15.
 */
public class LoginPresenter implements ILoginPresenter, ILoginListener {

    private LoginActivity view;
    private LoginInteractor interactor;
    private String LOGTAG = "LOGIN Presnt";

    public LoginPresenter(LoginActivity view, LoginInteractor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void attemptLogin(String username, String password) {
        Log.d(LOGTAG, "attempted Login....");
        interactor.validatedCredentials(this, username, password);
    }

    @Override
    public void onSuccess() {
        Log.d(LOGTAG, "Login Success....");
        view.navigateToContactList();
    }

    @Override
    public void onFailure() {
        Log.d(LOGTAG, "Login Failed....");
        view.loginFailed();
    }
}
