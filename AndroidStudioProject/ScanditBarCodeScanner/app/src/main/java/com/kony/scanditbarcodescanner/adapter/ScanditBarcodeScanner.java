package com.kony.scanditbarcodescanner.adapter;

import android.content.Intent;

import com.kony.scanditbarcodescanner.MainActivity;
import com.konylabs.android.KonyMain;
import com.konylabs.vm.Function;

/**
 * Created by KH2195 on 12/28/2016.
 */

public class ScanditBarcodeScanner {
    static Intent intent;
    public static void startBarCodeScanning(String pScanditSdkAppKey, Function pCallbackFunction) {

        MainActivity.scanditSdkAppKey = pScanditSdkAppKey;
        MainActivity.callbackFunction = pCallbackFunction;
        if (intent == null)
        {
            intent = new Intent(KonyMain.getActContext(), MainActivity.class);
        }
        KonyMain.getActContext().startActivity(intent);

    }
}
