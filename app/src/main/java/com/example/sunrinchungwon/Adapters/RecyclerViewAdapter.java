package com.example.sunrinchungwon.Adapters;

import android.app.Activity;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.Activities.SeepostActivity;
import com.example.sunrinchungwon.items.recycler_item;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<recycler_item> recycler_item;
    private Intent intent;
    private String introduction, mainSubject,conclusion,tag;

    public RecyclerViewAdapter(Activity activity, ArrayList<recycler_item> recycler_item){
            //, Query query,OnPostSelectedListener listener) {
        //super(query);
        this.activity = activity;
        this.recycler_item = recycler_item;
        //this.mListener=listener;
    }

    @Override
    public int getItemCount() {
        return recycler_item.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        TextView isResponed;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            date = (TextView) itemView.findViewById(R.id.item_date);
            isResponed = (TextView)itemView.findViewById(R.id.item_isResponed);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "click " +
                            recycler_item.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                    intent=new Intent(activity, SeepostActivity.class);
                    intent.putExtra("title",title.getText().toString());
                    intent.putExtra("date",date.getText().toString());
                    intent.putExtra("isResponed",isResponed.getText().toString());
                    intent.putExtra("introduction",introduction);
                    intent.putExtra("mainSubject",mainSubject);
                    intent.putExtra("conclusion",conclusion);
                    intent.putExtra("tag",tag);
                    activity.startActivity(intent);
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // 재활용 되는 View가 호출, Adapter가 해당 position에 해당하는 데이터를 결합
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        recycler_item data = recycler_item.get(position);

        // 데이터 결합
        holder.title.setText(data.getTitle());
        holder.date.setText(data.getDate());
        holder.isResponed.setText(data.getIsResponed());
        introduction=data.getIntroduction();
        mainSubject=data.getMainSubject();
        conclusion=data.getConclusion();
        tag=data.getTag();
    }

    private void removeItemView(int position) {
        recycler_item.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, recycler_item.size()); // 지워진 만큼 다시 채워넣기.
    }
}