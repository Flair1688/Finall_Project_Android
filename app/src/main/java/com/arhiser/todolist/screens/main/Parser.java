package com.arhiser.todolist.screens.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.arhiser.todolist.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser extends AppCompatActivity {
    TextView textView;
    ScrollView mScrollView;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parser);

        textView = findViewById(R.id.tex1);
        but = findViewById(R.id.but1);
        mScrollView = findViewById(R.id.SCROLLER_ID);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new textparse().execute();
            }
        });
    }
    public class textparse extends AsyncTask<Void, Void, Void> {
        String words;

        @Override
        protected Void doInBackground(Void...params) {
            try {
                Document doc = Jsoup.connect("https://www.fifa.com/tournaments/mens/worldcup/qatar2022/media-releases/fifa-world-cup-tm-trophy-tour-by-coca-cola-kicks-off-global-journey-in-dubai").get();
                words = doc.text();
            } catch(Exception e){e.printStackTrace();}
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText(words);
        }



        private void scrollToBottom()
        {
            mScrollView.post(new Runnable()
            {
                public void run()
                {
                    mScrollView.smoothScrollTo(0, textView.getBottom());
                }
            });
        }
    }

}