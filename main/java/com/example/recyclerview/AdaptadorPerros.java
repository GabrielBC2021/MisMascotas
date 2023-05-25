package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdaptadorPerros extends RecyclerView.Adapter<AdaptadorPerros.MyViewHolder> {
    private final RecycleViewInterface recycleViewInterface;
    Context context;
    ArrayList<DetallePerros> detallePerros;

    public AdaptadorPerros (Context context, ArrayList<DetallePerros> detallePerros,
                            RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.detallePerros = detallePerros;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public AdaptadorPerros.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false);

        return new AdaptadorPerros.MyViewHolder(view, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPerros.MyViewHolder holder, int position) {
        holder.tvName.setText(detallePerros.get(position).getPerroNombre());
        holder.tv1Letter.setText(detallePerros.get(position).getPerroDescripcion());
        holder.imageViewHueso.setImageResource(detallePerros.get(position).getImagenHueso());
        holder.imageView.setImageResource(detallePerros.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return detallePerros.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, imageViewHueso;
        TextView tvName, tv1Letter;

        public MyViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            imageViewHueso = itemView.findViewById(R.id.imageView2);
            tv1Letter = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recycleViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
