package com.swarawan.warehouse.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.warehouse.R;
import com.swarawan.warehouse.model.Goods;
import com.swarawan.warehouse.widget.NonScrollableLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 5/15/17.
 */

public class MainActivity extends AppCompatActivity {

    List<Goods> goods = new ArrayList<>();
    GoodsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_main);

        init();
        findViewById(R.id.button_save).setOnClickListener(onSaveClicked);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void init() {
        adapter = new GoodsAdapter(this, goods);

        ((RecyclerView) findViewById(R.id.recyclerview)).setLayoutManager(new NonScrollableLinearLayoutManager(this));
        ((RecyclerView) findViewById(R.id.recyclerview)).setHasFixedSize(true);
        ((RecyclerView) findViewById(R.id.recyclerview)).setAdapter(adapter);
    }

    private View.OnClickListener onSaveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            save();
        }
    };

    private boolean validateForm() {
        return !(((EditText) findViewById(R.id.input_name)).getText().toString().equals("")
                && ((EditText) findViewById(R.id.input_total)).getText().toString().equals("")
                && ((EditText) findViewById(R.id.input_supplier)).getText().toString().equals("")
                && ((EditText) findViewById(R.id.input_date)).getText().toString().equals(""));
    }

    private void save() {
        if (!validateForm()) {
            Toast.makeText(this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        String name = ((EditText) findViewById(R.id.input_name)).getText().toString();
        String total = ((EditText) findViewById(R.id.input_total)).getText().toString();
        String supplier = ((EditText) findViewById(R.id.input_supplier)).getText().toString();
        String date = ((EditText) findViewById(R.id.input_date)).getText().toString();

        goods.add(new Goods(name, total, supplier, date));
        adapter.notifyDataSetChanged();

        refreshForm();
    }

    private void refreshForm() {
        ((EditText) findViewById(R.id.input_name)).setText("");
        ((EditText) findViewById(R.id.input_total)).setText("");
        ((EditText) findViewById(R.id.input_supplier)).setText("");
        ((EditText) findViewById(R.id.input_date)).setText("");
    }
}
