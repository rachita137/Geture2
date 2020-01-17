package tatastrive.application.geture2;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.view.ScaleGestureDetector;

import android.graphics.Matrix;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Matrix imageMatrix = new Matrix();
    private ImageView imageView;
    private float scale = 2f;
    private ScaleGestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);

//Instantiate the gesture detector//

        gestureDetector = new ScaleGestureDetector(MainActivity.this,new imageListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

//Let gestureDetector inspect all events//

        gestureDetector.onTouchEvent(event);
        return true;
    }

//Implement the scale listener//

    private class imageListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override

//Respond to scaling events//

        public boolean onScale(ScaleGestureDetector detector) {

//Return the scaling factor from the previous scale event//

            scale *= detector.getScaleFactor();

//Set a maximum and minimum size for our image//

            scale = Math.max(0.2f, Math.min(scale, 6.0f));
            imageMatrix.setScale(scale, scale);
            imageView.setImageMatrix(imageMatrix);
            return true;
        }
    }
}