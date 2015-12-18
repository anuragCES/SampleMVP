package snippets.sample.anuragsharma.Contact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import snippets.sample.anuragsharma.Contact.ContactArrayAdapter.ContactArrayAdapter;
import snippets.sample.anuragsharma.samplemvptest.R;

public class ContactActivity extends AppCompatActivity {

    private ListView contactListView;
    private ContactArrayAdapter contactArrayAdapter;
    private ContactPresenter contactPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactListView = (ListView) findViewById(R.id.contact_listView);
        contactListView.addHeaderView(new View(this));
        contactListView.addFooterView(new View(this));

        contactPresenter = new ContactPresenter(this, new ContactInteractor());
        contactListView.setAdapter(contactPresenter.getContactArrayAdapter());

    }

}
