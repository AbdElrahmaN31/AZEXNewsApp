package com.example.myproject.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myproject.Models.Article;
import com.example.myproject.R;

import java.util.List;


public class NewAdapter extends ArrayAdapter<Article> {

    TextView title, author, date, des;
    ImageView img;

    public NewAdapter(Context context, List<Article> articles) {
        super(context, R.layout.list_item, articles);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Article articlesModel = getItem(position);

        title = (TextView) view.findViewById(R.id.title_id);

        des = (TextView) view.findViewById(R.id.des_id);

        author = (TextView) view.findViewById(R.id.author_id);

        date = (TextView) view.findViewById(R.id.date_id);

        img = (ImageView) view.findViewById(R.id.image_id);
        if (articlesModel.getTitle() == null) {
            title.setVisibility(View.GONE);
        } else {
            title.setVisibility(View.VISIBLE);
            title.setText(articlesModel.getTitle());
        }


        if (articlesModel.getDescription() == null) {
            des.setVisibility(View.GONE);
        } else {
            des.setVisibility(View.VISIBLE);
            des.setText(articlesModel.getDescription());
        }
        if (articlesModel.getAuthor() == null) {
            author.setVisibility(View.GONE);
        } else {
            author.setVisibility(View.VISIBLE);
            author.setText(articlesModel.getAuthor());
        }
        if (articlesModel.getPublishedAt() == null) {
            date.setVisibility(View.GONE);
        } else {
            date.setVisibility(View.VISIBLE);
            date.setText(articlesModel.getPublishedAt());
        }


        if (articlesModel.getUrlToImage() == null) {
            img.setVisibility(View.GONE);
        } else {
            img.setVisibility(View.VISIBLE);
            Glide.with(getContext())
                    .load(articlesModel.getUrlToImage())
                    .centerCrop()
                    .placeholder(R.drawable.header)
                    .into(img);
        }


        return view;

    }
}
