 package br.edu.icomp.ufam.iartes.apppedidoslanche;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.edu.icomp.ufam.iartes.apppedidoslanche.databinding.ActivityDetailBinding;

 public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final DBHelper helper = new DBHelper(this);
        if (getIntent().getIntExtra("type", 0) == 1) {


            final int image = getIntent().getIntExtra("image", 0);
            final double preco = Double.parseDouble(getIntent().getStringExtra("preco"));
            final String name = getIntent().getStringExtra("name");
            final String descricao = getIntent().getStringExtra("descricao");


            binding.detailImage.setImageResource(image);
            binding.precoDetail.setText(String.format("%.2f", preco));
            binding.nameLanche.setText(name);
            binding.detailDescription.setText(descricao);


            binding.insertBtn.setOnClickListener((view) -> {

                boolean isInserted = helper.insertPedido(
                          binding.nameBox.getText().toString()
                        , binding.phoneBox.getText().toString()
                        , preco
                        , image
                        , descricao
                        , name
                        , Integer.parseInt(binding.qtd.getText().toString())

                );

                if (isInserted)
                    Toast.makeText(DetailActivity.this, "Data Success. ", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();

            });
        }

        else{
            final int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.precoDetail.setText(String.format("%.2f", cursor.getDouble(3)));
            binding.nameLanche.setText(cursor.getString(7));
            binding.detailDescription.setText(cursor.getString(6));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.qtd.setText(String.format("%d", cursor.getInt(5)));
            binding.insertBtn.setText("Atualizar");
            binding.insertBtn.setOnClickListener(view -> {

                boolean isUpdated = helper.updatePedido(
                                        binding.nameBox.getText().toString()
                                    ,   binding.phoneBox.getText().toString()
                                    ,   Double.parseDouble(binding.precoDetail.getText().toString())
                                    ,   image
                                    ,   binding.detailDescription.getText().toString()
                                    ,   binding.nameLanche.getText().toString()
                                    ,   Integer.parseInt(binding.qtd.getText().toString())
                                    ,   id

                );

                if(isUpdated){
                    Toast.makeText(DetailActivity.this,"Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(DetailActivity.this,"Failed.", Toast.LENGTH_SHORT).show();
                }

            });


        }

    }
}