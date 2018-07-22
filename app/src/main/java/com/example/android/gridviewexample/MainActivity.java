package com.example.android.gridviewexample;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView mygrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mygrid = (GridView) findViewById(R.id.gridview);
        mygrid.setAdapter(new MyAdapter(this));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}
class Imageandname {
    int imageid;
    String topicname;

    Imageandname(int imageid,String topicname)
    {
        this.imageid=imageid;
        this.topicname=topicname;
    }
}
class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Imageandname> list;

    MyAdapter(Context c) {
        context = c;
        list = new ArrayList<Imageandname>();
        Resources resources = context.getResources();
        String[] topicnames = resources.getStringArray(R.array.topicname);
        //for getting images
        int[] topicimages = {R.drawable.imagesbook, R.drawable.imagesaptitude, R.drawable.codingquestions, R.drawable.java, R.drawable.resumebuilding, R.drawable.hrround};
        for (int i = 0; i < 6; i++) {
            Imageandname tempImageandname = new Imageandname(topicimages[i], topicnames[i]);
            list.add(tempImageandname);

        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //we have to call image again and again so we have made a class ,for this we call this class only once
    class Viewholder {
        ImageView myimage;

        public Viewholder(View v) {
            myimage = v.findViewById(R.id.imageview);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Viewholder viewholder = null;
        //recycling part
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.singlerowlayout, parent, false);
            viewholder = new Viewholder(row);
            row.setTag(viewholder);
        }
        else
        {
            viewholder=(Viewholder)row.getTag();
        }
        Imageandname temp= list.get(position);
        viewholder.myimage.setImageResource(temp.imageid);
            return row;
        }
    }



