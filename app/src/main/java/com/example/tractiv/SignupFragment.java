package com.example.tractiv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SignupFragment extends Fragment {

    private Button signupwithPhoneNumberBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        signupwithPhoneNumberBtn = v.findViewById(R.id.signUpWithPhoneNumberButton);
        signupwithPhoneNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),IntroActivity.class));
            }
        });
        return v;
    }

}

