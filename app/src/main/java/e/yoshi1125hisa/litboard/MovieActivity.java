package e.yoshi1125hisa.litboard;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // タイトルバーを隠す場合.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ステータスバーを隠す場合
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_movie);

        Display disp;
        disp = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        disp.getMetrics(dm);

        double inchX = dm.widthPixels / dm.xdpi;
        double inchY = dm.heightPixels / dm.ydpi;
        double inch = Math.sqrt((inchX * inchX) + (inchY * inchY));
        System.out.println(inch);

       final  ResizableVideoView videoView = findViewById(R.id.videoView);



                //ここは違う
   Post post = (Post) getIntent().getSerializableExtra("postData");

   //取得方法
        post.getUserName();
        post.getAt();
        post.getPass();
        post.getMail();
        post.getInch();
        post.getInchX();
        post.getInchY();
        post.getRealScreenHeight();
        post.getRealScreenWidth();

        double doubleGetInchX =  new Double(post.getInchX()).doubleValue();
        double doubleGetInchY =  new Double(post.getInchY()).doubleValue();



        String getInchX = post.getInchX();
        String getInchY = post.getInchY();
        String getInch = post.getInch();

        //videoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.));


        if( doubleGetInchX >= inchX &&  doubleGetInchY >= inchY){
            videoView.setLayoutParams(new LinearLayout.LayoutParams((int)inchX,(int)inchY));
        }else if( doubleGetInchX >= inchX &&  doubleGetInchY <= inchY){
            videoView.setLayoutParams(new LinearLayout.LayoutParams((int)inchX,(int)doubleGetInchY));
        }else{
            videoView.setLayoutParams(new LinearLayout.LayoutParams((int)doubleGetInchX,(int)doubleGetInchY));
        }

        //gravidyも変更したい


        //再生
        videoView.start();

        // インターネット上のファイルを再生
        //videoView.setVideoURI(Uri.parse("ＵＲＬ"));




    }
}
