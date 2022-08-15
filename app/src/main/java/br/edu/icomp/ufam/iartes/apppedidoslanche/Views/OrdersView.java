package br.edu.icomp.ufam.iartes.apppedidoslanche.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.OrdersModel;
import br.edu.icomp.ufam.iartes.apppedidoslanche.R;

public class OrdersView extends RecyclerView.Adapter<OrdersView.viewHolder> {

    ArrayList<OrdersModel> list;
    Context context;

    public OrdersView(ArrayList<OrdersModel> list, Context context) {
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
        holder.orderItemName.setText(model.getSoldItemName());
        holder.valueOrder.setText(model.getValueOrder());
        holder.idPedido.setText(model.getIdPedido());



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
