package com.example.grocerystoreapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    private List<GroceryItem> groceryItems;

    public GroceryAdapter(List<GroceryItem> groceryItems) {
        this.groceryItems = groceryItems;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grocery_item, parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        GroceryItem item = groceryItems.get(position);
        holder.textViewGroceryName.setText(item.getName());
        holder.imageViewGrocery.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return groceryItems.size();
    }

    static class GroceryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewGroceryName;
        ImageView imageViewGrocery;

        GroceryViewHolder(View itemView) {
            super(itemView);
            textViewGroceryName = itemView.findViewById(R.id.textViewGroceryName);
            imageViewGrocery = itemView.findViewById(R.id.imageViewGrocery);
        }
    }
}
