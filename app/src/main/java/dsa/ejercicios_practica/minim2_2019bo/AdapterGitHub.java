package dsa.ejercicios_practica.minim2_2019bo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dsa.ejercicios_practica.minim2_2019bo.models.Repositorio;
import dsa.ejercicios_practica.minim2_2019bo.models.User;

public class AdapterGitHub extends RecyclerView.Adapter<AdapterGitHub.ViewHolder>{
    private List<Repositorio> repositorioList;
    private User user;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName; //name of the repository
        public TextView txtLanguage;
        public View layout;
        public TextView numFollowers;
        public TextView numFollowing;
        public TextView nameUser;
        public ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            txtName = (TextView) itemView.findViewById(R.id.repositoryTxt);
            txtLanguage = (TextView) itemView.findViewById(R.id.languageTxt);
            numFollowers = (TextView) itemView.findViewById(R.id.numFollowersTxt);
            numFollowing = (TextView) itemView.findViewById(R.id.numFollowingTxt);
            nameUser = (TextView) itemView.findViewById(R.id.nameTxt);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
    public void setData(List<Repositorio> myDataset) {
        repositorioList = myDataset;
        notifyDataSetChanged();
    }
    public void setUser(User data){
        user = data;
    }

    public void add(int position, Repositorio item) {
        repositorioList.add(position, item);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public AdapterGitHub.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_row_layout_medallas, parent, false);
        // set the view's size, margins, paddings and layout parameters
        AdapterGitHub.ViewHolder vh = new AdapterGitHub.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repositorio repositorio = repositorioList.get(position);
        String name = repositorio.getRepositoryName();
        String language = repositorio.getLanguage();
        holder.txtName.setText(name);
        holder.txtLanguage.setText(language);
        holder.nameUser.setText(user.getName());
        holder.numFollowing.setText(user.getFollowing());
        holder.numFollowers.setText(user.getFollowers());
        Picasso.with(context).load(user.getLink()).fit().centerCrop().into(holder.image);
    }


    @Override
    public int getItemCount() {
        return repositorioList.size();
    }
}
