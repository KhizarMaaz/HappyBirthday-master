package com.example.sadaqatpanhwer.home.quotesActivities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.example.sadaqatpanhwer.home.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.util.ArrayList;
import java.util.List;

public class quotes extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SwipeDeck cardStack;
    private Context context = this;
    private SwipeDeckAdapter adapter;
    private ArrayList<String> testData;
    private ImageButton whatsappButton;
    private ImageButton messenger;
    private ImageButton facebook;
    private Intent whatsappIntent;
    private Intent messngrIntent;
    private Intent facebookIntent;
    private ShareDialog shareDialog;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quotes);

        callbackManager = new CallbackManager.Factory().create();
        shareDialog = new ShareDialog(this);

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
                //initlzing whatsapp button
                whatsappButton = v.findViewById(R.id.whatsapp);
                //init messngr
                messenger = v.findViewById(R.id.messenger);
                //init fb
                facebook = v.findViewById(R.id.facebook);
            }//end of if

            ((TextView) v.findViewById(R.id.txt)).setText("hello there");
            if(position==0){
                final String text = "Hello world " +
                        "testing whatsapp sharing " +
                        "using whatsapp intent";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                        }
                });//end of click
                //messenger code

                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                    });//end of click
                //facebook
                facebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                            @Override
                            public void onSuccess(Sharer.Result result) {

                            }

                            @Override
                            public void onCancel() {

                            }

                            @Override
                            public void onError(FacebookException error) {

                            }
                        });
                        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                .setQuote(""+text)
                                .build();
                        if (ShareDialog.canShow(ShareLinkContent.class)) {
                            shareDialog.show(linkContent);
                        }
                    }
                });//end of click
            }//end of position
            if(position==1){
                final String text = "whats going on";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==2){
                final String text = "hello";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==3){
                final String text = "hi how are you";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==4){
                final String text = "hi how are you";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==5){
                final String text = "smaple";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==6){
                final String text = "smaple";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==7){
                final String text = "smaple";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==8){
                final String text = "smaple";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==9){
                final String text = "smaple";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
            }
            if(position==10){
                final String text = "smaple";
                ((TextView) v.findViewById(R.id.txt)).setText(text);
                whatsappButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        whatsappIntent = new Intent(Intent.ACTION_SEND);
                        whatsappIntent.setType("text/plain");
                        whatsappIntent.setPackage("com.whatsapp");
                        whatsappIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(whatsappIntent);
                    }
                });//end of click
                messenger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        messngrIntent = new Intent(Intent.ACTION_SEND);
                        messngrIntent.setType("text/plain");
                        messngrIntent.setPackage("com.facebook.orca");
                        messngrIntent.putExtra(Intent.EXTRA_TEXT,""+text);
                        context.startActivity(messngrIntent);

                    }
                });//end of click
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
