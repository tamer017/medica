package com.example.m1.BottomNavigationBarFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.m1.Activities.MainActivity;
import com.example.m1.R;
import com.google.firebase.auth.FirebaseAuth;


public class HomeFragment extends Fragment implements View.OnClickListener {
    Button logout;
    View view;
    Context context;
    FirebaseAuth auth;

    public HomeFragment(Context context) {
        this.context = context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
auth=FirebaseAuth.getInstance();
        view = inflater.inflate(R.layout.fragment_home, container, false);
        logout = view.findViewById(R.id.log_out);
        logout.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.log_out:
                auth.signOut();
                intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
                break;

        }
    }
}