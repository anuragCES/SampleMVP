package snippets.sample.anuragsharma.samplemvptest.Login.Interface;

/**
 * Created by anuragsharma on 12/18/15.
 */
public interface ILoginInteractor {

    boolean validatedCredentials(ILoginListener callback, String username, String password);
}
