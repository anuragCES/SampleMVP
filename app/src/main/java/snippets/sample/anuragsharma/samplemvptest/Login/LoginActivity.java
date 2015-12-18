package snippets.sample.anuragsharma.samplemvptest.Login;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import snippets.sample.anuragsharma.samplemvptest.Login.Interface.ILoginView;
import snippets.sample.anuragsharma.samplemvptest.R;

/**
 * A login screen that offers login via email/password.
 * Login activity do not know about the buisness logic and backend data.
 * We will handle only view transitions (Navigation) from it
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private String LOGTAG = "LOGIN ACTIVITY";

    // Login Presenter
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        // Without DI call to login presenter
        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    public void clickSignIn(View v){
        Log.d(LOGTAG, "Sign in");
        presenter.attemptLogin(mEmailView.getText().toString(), mPasswordView.getText().toString());
    }

    @Override
    public void navigateToContactList() {
        Toast.makeText(this, "Successful Login", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
    }
}

