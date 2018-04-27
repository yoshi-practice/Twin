package e.yoshi1125hisa.litboard;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void left(View v){
        Intent intent = new Intent(this,ReadQRActivity.class);
        startActivity(intent);
    }

    public void right(View v){
        Intent intent = new Intent(this,MakeQRActivity.class);
        startActivity(intent);
    }
}
