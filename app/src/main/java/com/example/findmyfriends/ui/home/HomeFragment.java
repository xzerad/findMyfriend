package com.example.findmyfriends.ui.home;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.findmyfriends.MainActivity;
import com.example.findmyfriends.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnSendHome.setOnClickListener(view -> {
            String numero = binding.edNumHome.getText().toString();
            if(MainActivity.send_permission){
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(
                        numero,
                        null,
                        "#FindFriend:",
                        null,
                        null
                );
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}