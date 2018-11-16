package com.example.a805_11.samplelistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;

    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInsBundleState) {
        super.onCreate(savedInsBundleState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("사나", "010-1000-1000", 22, R.drawable.img_sana));
        adapter.addItem(new SingerItem("지효", "010-2000-2000", 22, R.drawable.img_jihyo));
        adapter.addItem(new SingerItem("나연", "010-3000-3000", 22, R.drawable.img_nayeon));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImage(item.resId);

            return view;
        }
    }
}
