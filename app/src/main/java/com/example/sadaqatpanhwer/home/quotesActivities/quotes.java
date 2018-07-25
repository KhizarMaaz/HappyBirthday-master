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
            ((TextView) v.findViewById(R.id.txt)).setText("a");
            if(position==0){
                ((TextView) v.findViewById(R.id.txt)).setText("b");
            }
            if(position==1){
                ((TextView) v.findViewById(R.id.txt)).setText("c");
            }
            if(position==2){
                ((TextView) v.findViewById(R.id.txt)).setText("d");
            }
            if(position==3){
                ((TextView) v.findViewById(R.id.txt)).setText("e");
            }
            if(position==4){
                ((TextView) v.findViewById(R.id.txt)).setText("f");
            }
            if(position==5){
                ((TextView) v.findViewById(R.id.txt)).setText("g");
            }
            if(position==6){
                ((TextView) v.findViewById(R.id.txt)).setText("h");
            }
            if(position==7){
                ((TextView) v.findViewById(R.id.txt)).setText("i");
            }
            if(position==8){
                ((TextView) v.findViewById(R.id.txt)).setText("j");
            }
            if(position==9){
                ((TextView) v.findViewById(R.id.txt)).setText("k");
            }
            if(position==10){
                ((TextView) v.findViewById(R.id.txt)).setText("l");
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
