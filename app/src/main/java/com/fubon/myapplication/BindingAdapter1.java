package com.fubon.myapplication;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;


public class BindingAdapter1 {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext().getApplicationContext()).load(url)
                .into(view);
    }
}