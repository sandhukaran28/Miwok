package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int background;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int color) {
        super(context,0,words);
        background=color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word word=getItem(position);
        TextView miwok=(TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwok.setText(word.getMiwokTranslation());
        TextView eng=(TextView)listItemView.findViewById(R.id.default_text_view);
        eng.setText(word.getDefaultTranslation());
        ImageView img=(ImageView) listItemView.findViewById(R.id.imageResource);
        if(word.hasImage()==false)
        {
           img.setVisibility(View.GONE);
        }
        else
        {
            img.setVisibility(View.VISIBLE);
            img.setImageResource(word.getImageResourceId());
        }
        View textContainer =listItemView.findViewById(R.id.container);
        int color= ContextCompat.getColor(getContext(),background);
        textContainer.setBackgroundColor(color);

        return  listItemView;
    }
}
