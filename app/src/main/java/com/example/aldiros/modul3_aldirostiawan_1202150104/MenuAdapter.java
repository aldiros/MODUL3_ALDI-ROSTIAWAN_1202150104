package com.example.aldiros.modul3_aldirostiawan_1202150104;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

/**
 * Created by aldiros on 25/02/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder>{

    private LayoutInflater mInflater;
    private List<Menu> menuList;
    CardView cv;

    public MenuAdapter(Context context, List<Menu> menuList) {
        mInflater = LayoutInflater.from(context);
        this.menuList = menuList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu m  = menuList.get(position);
        holder.info.setText(m.getDetails());
        holder.nama.setText(m.getNama());
        holder.layout.setBackgroundResource(m.getGambar());
    }



    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nama, info;
        ImageView gambar;
        ConstraintLayout layout;


        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.nama);
            info = (TextView) view.findViewById(R.id.info);
            layout = (ConstraintLayout) view.findViewById(R.id.layout_background);
            view.setOnClickListener(this);
        }



        // pada saat menu diklik
        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            Toast.makeText(view.getContext(), nama.getText(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), Details.class);
            int gambar = menuList.get(mPosition).getGambar();
            String komposisi = menuList.get(mPosition).getKomposisi();
            intent.putExtra("gambar", gambar);      // put extra ke intent berikutnya
            intent.putExtra("nama", nama.getText()); // put extra ke intent berikutnya
            intent.putExtra("details", info.getText()); // put extra ke intent berikutnya
            intent.putExtra("komposisi", komposisi); // put extra ke intent berikutnya
            view.getContext().startActivity(intent); //jalankan activity berikutnya
        }
    }
}
