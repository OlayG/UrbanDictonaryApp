package com.example.urbandictonaryapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbandictonaryapp.databinding.DefinitionListItemBinding;
import com.example.urbandictonaryapp.model.Definition;

import java.util.ArrayList;
import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder> {

    private List<Definition> definitions;

    public DictionaryAdapter() {
        this.definitions = new ArrayList<>();
    }

    @NonNull
    @Override
    public DictionaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DefinitionListItemBinding binding = DefinitionListItemBinding.inflate(
                layoutInflater,
                parent,
                false
        );
        return new DictionaryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DictionaryViewHolder holder, int position) {
        Definition definition = definitions.get(position);
        holder.bindData(definition);
    }

    @Override
    public int getItemCount() {
        return definitions.size();
    }

    public void updateDefinitionList(List<Definition> definitions) {
        this.definitions.clear();
        this.definitions = definitions;
        notifyDataSetChanged();
    }

    class DictionaryViewHolder extends RecyclerView.ViewHolder {
        private DefinitionListItemBinding binding;

        public DictionaryViewHolder(@NonNull DefinitionListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Definition definition) {
            binding.setDefinition(definition);
            binding.executePendingBindings();
        }
    }
}
