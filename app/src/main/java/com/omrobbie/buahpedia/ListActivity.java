package com.omrobbie.buahpedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        ListView lvList = (ListView) findViewById(R.id.lvList);

        // masukkan item ke dalam data
        final ArrayList<ListData> data = new ArrayList<>();
        data.add(new ListData(R.drawable.buah_anggur, "Anggur", "Keterangan tentang buah anggur."));
        data.add(new ListData(R.drawable.buah_apel, "Apel", "Keterangan tentang buah apel."));
        data.add(new ListData(R.drawable.buah_jeruk, "Jeruk", "Keterangan tentang buah jeruk."));
        data.add(new ListData(R.drawable.buah_kiwi, "Kiwi", "Keterangan tentang buah kiwi."));
        data.add(new ListData(R.drawable.buah_mangga, "Mangga", "Keterangan tentang buah mangga."));
        data.add(new ListData(R.drawable.buah_manggis, "Manggis", "Keterangan tentang buah manggis."));
        data.add(new ListData(R.drawable.buah_nanas, "Nanas", "Keterangan tentang buah nanas."));
        data.add(new ListData(R.drawable.buah_pepaya, "Pepaya", "Keterangan tentang buah pepaya."));
        data.add(new ListData(R.drawable.buah_semangka, "Semangka", "Keterangan tentang buah semangka."));

        // set adapter
        ListAdapter adapter = new ListAdapter(this, R.layout.listitem, data);
        lvList.setAdapter(adapter);

        // bikin action saat data item di list di klik
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent listDetail = new Intent(getApplicationContext(), ListDetail.class);
                listDetail.putExtra("image", data.get(position).image);
                listDetail.putExtra("title", data.get(position).title);
                listDetail.putExtra("description", data.get(position).description);
                startActivity(listDetail);
            }
        });
    }
}