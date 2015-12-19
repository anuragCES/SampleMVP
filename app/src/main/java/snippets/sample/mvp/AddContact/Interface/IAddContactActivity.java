package snippets.sample.mvp.AddContact.Interface;

import android.view.View;

/**
 * Created by cesit on 19/12/15.
 */
public interface IAddContactActivity {
    public void addContact(View view);
    public void navigateToContactList();
    public void showFailureMessage();
}
