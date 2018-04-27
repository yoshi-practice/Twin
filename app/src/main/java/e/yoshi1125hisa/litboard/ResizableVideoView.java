package e.yoshi1125hisa.litboard;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResizableVideoView extends VideoView{


    public ResizableVideoView(Context context , AttributeSet attrs){
        super(context,attrs);
    }

    public ResizableVideoView(Context context , AttributeSet attrs , int defStyleAttr){
        super(context , attrs , defStyleAttr);
    }

    public ResizableVideoView(Context c){
        super(c);
    }


    private int mVideoWidth = 1080;
    private int mVideoHeight = 1794;

    public void changeVideoSize(int width, int height){
        mVideoHeight = height;
        mVideoWidth = width;

        getHolder().setFixedSize(width,height);

        forceLayout();
        invalidate();
    }

    public void onMeasure(int specwidth,int spacheight){

        Log.i("onMeasure","On Measure has been called");
        setMeasuredDimension(mVideoWidth,mVideoHeight);
    }

    public void onDraw(Canvas c){
        super.onDraw(c);
        Log.i("onDraw","Drawing...");
    }

    DatabaseReference todosRef = FirebaseDatabase.getInstance().getReference("todos");

}