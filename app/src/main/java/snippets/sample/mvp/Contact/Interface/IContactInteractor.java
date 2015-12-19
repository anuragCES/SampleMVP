package snippets.sample.mvp.Contact.Interface;

import java.util.ArrayList;

import snippets.sample.mvp.Contact.Contact;

/**
 * Created by cesit on 18/12/15.
 */
public interface IContactInteractor {
    void populateContactList(IContactListLoadCallback callback, String contactsJson);
}
