package snippets.sample.mvp.AddContact.Interface;

import android.content.Context;

/**
 * Created by cesit on 19/12/15.
 */
public interface IAddContactInteractor {
    public void addContactToList(IAddContactCallback addContactCallback, Context context,String name, String email, String phoneNumber);
}
