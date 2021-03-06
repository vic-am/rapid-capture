package br.com.victoramaral.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.com.victoramaral.myapplication.R;
import br.com.victoramaral.myapplication.viewmodel.SobreViewModel;

public class SobreFragment extends Fragment {

    private SobreViewModel sobreViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sobre, container, false);
        sobreViewModel = ViewModelProviders.of(this).get(SobreViewModel.class);

        return view;
    }
}