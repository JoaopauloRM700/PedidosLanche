package br.edu.icomp.ufam.iartes.apppedidoslanche.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.icomp.ufam.iartes.apppedidoslanche.DBHelper;
import br.edu.icomp.ufam.iartes.apppedidoslanche.DetailActivity;
import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.OrdersModel;
import br.edu.icomp.ufam.iartes.apppedidoslanche.R;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {

    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.orderItemName.setText(model.getOrderItemName());
        holder.idPedido.setText(model.getIdPedido());
        holder.valueOrder.setText(model.getValueOrder());

        holder.itemView.setOnClickListener((view) -> {

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id", Integer.parseInt(model.getIdPedido()));
            intent.putExtra("type", 2);
            context.startActivity(intent);

        });

        holder.itemView.setOnLongClickListener((view) -> {
            new AlertDialog.Builder(context)
                    .setTitle("Deletar Item")
                    .setMessage("Deseja realmente deletar este item?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            DBHelper helper = new DBHelper(context);
                            if(helper.deletedPedido(model.getIdPedido()) >0){

                                Toast.makeText(context,"Deleted", Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(context,"Error.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                        }
                    }).show();
            return false;
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderImage;
        TextView orderItemName, idPedido, valueOrder;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage = itemView.findViewById(R.id.orderImage);
            orderItemName = itemView.findViewById(R.id.orderItemName);
            idPedido = itemView.findViewById(R.id.idPedido);
            valueOrder = itemView.findViewById(R.id.valueOrder);

        }
    }
}
