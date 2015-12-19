package snippets.sample.mvp.Contact.Interface;

import java.util.ArrayList;

import snippets.sample.mvp.Contact.Contact;

/**
 * Created by cesit on 19/12/15.
 */
public interface IContactListLoadCallback {
    public void onSuccess(ArrayList<Contact> contacts);
    public void onFailure();
}
