package snippets.sample.anuragsharma.Contact;

import android.content.Context;

import snippets.sample.anuragsharma.Contact.ContactArrayAdapter.ContactArrayAdapter;
import snippets.sample.anuragsharma.Contact.Interface.IContactPresenter;
import snippets.sample.anuragsharma.samplemvptest.R;

/**
 * Created by cesit on 18/12/15.
 */
public class ContactPresenter implements IContactPresenter {

    private Context view;
    private ContactInteractor interactor;

    ContactPresenter(Context context, ContactInteractor contactInteractor){
        this.view = context;
        this.interactor = contactInteractor;
    }

    @Override
    public ContactArrayAdapter getContactArrayAdapter(){
        ContactArrayAdapter contactArrayAdapter = new ContactArrayAdapter(this.view, R.layout.list_item_card);
        contactArrayAdapter.addAll(interactor.populateContactList());
        return contactArrayAdapter;
    }
}
