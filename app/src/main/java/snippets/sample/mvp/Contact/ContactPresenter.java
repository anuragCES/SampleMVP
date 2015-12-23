package snippets.sample.mvp.Contact;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;

import snippets.sample.mvp.Contact.ContactArrayAdapter.ContactArrayAdapter;
import snippets.sample.mvp.Contact.Interface.IContactListLoadCallback;
import snippets.sample.mvp.Contact.Interface.IContactPresenter;
import snippets.sample.mvp.Utility.JSONUtility;
import snippets.sample.mvp.samplemvptest.R;

/**
 * Created by cesit on 18/12/15.
 */
public class ContactPresenter implements IContactPresenter, IContactListLoadCallback {

    private ContactActivity view;
    private ContactInteractor interactor;
    private JSONUtility jsonUtility;
    ContactArrayAdapter contactArrayAdapter;

    ContactPresenter(ContactActivity context, ContactInteractor contactInteractor){
        this.view = context;
        this.interactor = contactInteractor;
        this.jsonUtility = new JSONUtility();
        this.contactArrayAdapter = new ContactArrayAdapter(this.view, R.layout.list_item_card);
    }

    @Override
    public void getContactArrayAdapter(){
        interactor.populateContactList(this, jsonUtility.readFromJSONFile(view));
    }

    public void setArrayAdapter(ContactArrayAdapter contactArrayAdapter, ArrayList<Contact> contacts){
        for (Contact contact: contacts
             ) {
            contactArrayAdapter.add(contact);
        }
    }

    @Override
    public void onSuccess(ArrayList<Contact> contacts) {
        setArrayAdapter(contactArrayAdapter, contacts);
        view.setContactsListAdapter(contactArrayAdapter);
    }

    @Override
    public void onFailure() {
        view.failedToLoadData();
    }
}
