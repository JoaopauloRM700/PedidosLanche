package br.edu.icomp.ufam.iartes.apppedidoslanche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.OrdersModel;
import br.edu.icomp.ufam.iartes.apppedidoslanche.Adapters.OrdersAdapter;
import br.edu.icomp.ufam.iartes.apppedidoslanche.databinding.ActivityOrderBinding;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);



    }
}