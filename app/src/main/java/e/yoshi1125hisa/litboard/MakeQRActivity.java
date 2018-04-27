package e.yoshi1125hisa.litboard;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.BarcodeEncoder;
public class MakeQRActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // タイトルバーを隠す場合
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ステータスバーを隠す場合
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_make_qr);


        DisplayMetrics dMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dMetrics);

        double realScreenWidth = dMetrics.widthPixels ;
        double realScreenHeight = dMetrics.heightPixels ;

        int size;

        //QRコードの最大表示。
        if(realScreenHeight >= realScreenWidth){
            size = (int)realScreenWidth;
        }else {
            size = (int)realScreenHeight;
        }

        // 受信側で取得したKeyを検索にかけてXYのInchを取得。
        DatabaseReference sendsRef = FirebaseDatabase.getInstance().getReference("users");
        sendsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dSnapshot : snapshot.getChildren()) {
                    // getApplication()でアプリケーションクラスのインスタンスを拾う
                    String key = dSnapshot.getKey();
                    String userName = (String) dSnapshot.child("userName").getValue();
                    String height_Pixel = (String) dSnapshot.child("height_Pixel").getValue();
                    String width_Pixel = (String) dSnapshot.child("width_Pixel").getValue();
                    String xdpi = (String) dSnapshot.child("xdpi").getValue();
                    String ydpi = (String) dSnapshot.child("ydpi").getValue();
                    String at = (String) dSnapshot.child("at").getValue();
                    String mail = (String) dSnapshot.child("mail").getValue();
                    String pass = (String) dSnapshot.child("pass").getValue();
                }
                // 保存した情報を用いた描画処理などを記載する。
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("error","error");
            }
        });

        //QRコードのdata。Id？
        String data=  "http://einscan.net/?gclid=CjwKCAjwq_vWBRACEiwAEReprOZKukW7BL2TNNkTP2-jn9ZdRwPdN895QGGYQJkhFYF8N2FBb9gHfxoCXtQQAvD_BwE";
            try {
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size,size);
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);

            } catch (WriterException e) {
                Toast.makeText(this, "エラーが発生しました。", Toast.LENGTH_SHORT).show();
                throw new AndroidRuntimeException("Barcode Error.", e);
            }

        }
    }
