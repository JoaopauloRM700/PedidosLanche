package br.edu.icomp.ufam.iartes.apppedidoslanche;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.edu.icomp.ufam.iartes.apppedidoslanche.Models.OrdersModel;

public class DBHelper extends SQLiteOpenHelper {

    final static  String DB_NAME = "mydatabase.db";
    final static int DB_VERSION = 1;



    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE pedidos" +
                "(      id integer primary key autoincrement" +
                "   ,   nome text" +
                "   ,   telefone text" +
                "   ,   preco   real" +
                "   ,   image   integer" +
                "   ,   descricao text" +
                "   ,   nomeLanche text)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists pedidos ");
        onCreate(db);
    }

    public boolean inserPedido( String name, String telefone, double preco, int image, String descricao, String nomeLanche, int qtd ){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", name);
        values.put("telefone", telefone);
        values.put("preco", preco);
        values.put("image", image);
        values.put("descricao", descricao);
        values.put("nameLanche", nomeLanche);
        values.put("qtd", qtd);
        long id = db.insert("pedidos", null, values);

        if(id <= 0){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<OrdersModel> getOrders() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id,nameLanche, image, preco  FROM pedidos", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setIdPedido(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setValueOrder(cursor.getFloat(3)+"");
            }
        }

        cursor.close();
        db.close();
        return orders;
    }
}
