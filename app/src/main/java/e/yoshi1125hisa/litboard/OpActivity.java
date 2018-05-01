package e.yoshi1125hisa.litboard;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

public class OpActivity extends AppCompatActivity {

    TextView tapTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // タイトルバーを隠す場合
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ステータスバーを隠す場合
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_op);






        Log.d("Model", Build.MODEL);


        //INTERNETだといらないかも？
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)== PackageManager.PERMISSION_GRANTED){
            // 許可されている時の処理
        }else{
            // 拒否されている時の処理
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)) {
                // 拒否されている時　（一度、requestPermissionsで拒否されているとこちらに来る）


                // 再度許可を求める
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 0);
            } else {
                //　許可を求めるダイアログを表示
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 0);
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            // 許可されている時の処理
        }else{
            // 拒否されている時の処理
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                // 拒否されている時　（一度、requestPermissionsで拒否されているとこちらに来る）
                // 再度許可を求める
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            } else {
                //　許可を求めるダイアログを表示
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
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






        //ネットワーク接続確認
        android.net.ConnectivityManager cm = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null && info.isAvailable()) {
            Log.d("DEBUG", "接続されていません");
            Intent intent = new Intent(this,NetworkErrorActivity.class);
            startActivity(intent);
        }

/*  送信
        DatabaseReference sendsRef = FirebaseDatabase.getInstance().getReference("users");
        sendsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dSnapshot : snapshot.getChildren()) {
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
*/




    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

      //  new StyleableToast.Builder(this)
        //        .text("Welcome to TWIN!")
          //      .textColor(Color.WHITE)
            //    .backgroundColor(Color.BLUE)
                //.iconResLeft(android.R.drawable.ic_dialog_info)
              //  .solidBackground()
                //.length(Toast.LENGTH_SHORT)
                //.show();

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

        return super.onTouchEvent(event);
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent){
            return false;
        }
    }

}

