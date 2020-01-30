package br.com.victoramaral.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.com.victoramaral.myapplication.R;
import br.com.victoramaral.myapplication.viewmodel.ProdutosViewModel;

public class ProdutosFragment extends Fragment {

    private ProdutosViewModel produtosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);
        produtosViewModel = ViewModelProviders.of(this).get(ProdutosViewModel.class);

        return view;
    }
}