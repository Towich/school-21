package com.example.pr3.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pr3.R;
import com.example.pr3.ui.ViewModel.ContactsViewModel;


public class ContactsFragment extends Fragment {

    ContactsViewModel mContactsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContactsViewModel = new ViewModelProvider(this).get(ContactsViewModel.class);

        Button button_made_call = view.findViewById(R.id.button_made_call);
        button_made_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mContactsViewModel.getIntentMakeCall());
            }
        });

        Button button_send_email = view.findViewById(R.id.button_send_email);
        button_send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mContactsViewModel.getIntentSendEmail());
            }
        });
    }
}