package snippets.sample.mvp.samplemvptest.Login.Interface;

/**
 * Created by anuragsharma on 12/18/15.
 */
public interface ILoginInteractor {
    void validatedCredentials(ILoginListener callback, String username, String password);
    boolean isCredentialValid(String username, String password);
}
