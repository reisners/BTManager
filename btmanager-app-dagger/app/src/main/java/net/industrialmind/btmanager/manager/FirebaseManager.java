package net.industrialmind.btmanager.manager;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by srn7919 on 06.07.17.
 */

public class FirebaseManager {

    @Inject
    public FirebaseManager() {}

    public Credentials retrieveStoredCredentials() {
        return null;
    }

    public static class Credentials {
        private String email;
        private String password;

        public Task<AuthResult> signIn(FirebaseAuth mAuth) {
            return mAuth.signInWithEmailAndPassword(email, password);
        }
    }

    public void createDeviceGroup() {

    }
}
