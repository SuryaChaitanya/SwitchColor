package chaitanya.switchcolor;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    int counter;
    public static final int DEFAULT = 0;
    TextView textView;
    Button button;
    String etString;
    RelativeLayout bgc;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public int count() {
        counter++;
        return counter;
    }

    public void color(int i) {
        if (i % 6 == 0) bgc.setBackgroundColor(Color.RED);
        else if (i % 6 == 1) bgc.setBackgroundColor(Color.DKGRAY);
        else if (i % 6 == 2) bgc.setBackgroundColor(Color.BLUE);
        else if (i % 6 == 3) bgc.setBackgroundColor(Color.YELLOW);
        else if (i % 6 == 4) bgc.setBackgroundColor(Color.GREEN);
        else if (i % 6 == 5) bgc.setBackgroundColor(Color.MAGENTA);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("Mycount", Context.MODE_PRIVATE);
        int j;
        j = sp.getInt("counter", DEFAULT);
        counter = j;
        counter--;
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("" + count());



        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        bgc = (RelativeLayout) findViewById(R.id.layout);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        etString = textView.getText().toString();
        outState.putString("textView", etString);
        outState.putInt("i", counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("textView"));
        counter = savedInstanceState.getInt("i");
        color(counter);
    }

    @Override
    public void onClick(View v) {

        textView.setText("" + count());
        color(counter);
    }


    public void functionReset(View v) {
        counter = 0;
        counter--;
        textView.setText("" + count());

    }

    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://chaitanya.switchcolor/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        SharedPreferences sp = getSharedPreferences("Mycount", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("counter", counter);
        editor.commit();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://chaitanya.switchcolor/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }
}
