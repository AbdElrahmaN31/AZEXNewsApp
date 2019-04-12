package com.example.myproject.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.Interface.APIInterface;
import com.example.myproject.Interface.RetrofitClass;
import com.example.myproject.List.NewAdapter;
import com.example.myproject.Models.Article;
import com.example.myproject.Models.NewsModel;
import com.example.myproject.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    View view;
    ProgressBar progressBar;
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(getContext()).inflate(R.layout.list, container, false);
        progressBar = view.findViewById(R.id.prograssbar);
        textView = view.findViewById(R.id.notenternet);

        final ListView listView = view.findViewById(R.id.item);

        APIInterface apiInterface = RetrofitClass.grtClint().create(APIInterface.class);

        Call<NewsModel> call = apiInterface.getscience();

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if (response.isSuccess()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                    final List<Article> articles = response.body().getArticles();
                    final NewAdapter adapter = new NewAdapter(getActivity(), articles);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Article gUrl = adapter.getItem(i);
                            if (gUrl.getUrl() != null) {
                                Uri newsUri = Uri.parse(gUrl.getUrl());
                                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                                // Send the intent to launch a new activity
                                startActivity(websiteIntent);
                            }
                            // Create a new intent to view the newsModel URI
                        }
                    });
                } else {
                    String message = response.message();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable throwable) {

                progressBar.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }

        });


        return view;
    }
}
