package com.example.sunrinchungwon.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.Code;
import com.example.sunrinchungwon.items.seepost_item;

import java.util.ArrayList;


public class Seepost_commentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private ArrayList<seepost_item> items;
    private Intent intent;
    private String introduction, mainSubject,conclusion;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(viewType==Code.ViewType.AGREE_CONTENT){
            view=inflater.inflate(R.layout.seepost_positive,viewGroup,false);
            return new ViewHolder_agree(view);
        }
        else{
            view=inflater.inflate(R.layout.seepost_prosconitem,viewGroup,false);
            return new ViewHolder_proscon(view);
        }
    }
    public Seepost_commentAdapter(ArrayList<seepost_item> items, Activity activity){
        this.items=items;
        this.activity=activity;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof ViewHolder_agree){
            ((ViewHolder_agree)viewHolder).userId.setText(items.get(position).getUserId());
            ((ViewHolder_agree)viewHolder).date.setText(items.get(position).getDate());
        }
        else{
            ((ViewHolder_proscon)viewHolder).title.setText(items.get(position).getTitle());
            ((ViewHolder_proscon)viewHolder).content.setText(items.get(position).getContent().substring(0,9)+"....");
            Log.e("onVindViewHolder",items.get(position).getContent());
        }
    }
    public int getItemViewType(int position){
        return items.get(position).getViewType();
    }
    @Override
    public int getItemCount() { return items.size(); }

    public class ViewHolder_proscon extends RecyclerView.ViewHolder{
        TextView title,content;
        Button seemoreBtn, dialogBtn;
        ImageView random_image;
        public ViewHolder_proscon(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.seepost_proscon_title);
            content=itemView.findViewById(R.id.seepost_proscon_contents);
            seemoreBtn=itemView.findViewById(R.id.seepost_proscon_seemore);
            dialogBtn=itemView.findViewById(R.id.seepost_proscon_dialogue);
            random_image=itemView.findViewById(R.id.seepost_proscon_image);
            dialogBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "12341234", Toast.LENGTH_SHORT).show();
                }
            });
            seemoreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        items.set(pos,items.get(pos));
                        notifyItemChanged(pos);
                    }
                }
            });
        }
    }
    public class ViewHolder_agree extends RecyclerView.ViewHolder{
        TextView userId, date;
        public ViewHolder_agree(@NonNull View itemView) {
            super(itemView);
            userId=itemView.findViewById(R.id.seepost_positive_userId);
            date=itemView.findViewById(R.id.seepost_positive_date);
        }
    }
}
