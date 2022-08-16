package br.edu.icomp.ufam.iartes.apppedidoslanche;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.MainModel;
import br.edu.icomp.ufam.iartes.apppedidoslanche.Views.MainView;
import br.edu.icomp.ufam.iartes.apppedidoslanche.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.xsalada,"X-Salada","7,00", "O hambúrguer desse x-salada é feito com patinho, ovo, salsinha, cebola e pão picado. O preparo é feito na frigideira e deve-se acrescentar o queijo quando a carne já estiver dourada. Para a salada, você vai usar tomate e alface. É uma opção bem prática e apetitosa!"));
        list.add(new MainModel(R.drawable.xcaboquinho,"X-Caboquinho","15,00", "O x-caboquinho é um sanduíche típico da culinária do Amazonas. Consiste em um pão francês recheado com lascas de tucumã, banana pacovã madura frita, queijo coalho e manteiga."));
        list.add(new MainModel(R.drawable.xtudo,"X-Tudo","20,00", "Hambúrguer, bacon, calabresa, salsicha, ovo, queijo, alface, tomate, maionese e ketchup. * Acréscimo opcionais nos lanches*. - Bacon."));
        list.add(new MainModel(R.drawable.pizzacalabresa,"Pizza Calabresa G","30,00", " É especialmente preparada com recheio generoso de linguiça calabresa de primeira qualidade, queijo muçarela e orégano. A linguiça calabresa agrega um sabor único e levemente picante à pizza. "));
        list.add(new MainModel(R.drawable.xsalada,"X-Salada","7,00", "O hambúrguer desse x-salada é feito com patinho, ovo, salsinha, cebola e pão picado. O preparo é feito na frigideira e deve-se acrescentar o queijo quando a carne já estiver dourada. Para a salada, você vai usar tomate e alface. É uma opção bem prática e apetitosa!"));
        list.add(new MainModel(R.drawable.xcaboquinho,"X-Caboquinho","15,00", "O x-caboquinho é um sanduíche típico da culinária do Amazonas. Consiste em um pão francês recheado com lascas de tucumã, banana pacovã madura frita, queijo coalho e manteiga."));
        list.add(new MainModel(R.drawable.xtudo,"X-Tudo","20,00", "Hambúrguer, bacon, calabresa, salsicha, ovo, queijo, alface, tomate, maionese e ketchup. * Acréscimo opcionais nos lanches*. - Bacon."));
        list.add(new MainModel(R.drawable.pizzacalabresa,"Pizza Calabresa G","30,00", " É especialmente preparada com recheio generoso de linguiça calabresa de primeira qualidade, queijo muçarela e orégano. A linguiça calabresa agrega um sabor único e levemente picante à pizza. "));


        MainView model = new MainView(list, this);
        binding.ricyclerview.setAdapter(model);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ricyclerview.setLayoutManager(layoutManager);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}