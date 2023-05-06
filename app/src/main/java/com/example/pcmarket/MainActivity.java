package com.example.pcmarket;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showProducts();
    }

    private void showProducts() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
        Connect connect = new Connect();

        String query = "SELECT * FROM psm_computer_store.produkty";
        ResultSet result = connect.select(query, connect.getConnection());

        List<Item> items = new ArrayList<>();

        try {
            while (result.next()) {
                items.add(new Item(result.getString(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5), result.getString(6), result.getString(7)
                        , result.getString(8), result.getString(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        connect.close();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, new RecyclerViewInterface() {
            @Override
            public void onItemClick(Item details) {
                Intent intent = new Intent(MainActivity.this, ProductDetails.class);
                intent.putExtra("productID", details.getId_produktu());
                startActivity(intent);
            }
        }));
    }
}