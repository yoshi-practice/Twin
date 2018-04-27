package e.yoshi1125hisa.litboard;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BluetoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH)== PackageManager.PERMISSION_GRANTED){
            // 許可されている時の処理
        }else{
            // 拒否されている時の処理
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.BLUETOOTH)) {
                // 拒否されている時　（一度、requestPermissionsで拒否されているとこちらに来る）
                // 再度許可を求める
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH}, 0);
            } else {
                //　許可を求めるダイアログを表示
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH}, 0);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // ActivityCompat#requestPermissions()の第2引数で指定した値
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 許可された場合の処理
                }else{
                    // 拒否された場合の処理

                }
                break;
            }
        }



        //BluetoothAdapter取得
        BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
        if(!Bt.equals(null)){
            //Bluetooth対応端末の場合の処理
            Log.d("INFO","Bluetoothがサポートされています。");
        }else{
            //Bluetooth非対応端末の場合の処理
            //Toasty
            Log.d("INFO","Bluetoothがサポートされていません。");
            finish();
        }

        boolean btEnable = Bt.isEnabled();
        if(btEnable == true){
            //BluetoothがONだった場合の処理
        }else{
            //OFFだった場合、ONにすることを促すダイアログを表示する画面に遷移
            Intent btOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(btOn,0);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date) {
        //ダイアログ画面から結果を受けた後の処理を記述
        if (requestCode == 1) {
            if (ResultCode == Activity.RESULT_OK) {
                //BluetoothがONにされた場合の処理
                Log.d("Message", "BluetoothをONにしてもらえました。");
            } else {
                Log.d("Message", "BluetoothがONにしてもらえませんでした。");
                finish();
            }
        }
    }
}

