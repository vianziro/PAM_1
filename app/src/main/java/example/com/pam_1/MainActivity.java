package example.com.pam_1;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*
* MATERI ACTIVITY PAM 1
* */
public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private Dialog dialog;

    /*
    * MATERI ACTIVITY LIFECYCLE
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        /*
        * SIMPLE EXAMPLE INTENT
        * */
        imgView = (ImageView) findViewById(R.id.imageView);
        imgView.setImageResource(R.drawable.coba_aja);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
            }
        });
        /*
        * SIMPLE EXAMPLE INTENT
        * */

        /*
        * SIMPLE EXAMPLE CUSTOM DIALOG AND TOAST
        * */
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.layout_dialog);

                TextView text = (TextView) dialog.findViewById(R.id.nama);
                text.setText("672011xxx");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageDrawable(imgView.getDrawable());

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "BUTTON DIALOG PRESSED", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        /*
        * SIMPLE EXAMPLE CUSTOM DIALOG AND TOAST
        * */
        Log.d("PAM-1", "onCreate() execute");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("PAM-1", "onStart() execute");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PAM-1", "onPause() execute");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("PAM-1", "onResume() execute");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("PAM-1", "onRestart() execute");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("PAM-1", "onStop() execute");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("PAM-1", "onDestroy() execute");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Menu Setting", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            imgView.setImageURI(imageUri);
        }
    }
    /*
    * MATERI ACTIVITY LIFECYCLE
    * */
}
/*
* MATERI ACTIVITY PAM 1
* */
