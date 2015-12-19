package snippets.sample.mvp.AddContact;

import android.util.Log;
import android.view.View;

import snippets.sample.mvp.AddContact.Interface.IAddContactCallback;
import snippets.sample.mvp.AddContact.Interface.IAddContactPresenter;

/**
 * Created by cesit on 19/12/15.
 */
public class AddContactPresenter implements IAddContactPresenter, IAddContactCallback {

    private AddContactInteractor interactor;
    private AddContactActivity view;
    private String TAG="AddContactPresenter";

    public AddContactPresenter(AddContactActivity view, AddContactInteractor interactor){
        this.interactor = interactor;
        this.view = view;
    }

    @Override
    public void addContactSuccessCallback() {
        Log.d(TAG, "addContactSuccessCallback");
        view.navigateToContactList();
    }

    @Override
    public void addCallbackFailureCallback() {
        Log.d(TAG, "addCallbackFailureCallback");
        view.showFailureMessage();
    }

    @Override
    public void attemptAddContact(String name, String email, String phoneNumber) {
        interactor.addContactToList(this, view, name, email, phoneNumber);
    }
}
