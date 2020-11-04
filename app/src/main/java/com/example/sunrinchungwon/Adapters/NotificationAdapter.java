//package com.example.sunrinchungwon.Adapters;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.sunrinchungwon.R;
//import com.example.sunrinchungwon.SeepostActivity;
//import com.example.sunrinchungwon.items.notification_item;
//import com.example.sunrinchungwon.items.recycler_item;
//
//import java.util.List;
//
//public class NotificationAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
//
//    private Activity activity;
//    private List<notification_item> notification_items;
//    private Intent intent;
//    private String introduction, mainSubject,conclusion;
//
//    public NotificationAdapter(Activity activity, List<notification_item> notification_item) {
//        this.activity = activity;
//        this.notification_items = notification_item;
//    }
//
//    @Override
//    public int getItemCount() {
//        return notification_items.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        TextView title;
//        TextView date;
//        ImageButton imageButton;
//
//        public ViewHolder(final View itemView) {
//            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.notification_title);
//            date = (TextView) itemView.findViewById(R.id.notification_date);
//            imageButton = itemView.findViewById(R.id.notification_button);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(activity, "click " +
//                            notification_item.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
//                    intent=new Intent(activity, SeepostActivity.class);
//                    intent.putExtra("title",title.getText().toString());
//                    intent.putExtra("date",date.getText().toString());
//                    intent.putExtra("isResponed",isResponed.getText().toString());
//                    intent.putExtra("introduction",introduction);
//                    intent.putExtra("mainSubject",mainSubject);
//                    intent.putExtra("conclusion",conclusion);
//                    activity.startActivity(intent);
//                }
//            });
//
////            itemView.setOnLongClickListener(new View.OnLongClickListener() {
////                @Override
////                public boolean onLongClick(View view) {
////                    Toast.makeText(activity, "remove " +
////                            recycler_item.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
////                    removeItemView(getAdapterPosition());
////                    return false;
////                }
////            });
//        }
//    }
//
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    // 재활용 되는 View가 호출, Adapter가 해당 position에 해당하는 데이터를 결합
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        recycler_item data = recycler_item.get(position);
//
//        // 데이터 결합
//        holder.title.setText(data.getTitle());
//        holder.date.setText(data.getDate());
//        holder.isResponed.setText(data.getIsResponed());
//        introduction=data.getIntroduction();
//        mainSubject=data.getMainSubject();
//        conclusion=data.getConclusion();
//    }
//}