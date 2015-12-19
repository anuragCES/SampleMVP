package snippets.sample.mvp.Contact.Interface;

import android.view.View;

import snippets.sample.mvp.Contact.ContactArrayAdapter.ContactArrayAdapter;
import snippets.sample.mvp.Contact.ContactPresenter;

/**
 * Created by cesit on 19/12/15.
 */
public interface IContactActivity {
    public void addContact(View view);
    public void setContactsListAdapter(ContactArrayAdapter contactArrayAdapter);
    public void failedToLoadData();
}
