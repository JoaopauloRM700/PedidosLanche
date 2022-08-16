package br.edu.icomp.ufam.iartes.apppedidoslanche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.OrdersModel;
import br.edu.icomp.ufam.iartes.apppedidoslanche.Views.OrdersView;
import br.edu.icomp.ufam.iartes.apppedidoslanche.databinding.ActivityOrderBinding;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.xsalada,"X-salada", "7,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizza,"Pizza de Mussarela G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.xcaboquinho,"X-caboquinho", "15,00","2712"));
        list.add(new OrdersModel(R.drawable.xtudo,"X-Tudo", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));
        list.add(new OrdersModel(R.drawable.pizzacalabresa,"Pizza de calabresa G", "30,00","2712"));

        OrdersView view = new OrdersView(list,this);
        binding.ordersRecyclerView.setAdapter(view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);



    }
}