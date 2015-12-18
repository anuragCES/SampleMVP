package snippets.sample.anuragsharma.Contact;

import java.util.ArrayList;

import snippets.sample.anuragsharma.Contact.ContactArrayAdapter.ContactArrayAdapter;
import snippets.sample.anuragsharma.Contact.Interface.IContactInteractor;

/**
 * Created by cesit on 18/12/15.
 */
public class ContactInteractor implements IContactInteractor {
    @Override
    public ArrayList<Contact> populateContactList() {
        ArrayList contact = new ArrayList<Contact>();
        for(int i = 0 ; i < 10 ; i++){
            contact.add(new Contact("Contact "+i, "Phone No "+i));
        }
        return contact;
    }
}
