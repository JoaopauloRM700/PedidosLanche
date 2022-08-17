package br.edu.icomp.ufam.iartes.apppedidoslanche.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import br.edu.icomp.ufam.iartes.apppedidoslanche.DetailActivity;
import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.MainModel;
import br.edu.icomp.ufam.iartes.apppedidoslanche.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList<MainModel> list ;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainordering, parent , false );
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, int position) {

        final MainModel model = list.get(position);
        holder.imageLanche.setImageResource(model.getImage());
        holder.mainName.setText(model.getNome());
        holder.preco.setText(model.getPreco());
        holder.descricao.setText(model.getDescricao());

        holder.itemView.setOnClickListener((view) -> {

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("image", model.getImage());
            intent.putExtra("preco", model.getPreco());
            intent.putExtra("descricao", model.getDescricao());
            intent.putExtra("name", model.getNome());
            intent.putExtra("type", 2);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView imageLanche;
        TextView mainName, preco, descricao;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            imageLanche = itemView.findViewById(R.id.imageLanche);
            mainName = itemView.findViewById(R.id.name);
            preco = itemView.findViewById(R.id.preco);
            descricao = itemView.findViewById(R.id.descricao);

        }
    }
}
