package edu.ntu.vison.socialloginplugin;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.facebook.FacebookSdk;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
    }

}
