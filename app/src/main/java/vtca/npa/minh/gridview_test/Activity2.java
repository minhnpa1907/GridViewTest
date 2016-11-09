package vtca.npa.minh.gridview_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Activity2 extends AppCompatActivity {

    ImageView resultImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String photoUrl = intent.getStringExtra("image");

        resultImgView = (ImageView) findViewById(R.id.resultImgView);

        Picasso.with(this).load(photoUrl).into(resultImgView);
    }
}
