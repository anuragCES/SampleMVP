package snippets.sample.anuragsharma.Contact;

import snippets.sample.anuragsharma.Contact.Interface.IContact;

/**
 * Created by cesit on 18/12/15.
 */
public class Contact  implements IContact{
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumber() {
        return phoneNumber;
    }
}
