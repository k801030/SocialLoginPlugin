package edu.ntu.vison.socialloginplugin.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import edu.ntu.vison.socialloginplugin.R;
import edu.ntu.vison.socialloginplugin.activity.MainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    LoginButton facebookloginBtn;
    CallbackManager callbackManager;
    LoginManager loginManager;

    public MainActivityFragment() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        callbackManager = ((MainActivity)getActivity()).mCallbackManager;
        loginManager = LoginManager.getInstance();

        facebookloginBtn = (LoginButton)view.findViewById(R.id.facebook_login_button);
        facebookloginBtn.setFragment(this); // let the fragment to received calls rather than activity
        facebookloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPermission();
            }
        });

        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });

        return view;
    }

    private void getPermission() {
        loginManager.logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends"));
    }
}
