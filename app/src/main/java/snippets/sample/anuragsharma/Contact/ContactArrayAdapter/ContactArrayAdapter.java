package snippets.sample.anuragsharma.Contact.ContactArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import snippets.sample.anuragsharma.Contact.Contact;
import snippets.sample.anuragsharma.samplemvptest.R;

/**
 * Created by cesit on 18/12/15.
 */
public class ContactArrayAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contactList = new ArrayList<Contact>();
    private String TAG = "ContactAdapter";

    public ContactArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Contact object){
        contactList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.contactList.size();
    }

    @Override
    public Contact getItem(int index) {
        return this.contactList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactCardViewHolder contactCardViewHolder;

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_card, parent, false);
            contactCardViewHolder = new ContactCardViewHolder();
            contactCardViewHolder.contactName = (TextView) row.findViewById(R.id.line1);
            contactCardViewHolder.phoneNumber = (TextView) row.findViewById(R.id.line2);

            row.setTag(contactCardViewHolder);
        }
        else{
            contactCardViewHolder = (ContactCardViewHolder) row.getTag();
        }

        Contact contact = getItem(position);
        contactCardViewHolder.contactName.setText(contact.getName().toString());
        contactCardViewHolder.phoneNumber.setText(contact.getNumber().toString());

        return row;
    }
}
