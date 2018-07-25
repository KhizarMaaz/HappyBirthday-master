package com.example.sadaqatpanhwer.home.quotesActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.example.sadaqatpanhwer.home.R;

import java.util.ArrayList;
import java.util.List;

public class quotes extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SwipeDeck cardStack;
    private Context context = this;
    private SwipeDeckAdapter adapter;
    private ArrayList<String> testData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quotes);
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        //dragCheckbox = (CheckBox) findViewById(R.id.checkbox_drag);

        testData = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            testData.add(String.valueOf(i));
        }

        adapter = new SwipeDeckAdapter(testData, this);
        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long stableId) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + stableId);
            }

            @Override
            public void cardSwipedRight(long stableId) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + stableId);

            }

            @Override
            public boolean isDragEnabled(long itemId) {
                return true;
            }
        });


        Button btn3 = (Button) findViewById(R.id.button_center);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                testData.add("a sample string.");
//                adapter.notifyDataSetChanged();
                cardStack.unSwipeCard();
            }
        });

    }

    public class SwipeDeckAdapter extends BaseAdapter {

        private List<String> data;
        private Context context;

        public SwipeDeckAdapter(List<String> data, Context context) {
            this.data = data;
            this.context = context;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = getLayoutInflater();
                // normally use a viewholder
                v = inflater.inflate(R.layout.test_card2, parent, false);
            }
            ((TextView) v.findViewById(R.id.txt)).setText("God blessed over me and he sent you down for me. I remember how my heart skipped its beats when i saw you first time. Now when you look at me it makes me want to be a perfect man i can be. Happy birthday dear!!");
            if(position==0){
                ((TextView) v.findViewById(R.id.txt)).setText("My soul mate, more than my friend, my partner i’m nothing without you. On the special occasion of your birthday i want to remind you all the reasons why i love you. Happy Birthday !");
            }
            if(position==1){
                ((TextView) v.findViewById(R.id.txt)).setText("I may not be there to give you what you want but i promise to be with you always with all my heart and love. Happy Birthday Honey!!");
            }
            if(position==2){
                ((TextView) v.findViewById(R.id.txt)).setText("I hope your birthday cake is as sweet as your smile. Happy Birthday dear..stay happy and healthy!!");
            }
            if(position==3){
                ((TextView) v.findViewById(R.id.txt)).setText("Hye jani so finally 19 ki hogie hmm , i hope tmy ab zara c akal ay meri akal sa pydal jan , Happy birthday!");
            }
            if(position==4){
                ((TextView) v.findViewById(R.id.txt)).setText("Tum chahy 19 ki ho jao ya phir 91 ki  humary bech jb b kuch hoga gusy ma many tumy yhi khna ha k 2 sal ki bachi ho kiya !");
            }
            if(position==5){
                ((TextView) v.findViewById(R.id.txt)).setText("Happy Birthday programmer ki jan , i love u soOooo much");
            }
            if(position==6){
                ((TextView) v.findViewById(R.id.txt)).setText("Smile may be starting of friendship, a touch may be a starting of love but a person like you can make life worth living.");
            }
            if(position==7){
                ((TextView) v.findViewById(R.id.txt)).setText("You look the best and very sweet with your cute smile. Today is your birthday smile the whole day to remain happy and to keep happy everybody. Happy Birthday baby!!");
            }
            if(position==8){
                ((TextView) v.findViewById(R.id.txt)).setText("Whenever i feel disappointed and depressed, a single thought of you make me all happy. Happy Birthday..may you live long dear!!");
            }
            if(position==9){
                ((TextView) v.findViewById(R.id.txt)).setText("We have been with each other for a long time and my love for you is growing day by day… i hope time will not matter in our love. Happy Birthday Dear!!");
            }
            if(position==10){
                ((TextView) v.findViewById(R.id.txt)).setText("Ok one last Happy walla Birthday meri jan");
            }




            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                    Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
                    /*Intent i = new Intent(v.getContext(), BlankActivity.class);
                    v.getContext().startActivity(i);*/
                }
            });
            return v;
        }
    }
}
