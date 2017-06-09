package com.kony.scanditbarcodescanner;
import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.scandit.barcodepicker.BarcodePicker;
import com.scandit.barcodepicker.OnScanListener;
import com.scandit.barcodepicker.ScanSession;
import com.scandit.barcodepicker.ScanSettings;
import com.scandit.barcodepicker.ScanditLicense;
import com.scandit.recognition.Barcode;
import java.util.Locale;
import com.konylabs.vm.Function;

/**
 * @author KH2195 John Vinodh Talluri
 */
public class MainActivity extends Activity implements OnScanListener {
    public static String scanditSdkAppKey;
    public static Function callbackFunction;
    String[] mData = new String[2];;
       // public static final String scanditSdkAppKey ="5QUxtFesM/dvalg0KpF1Q3TtD6XfCDky8MRYwMUCjvc";
    private BarcodePicker mBarcodePicker;
    Toast mToast = null;
    private final int CAMERA_PERMISSION_REQUEST = 0;
    private static final String[] CAMERA_PERMISSIONS = {
                                                        Manifest.permission.CAMERA
                                                        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ScanditLicense.setAppKey(scanditSdkAppKey);
        initializeAndStartBarCodeScanning();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean hasAllPermissionsGranted() {
        for (String permission : CAMERA_PERMISSIONS) {
        if(this.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        }
       return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
     private void requestCameraPermissions() {
         this.requestPermissions(CAMERA_PERMISSIONS,CAMERA_PERMISSION_REQUEST);
    }

    private void initializeAndStartBarCodeScanning() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ScanSettings settings = ScanSettings.create();
        int[] symbologiesToEnable = new int[] {
                Barcode.SYMBOLOGY_EAN13,
                Barcode.SYMBOLOGY_EAN8,
                Barcode.SYMBOLOGY_UPCA,
                Barcode.SYMBOLOGY_DATA_MATRIX,
                Barcode.SYMBOLOGY_QR,
                Barcode.SYMBOLOGY_CODE39,
                Barcode.SYMBOLOGY_CODE128,
                Barcode.SYMBOLOGY_INTERLEAVED_2_OF_5,
                Barcode.SYMBOLOGY_UPCE
        };
        for (int sym : symbologiesToEnable) {
            settings.setSymbologyEnabled(sym, true);
        }
       // settings.setSymbologyEnabled(Barcode.SYMBOLOGY_EAN13, true);
        //settings.setSymbologyEnabled(Barcode.SYMBOLOGY_UPCA, true);
        BarcodePicker picker = new BarcodePicker(this, settings);
        setContentView(picker);
        mBarcodePicker = picker;
        mBarcodePicker.setOnScanListener(this);
    }

    @Override
    public void didScan(ScanSession session) {
        String message = "";
        for (Barcode code : session.getNewlyRecognizedCodes()) {
            String data = code.getData();
            // truncate code to certain length
            String cleanData = data;
            if (data.length() > 30) {
                cleanData = data.substring(0, 25) + "[...]";
            }
            if (message.length() > 0) {
                message += "\n\n\n";
            }
            message += cleanData;
            message += "\n\n(" + code.getSymbologyName().toUpperCase(Locale.US) + ")";
        }
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        mToast.show();
        mData[0] = message;
        try {
           callbackFunction.executeAsync(mData);
        } catch (Exception e) {
            Log.i("StandardLib","Error sending data back to Kony app"+e.getMessage());
        }
    }


    @Override
    protected void onPause() {
        mBarcodePicker.stopScanning();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!hasAllPermissionsGranted()) {
                requestCameraPermissions();
                return;
            } else {
                mBarcodePicker.startScanning();
            }
        } else {
            mBarcodePicker.startScanning();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == CAMERA_PERMISSION_REQUEST) {
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    showMissingPermissionError();
                    return;
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * Shows that this app really needs the permission and finishes the app.
     */
    private void showMissingPermissionError() {
            Toast.makeText(MainActivity.this, "This app needs camera permission.", Toast.LENGTH_SHORT).show();
            finish();
        }

    @Override
    public void onBackPressed() {
        mBarcodePicker.stopScanning();
        finish();
    }
}
