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
            txt.setText("Sun g0s d0wn or hum tm hn yaha sth sth fir flys gagmagy tim tim ya gagnu kr data r0rhsn sham .ho jadu jb mery sang tm hoty close ur eyes pas ayn hum itnyl Tari bahao ma such hn. Rahna sang or dkho mil kr sapna mari bhaho ma such h hn.");
        }
        if(getArguments().getInt("position")==1){
            txt.setText("I do not love you except because I love you; \n" +
                    "I go from loving to not loving you,\n" +
                    "From waiting to not waiting for you\n" +
                    "My heart moves from cold to fire.");
        }
        if(getArguments().getInt("position")==2){
            txt.setText("I love you only because it's you the one I love; \n" +
                    "I hate you deeply, and hating you\n" +
                    "Bend to you, and the measure of my changing love for you\n" +
                    "Is that I do not see you but love you blindly.");
        }
        if(getArguments().getInt("position")==3){
            txt.setText("in this part of the story I am the one who\n" +
                    "Dies, the only one, and I will die of love because I love you,\n" +
                    "Because I love you, Love, in fire and blood. ");
        }
        if(getArguments().getInt("position")==4){
            txt.setText("Tumhain Barish Pasand Hai Muje Barish Main Tum\n" +
                    "\n" +
                    "Tumhain Hansna Pasand Hai Muje Hanste Hoye Tum\n" +
                    "\n" +
                    "Tumhain Bolna Pasand Hai Muje Bolte Hoye Tum\n" +
                    "\n" +
                    "Tumhain Sab Kuch Pasand Hai Aur Muje Bas Tum");
        }
        if(getArguments().getInt("position")==5){
            txt.setText("ek chehra hai jo āñkhoñ meñ basā rahtā hai \n" +
                    "\n" +
                    "ik tasavvur hai jo tanhā nahīñ hone detā " +
                    "\n ik raat vo gayā thā jahāñ baat rok ke \n" +
                    "\n" +
                    "ab tak rukā huā huuñ vahīñ raat rok ke ");
        }
        if(getArguments().getInt("position")==6){
            txt.setText("You had me at \"Hello World!\".\n" +
                    "You're my missing semicolon.\n" +
                    "Are you a static method? Cuz I'd like to call you sometime without turning you into an object.\n" +
                    "Are you multi-threaded? Because you've caused a race condition in my heart.\n" +
                    "I'm gonna pass my function and iterate all over you until you return the result.\n" +
                    "My love for you is a const, never changing. It's also global, no bound.");
        }
        if(getArguments().getInt("position")==7){
            txt.setText("a");
        }
        if(getArguments().getInt("position")==8){
            txt.setText("b");
        }
        if(getArguments().getInt("position")==9){
            txt.setText("a");
        }
        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
