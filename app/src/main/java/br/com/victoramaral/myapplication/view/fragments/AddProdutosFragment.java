package br.com.victoramaral.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.com.victoramaral.myapplication.R;
import br.com.victoramaral.myapplication.viewmodel.AddProdutosViewModel;

public class AddProdutosFragment extends Fragment {

    private AddProdutosViewModel addProdutosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addprodutos, container, false);
        addProdutosViewModel = ViewModelProviders.of(this).get(AddProdutosViewModel.class);


        return view;
    }
}