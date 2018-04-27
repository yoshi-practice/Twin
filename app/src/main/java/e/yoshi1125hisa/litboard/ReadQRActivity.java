package e.yoshi1125hisa.litboard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.List;

import es.dmoral.toasty.Toasty;

import static java.lang.Thread.sleep;

public class ReadQRActivity extends AppCompatActivity {
    private CompoundBarcodeView mBarcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // タイトルバーを隠す場合
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ステータスバーを隠す場合
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_read_qr);

/*
        //Permission CAMERA
        if (ContextCompat.checkSelfPermission(this, a\ndroid.Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
            // 許可されている時の処理
        }else{
            // 拒否されている時の処理
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)) {
                // 拒否されている時　（一度、requestPermissionsで拒否されているとこちらに来る）
                // 再度許可を求める
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 0);
            } else {
                //　許可を求めるダイアログを表示
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 0) {
                // ActivityCompat#requestPermissions()の第2引数で指定した値
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 許可された場合の処理
                }else{
                    // 拒否された場合の処理
                }
        }
*/

               mBarcodeView = findViewById(R.id.barcodeView);
                mBarcodeView.decodeSingle(new BarcodeCallback() {
                    @Override
                    public void barcodeResult(BarcodeResult barcodeResult) {

                        TextView textView = findViewById(R.id.textView);
                        //textView.setText(barcodeResult.getText());


                        //Infomation Toast
                        //SuperToast superToast = new SuperToast(ReadQRActivity.this);
                        //superToast.setDuration(SuperToast.Duration.LONG);
                        //superToast.setText(barcodeResult.getText());
                        //superToast.setIcon(SuperToast.Icon.Dark.INFO, SuperToast.IconPosition.LEFT);
                        //superToast.show();

                        //待機。statusバーを出して、動画をダウンロードしています…を表示
                        //そして、Activityを移動

                        String userName = "userName";

                        //getしたKeyを検索。UserNameを取得

                        new StyleableToast.Builder(ReadQRActivity.this)
                                .text(userName +" さんと\nペアリングに成功しました。"+"\nCODE: "+barcodeResult.getText().toString())
                                .textColor(Color.WHITE)
                                .backgroundColor(Color.BLUE)
                                .iconResLeft(android.R.drawable.ic_popup_sync)
                                .solidBackground()
                                .length(Toast.LENGTH_SHORT)
                                .show();

                        try {
                            Thread.sleep(3000); //3000ミリ秒Sleepする
                        } catch (InterruptedException e) {
                        }

                       Intent intent = new Intent(ReadQRActivity.this,MovieActivity.class);
                        //intent.putExtra("postData", userName.toString());
                        startActivity(intent);

                    }

                    @Override
                    public void possibleResultPoints(List<ResultPoint> list) {

                    }
                });
            }

            @Override
            public void onResume() {
                super.onResume();
                mBarcodeView.resume();
            }

            @Override
            public void onPause() {
                super.onPause();
                mBarcodeView.pause();
            }
        }