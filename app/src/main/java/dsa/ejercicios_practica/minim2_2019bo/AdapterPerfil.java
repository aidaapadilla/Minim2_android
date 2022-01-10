package dsa.ejercicios_practica.minim2_2019bo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dsa.ejercicios_practica.minim2_2019bo.models.Medalla;

public class AdapterPerfil extends RecyclerView.Adapter<AdapterPerfil.ViewHolder> {
    private List<Medalla> medallasUser;

    public class ViewHolder extends RecyclerView.ViewHolder{
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

    public void setData(List<Medalla> myDataset){
        medallasUser = myDataset;
        notifyDataSetChanged();
    }
    public void add(int position, Medalla item) {
        medallasUser.add(position, item);
        notifyItemInserted(position);
    }
    public AdapterPerfil(List<Medalla> myDataset) {
        medallasUser = myDataset;
    }

    public AdapterPerfil() {
        medallasUser = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterPerfil.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_row_layout_medallas, parent, false);
        // set the view's size, margins, paddings and layout parameters
        AdapterPerfil.ViewHolder vh = new AdapterPerfil.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medalla medalla = medallasUser.get(position);
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
    public int getItemCount() { return medallasUser.size(); }
}
