package com.example.projetofinal;

import android.app.Activity;
import android.os.Bundle;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.projetofinal.R;

import com.google.zxing.*;

public class QrCodeActivity extends Activity implements OnClickListener {
    @Override
    public static String SCAN = "com.google.zxing.client.android.SCAN";
    private Button scan;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        scan = (Button)findViewById(R.id.scan_button);
        scan.setOnClickListener(this);
    }
    public void onClick(View v) {

        IntentIntegrator scanIntegrator = new IntentIntegrator(QrCodeActivity.this);
        scanIntegrator.initiateScan();

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            String conteudoQRCode = scanningResult.getContents();

            intent = new Intent(this, ConteudoQRCode.class);
            intent.putExtra("conteudoQRCode", conteudoQRCode);
            this.startActivity(intent);
            this.finish();

        }else{

            Log.i("ZxingApp", "onActivityResultErro");
        }
}