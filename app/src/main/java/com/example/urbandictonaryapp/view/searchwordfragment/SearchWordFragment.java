package com.example.urbandictonaryapp.view.searchwordfragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.urbandictonaryapp.R;
import com.example.urbandictonaryapp.adapter.DictionaryAdapter;
import com.example.urbandictonaryapp.databinding.FragmentSearchWordBinding;
import com.example.urbandictonaryapp.model.Definition;
import com.example.urbandictonaryapp.view.BaseFragment;
import com.example.urbandictonaryapp.viewmodel.SearchWordViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchWordFragment extends BaseFragment {

    private FragmentSearchWordBinding binding;
    private DictionaryAdapter adapter;
    private SearchWordViewModel viewModel;

    public SearchWordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_search_word, container, false
        );
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        setupObservers();
    }

    private void setupObservers() {
        viewModel.getDefinitions().observe(
                this,
                definitions -> adapter.updateDefinitionList(definitions)
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())
                .create(SearchWordViewModel.class);

        binding.rvDefinitions.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DictionaryAdapter();
        binding.rvDefinitions.setAdapter(adapter);

        viewModel.getDefinitionsObservable("Wizard");
    }
}
