package com.mediav.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.mediav.ads.sdk.adcore.Mvad;
import com.nostra13.universalimageloader.core.ImageLoader;


public class BannerActivity extends Activity {

    private MyClass myClass;
    private View btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner_layout);
        myClass=new MyClass();
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setListViewContent();
        ViewGroup bannerContainer = (ViewGroup) findViewById(R.id.bannerContainer);
        Mvad.showBanner(bannerContainer, this, "5uavuInDAl", false);
    }

    private void setListViewContent() {
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.list_header_layout, null));
        ImageListAdapter adapter = new ImageListAdapter(this);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewGroup viewGroup= (ViewGroup) btn.getParent();
        viewGroup.removeView(btn);
        btn=null;
        myClass=null;
        Mvad.activityDestroy(this);
    }
}

class ImageListAdapter extends BaseAdapter {


    private final Context context;

    public ImageListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    private String getImageUri(int position) {
        return String.format("assets://%s.jpg", position + 1);
    }

    @Override
    public Object getItem(int position) {
        return getImageUri(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null)
            return convertView;
        ImageView imageView = new ImageView(context);
        ImageLoader.getInstance().displayImage(getImageUri(position), imageView);
        return imageView;
    }
}

class MyClass{
    private byte[] bytes;

    MyClass() {
        this.bytes = new byte[1024*100];
    }
}