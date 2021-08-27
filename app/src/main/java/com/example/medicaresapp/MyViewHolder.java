package com.example.medicaresapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
     TextView text_view1,text_view2,text_view3,text_view4,text_view5,text_view6,text_view7,text_view8,text_view10,text_view11;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        text_view1=itemView.findViewById(R.id.textView2);
        text_view2=itemView.findViewById(R.id.textView3);
        text_view3=itemView.findViewById(R.id.textView4);
        text_view4=itemView.findViewById(R.id.textView5);
        text_view5=itemView.findViewById(R.id.textView6);
        text_view6=itemView.findViewById(R.id.textView7);
        text_view10=itemView.findViewById(R.id.textView10);
        text_view11=itemView.findViewById(R.id.textView11);
        text_view7=itemView.findViewById(R.id.textView8);
        text_view8=itemView.findViewById(R.id.textView9);

    }
}
