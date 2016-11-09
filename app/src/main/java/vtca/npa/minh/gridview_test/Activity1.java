package vtca.npa.minh.gridview_test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {

    public static final int REQUEST_VIEW = 9001;
    GridView gridView;
    CellAdapter cellAdapter;
    ArrayList<Cell> cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        gridView = (GridView) findViewById(R.id.gridView);
        cells = Test.getTestCell();
        cellAdapter = new CellAdapter(this, R.layout.grid_cell, cells);
        gridView.setAdapter(cellAdapter);
        onClickGridViewListener();
    }

    public void onClickGridViewListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cell c = cells.get(position);
                Intent intent = new Intent(Activity1.this, Activity2.class);
                intent.putExtra("image", c.getPhotoUrl());
                startActivityForResult(intent, REQUEST_VIEW);
            }
        });
    }

    class CellAdapter extends ArrayAdapter<Cell> {
        private Context context;
        private ArrayList<Cell> cells;
        private int resource;

        public CellAdapter(Context context, int resource, ArrayList<Cell> cells) {
            super(context, resource, cells);
            this.context = context;
            this.cells = cells;
            this.resource = resource;
        }

        @Override
        public int getCount() {
            return cells.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            View v = inflater.inflate(resource, null);

            ImageView imgView = (ImageView) v.findViewById(R.id.imgView);

            Cell c = cells.get(position);
            Picasso.with(context).load(c.getPhotoUrl()).into(imgView);

            return v;
        }
    }
}
