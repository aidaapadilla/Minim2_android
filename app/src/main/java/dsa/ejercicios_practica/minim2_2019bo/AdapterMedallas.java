package dsa.ejercicios_practica.minim2_2019bo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dsa.ejercicios_practica.minim2_2019bo.models.Medalla;

public class AdapterMedallas extends RecyclerView.Adapter<AdapterMedallas.ViewHolder>{
    private List<Medalla> medallas;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public ImageView imgInsignea;
        public View layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            txtName = (TextView) itemView.findViewById(R.id.nameObject);
            imgInsignea = (ImageView) itemView.findViewById(R.id.imgObject);
        }
    }
    public void setData(List<Medalla> myDataset) {
        medallas = myDataset;
        notifyDataSetChanged();
    }

    public void add(int position, Medalla item) {
        medallas.add(position, item);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public AdapterMedallas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_row_layout_medallas, parent, false);
        // set the view's size, margins, paddings and layout parameters
        AdapterMedallas.ViewHolder vh = new AdapterMedallas.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medalla medalla = medallas.get(position);
        String name = medalla.getName();
        holder.txtName.setText(name);
        if(name.contentEquals("epico")){
            holder.imgInsignea.setImageResource(R.drawable.epico);
        }
        else if(name.contentEquals("jugon")){
            holder.imgInsignea.setImageResource(R.drawable.jugon);
        }
        else if(name.contentEquals("legendario")){
            holder.imgInsignea.setImageResource(R.drawable.legendario);
        }
        else if(name.contentEquals("lento")){
            holder.imgInsignea.setImageResource(R.drawable.lento);
        }
        else if(name.contentEquals("meteorico")){
            holder.imgInsignea.setImageResource(R.drawable.meteorico);
        }
        else if(name.contentEquals("sostenible")){
            holder.imgInsignea.setImageResource(R.drawable.sostenible);
        }
    }


    @Override
    public int getItemCount() {
        return medallas.size();
    }
}
