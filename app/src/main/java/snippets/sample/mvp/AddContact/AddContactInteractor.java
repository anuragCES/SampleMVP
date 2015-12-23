package snippets.sample.mvp.AddContact;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import snippets.sample.mvp.AddContact.Interface.IAddContactCallback;
import snippets.sample.mvp.AddContact.Interface.IAddContactInteractor;
import snippets.sample.mvp.Utility.JSONUtility;

/**
 * Created by cesit on 19/12/15.
 */
public class AddContactInteractor implements IAddContactInteractor {

    private JSONUtility jsonUtility;

    AddContactInteractor(){
        this.jsonUtility = new JSONUtility();
    }

    @Override
    public void addContactToList(final IAddContactCallback addContactCallback, Context context, final String name, final String email, final String phoneNumber) {
        // Add Logic for a JSON file

        String jsonString = jsonUtility.loadJSONFromAsset(context);
        String NAME= "givenName";
        String EMAIL= "familyName";
        String PHONENUMBER= "tel";

        JSONArray contacts;
        JSONObject newContact = new JSONObject();


        try {
            contacts = new JSONArray(jsonString);
            newContact.put(NAME, name);
            newContact.put(EMAIL, email);
            newContact.put(PHONENUMBER, phoneNumber);
            contacts.put(newContact);
            jsonUtility.writeToFile(contacts.toString(), context);
            addContactCallback.addContactSuccessCallback();
        } catch (JSONException e) {
            e.printStackTrace();
            addContactCallback.addCallbackFailureCallback();
        }
    }
}
