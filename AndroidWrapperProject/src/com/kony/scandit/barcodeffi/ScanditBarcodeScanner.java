package com.kony.scandit.barcodeffi;

import com.konylabs.android.KonyMain;
import com.konylabs.vm.Function;
import android.content.Intent;
import com.kony.scanditbarcodescanner.MainActivity;
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
