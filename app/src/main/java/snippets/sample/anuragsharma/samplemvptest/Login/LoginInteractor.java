package snippets.sample.anuragsharma.samplemvptest.Login;

import android.os.Handler;

import snippets.sample.anuragsharma.samplemvptest.Login.Interface.ILoginInteractor;
import snippets.sample.anuragsharma.samplemvptest.Login.Interface.ILoginListener;

/**
 * Created by anuragsharma on 12/18/15.
 * Login Interactor
 * To provide buisness logic for Login view. In this case, we are faking authentication from server using
 * two seconds delay.
 */
public class LoginInteractor implements ILoginInteractor {

    public LoginInteractor(){}

    @Override
    public boolean validatedCredentials(final ILoginListener callback, final String username, final String password) {
        // Mock Login : Let's fake the server call to have delay in response
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(username.equals("test@mvp.com") && password.equals("test")){
                    callback.onSuccess();
                }
                else{
                    callback.onFailure();
                }
            }
        }, 2000);


        return false;
    }
}
