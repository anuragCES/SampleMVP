package snippets.sample.mvp.samplemvptest.Login;

import android.os.Handler;

import snippets.sample.mvp.samplemvptest.Login.Interface.ILoginInteractor;
import snippets.sample.mvp.samplemvptest.Login.Interface.ILoginListener;

/**
 * Created by anuragsharma on 12/18/15.
 * Login Interactor
 * To provide buisness logic for Login view. In this case, we are faking authentication from server using
 * two seconds delay.
 */
public class LoginInteractor implements ILoginInteractor {

    public LoginInteractor(){}

    @Override
    public void validatedCredentials(final ILoginListener callback, final String username, final String password) {
        // Mock Login : Let's fake the server call to have delay in response
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isCredentialValid(username, password)){
                    callback.onSuccess();
                }
                else{
                    callback.onFailure();
                }
            }
        }, 2000);

    }

    @Override
    public boolean isCredentialValid(final String username, final String password){
        if(username.equals("test@mvp.com") && password.equals("test")){
            return true;
        }
        else{
            return false;
        }
    }
}
