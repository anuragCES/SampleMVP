package snippets.sample.mvp.AddContact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import snippets.sample.mvp.AddContact.Interface.IAddContactActivity;
import snippets.sample.mvp.Contact.ContactActivity;
import snippets.sample.mvp.samplemvptest.R;

public class AddContactActivity extends AppCompatActivity implements IAddContactActivity {

    private EditText mContactName;
    private EditText mContactEmail;
    private EditText mPhoneNumber;
    private Button mAddContactButton;
    private String TAG = "AddContactActivity";

    // Add contact prsenter
    private AddContactPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        presenter = new AddContactPresenter(this, new AddContactInteractor());

        // Set up add contact form
        mContactName = (EditText) findViewById(R.id.text_add_contact_name);
        mContactEmail = (EditText) findViewById(R.id.text_add_contact_email);
        mPhoneNumber = (EditText) findViewById(R.id.text_add_contact_phone);
    }

    @Override
    public void addContact(View view) {
        Log.d(TAG, "add Contact");
        presenter.attemptAddContact(mContactName.getText().toString(), mContactEmail.getText().toString(), mPhoneNumber.getText().toString());
    }

    @Override
    public void navigateToContactList() {
        startActivity(new Intent(this, ContactActivity.class));
    }

    @Override
    public void showFailureMessage() {

    }

}
