package com.stx.xhb.demo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.stx.xhb.takephoto.ChooseImageDialog;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        ChooseImageDialog chooseImageDialog = ChooseImageDialog.newInstance();
        chooseImageDialog.setOperator(new ChooseImageDialog.Operator() {
            @Override
            public void onGetImage(String imaePath) {
                Log.i("===>path",imaePath);
                ((ImageView) findViewById(R.id.iv)).setImageURI(Uri.fromFile(new File(imaePath)));
                Toast.makeText(MainActivity.this, imaePath, Toast.LENGTH_SHORT).show();
            }
        });
        chooseImageDialog.show(getSupportFragmentManager(), null);
    }
}
