 package br.edu.icomp.ufam.iartes.apppedidoslanche;

import androidx.appcompat.app.AppCompatActivity;

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

        final int image = getIntent().getIntExtra("image",0);
        final double preco = Double.parseDouble(getIntent().getStringExtra("preco"));
        final String name = getIntent().getStringExtra("name");
        final String descricao = getIntent().getStringExtra("descricao");


        binding.detailImage.setImageResource(image);
        binding.precoDetail.setText(String.format("%d",preco));
        binding.nameBox.setText(name);
        binding.detailDescription.setText(descricao);

        DBHelper helper = new DBHelper(this);

        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted = helper.inserPedido(
                            binding.nameBox.getText().toString()
                        ,   binding.phoneBox.getText().toString()
                        ,   preco
                        ,   image
                        ,   name
                        ,   descricao
                        ,   Integer.parseInt(binding.qtd.getText().toString())

                );

                if(isInserted)
                    Toast.makeText(DetailActivity.this, "Data Success. ", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}