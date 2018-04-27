package e.yoshi1125hisa.litboard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.lang.reflect.Method;
import static android.widget.Toast.LENGTH_SHORT;

public class PostActivity extends AppCompatActivity implements View.OnClickListener{
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg;
    EditText usernameText;
    EditText mailText;
    EditText passText;
    EditText atText;
    Button mPostButton;
    TextView usertourokuText;
    String modelName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // タイトルバーを隠す場合
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ステータスバーを隠す場合
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_post);

        refMsg = database.getReference("users");
        mPostButton = findViewById(R.id.post);
        usernameText = findViewById(R.id.usernameText);
        atText = findViewById(R.id.atText);
        mPostButton.setOnClickListener(this);
        mailText = findViewById(R.id.mailText);
        passText = findViewById(R.id.passText);
        usertourokuText = findViewById(R.id.textView);
    }

        @Override
        public void onClick(View v) {
            int id = v.getId();

            switch (id) {
                case R.id.post:
                    DisplayMetrics dMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getRealMetrics(dMetrics);
                    String realScreenWidth = dMetrics.widthPixels + "";
                    String realScreenHeight = dMetrics.heightPixels + "";
                    float floatRealScrWidth = dMetrics.widthPixels;
                    float floatRealScrHeight = dMetrics.heightPixels;
                    Display display = getWindowManager().getDefaultDisplay();
                    Point point1 = new Point();
                    display.getSize(point1);
                    Display display2 = getWindowManager().getDefaultDisplay();
                    Point point2 = new Point(0, 0);
                    display2.getRealSize(point2);
                    Display disp;
                    disp = getWindowManager().getDefaultDisplay();
                    DisplayMetrics dm = new DisplayMetrics();
                    disp.getMetrics(dm);
                    String widthPixel = dm.widthPixels + "";
                    float floatWidthPx = dm.widthPixels;
                    String heightPixel = dm.heightPixels +"";
                    float floatHeightPx = dm.heightPixels;
                    String dpiX = dm.xdpi + "";
                    String dpiY = dm.ydpi + "";
                    final String inchX = dm.widthPixels / dm.xdpi +"";
                    final String inchY = dm.heightPixels / dm.ydpi + "";
                    double inchXTest = dm.widthPixels / dm.xdpi;
                    double inchYTest = dm.heightPixels / dm.ydpi;
                    final String inch = Math.sqrt((inchXTest * inchXTest) + (inchYTest * inchYTest)) +"";
                    double inchTest = Math.sqrt((inchXTest * inchXTest) + (inchYTest * inchYTest));
                    System.out.println(inch);
                    System.out.println(inchTest);
                    String UserName = usernameText.getText().toString();
                    String at = atText.getText().toString();
                    String mail = mailText.getText().toString();
                    String pass = passText.getText().toString();
                    modelName = Build.MODEL;
                    String point2x = Integer.toString(point2.x);
                    String point2y = Integer.toString(point2.y);

                    point2x.getBytes().toString();
                    point2y.getBytes().toString();
                    String xy = point2x+point2y;

                    //DP?
                    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                    String dpY = floatHeightPx / displayMetrics.density +"";
                    String dpX = floatWidthPx / displayMetrics.density+"";
                    Float floatDpHeight = floatHeightPx / displayMetrics.density;
                    Float floatDpWidth = floatWidthPx / displayMetrics.density;
                    final String realInchX = floatRealScrWidth / floatDpWidth +"";
                    final String realInchY = floatRealScrHeight / floatDpHeight +"";
                    float floatRealInchX = floatRealScrWidth / floatDpWidth ;
                    float floatRealInchY = floatRealScrHeight / floatDpHeight ;
                    double doubleRealInch = Math.sqrt((floatRealInchX * floatRealInchX) + (floatRealInchY * floatRealInchY));
                    String realInch = doubleRealInch +"";

                    //Toast.makeText(this,    getResources().getDisplayMetrics().toString(), Toast.LENGTH_LONG).show();
                    final Post post = new Post(UserName,mail,at,pass,inch,inchX,inchY,dpiX,dpiY,realScreenHeight,realScreenWidth,modelName,dpX,dpY);


                    //childを見に行く。
                    //そして次のActivityに送る。

                    refMsg.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Log.d("ondatachange", dataSnapshot.getRef().push().getKey().toString());
                            Intent intent = new Intent(PostActivity.this, SelectActivity.class);
                            intent.putExtra("postData", dataSnapshot.getValue(Post.class));
                            startActivity(intent);
                        }
                        @Override
                            public void onCancelled(DatabaseError databaseError) {
                            Intent intent = new Intent(PostActivity.this,NetworkErrorActivity.class);
                            startActivity(intent);
                        }
                    });
                    refMsg.push().setValue(post);
                    break;
            }
    }
}