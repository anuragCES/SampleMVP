package snippets.sample.mvp.Utility;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/**
 * Created by cesit on 19/12/15.
 */
public class JSONUtility {

    public String loadJSONFromAsset(Context view) {
        String json = null;
        try {
            InputStream inputStream = view.getAssets().open("Contacts.json");
            inputStream.available();
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void writeJSONToFile(Context context, String s) {
    }
}
