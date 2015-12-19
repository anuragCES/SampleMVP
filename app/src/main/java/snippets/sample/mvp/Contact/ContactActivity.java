package snippets.sample.mvp.Contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import snippets.sample.mvp.AddContact.AddContactActivity;
import snippets.sample.mvp.Contact.ContactArrayAdapter.ContactArrayAdapter;
import snippets.sample.mvp.Contact.Interface.IContactActivity;
import snippets.sample.mvp.samplemvptest.R;

public class ContactActivity extends AppCompatActivity implements IContactActivity {

    private ListView contactListView;
    private ContactArrayAdapter contactArrayAdapter;
    private ContactPresenter contactPresenter;
    private String TAG = "Contact Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactListView = (ListView) findViewById(R.id.contact_listView);
        contactListView.addHeaderView(new View(this));
        contactListView.addFooterView(new View(this));

        contactPresenter = new ContactPresenter(this, new ContactInteractor());
        contactPresenter.getContactArrayAdapter();
    }

    @Override
    public void addContact(View view){
        Log.d(TAG, "Clicked Add Button");
        startActivity(new Intent(this, AddContactActivity.class));
    }

    @Override
    public void setContactsListAdapter(ContactArrayAdapter contactArrayAdapter) {
        contactListView.setAdapter(contactArrayAdapter);
    }

    @Override
    public void failedToLoadData() {
        Toast.makeText(this, "Data cannot be loaded", Toast.LENGTH_LONG);
    }

}
