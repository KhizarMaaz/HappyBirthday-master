package com.example.sadaqatpanhwer.home.wishCard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sadaqatpanhwer.home.R;


public class CardFragment extends Fragment {

    private CardView cardView;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);


        TextView txt = (TextView) view.findViewById(R.id.quote);



       // title.setText(String.format("Card %d", getArguments().getInt("position")));
        if(getArguments().getInt("position")==0){
            txt.setText("a");
        }
        if(getArguments().getInt("position")==1){
            txt.setText("b");
        }
        if(getArguments().getInt("position")==2){
            txt.setText("c");
        }
        if(getArguments().getInt("position")==3){
            txt.setText("d");
        }
        if(getArguments().getInt("position")==4){
            txt.setText("e");
        }
        if(getArguments().getInt("position")==5){
            txt.setText("f");
        }
        if(getArguments().getInt("position")==6){
            txt.setText("g");
        }
        if(getArguments().getInt("position")==7){
            txt.setText("h");
        }
        if(getArguments().getInt("position")==8){
            txt.setText("i");
        }
        if(getArguments().getInt("position")==9){
            txt.setText("j");
        }
        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
