package snippets.sample.mvp.Contact;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import snippets.sample.mvp.Contact.Interface.IContactInteractor;
import snippets.sample.mvp.Contact.Interface.IContactListLoadCallback;
import snippets.sample.mvp.Utility.JSONUtility;

/**
 * Created by cesit on 18/12/15.
 */
public class ContactInteractor implements IContactInteractor {

    private JSONUtility jsonUtility;
    private String TAG = "Contacts Interactor";

    ContactInteractor(){
        jsonUtility = new JSONUtility();
    }

    @Override
    public void populateContactList(IContactListLoadCallback callback, String contactsJsonString) {
        ArrayList contact = new ArrayList<Contact>();
        try {
            JSONArray contactsJson = new JSONArray(contactsJsonString);
            Log.d(TAG, "" + contactsJson.length());
            for(int i = 0 ;  i < contactsJson.length() ; i ++){
                JSONObject contactJsonObject = contactsJson.getJSONObject(i);
                contact.add(new Contact("Contact "+contactJsonObject.get("givenName").toString(), "Phone No "+contactJsonObject.get("tel").toString()));
            }

            if(!contact.isEmpty()) {
                callback.onSuccess(contact);
            }
            else{
                callback.onFailure();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            callback.onFailure();
        }
    }
}
