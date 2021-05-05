package space.ZV.coloredballs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Timer;
import java.util.TimerTask;

public class GameLoading extends AppCompatActivity {

  int time = 4;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_loading);
    Window w = getWindow();
    w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
    final SharedPreferences.Editor data = saveData.edit();

    final TextView startText = (TextView) findViewById(R.id.textView_Time);
    Timer timer = new Timer();

    long delay = 0;
    long period = 1000;
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        time--;
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            if(time == 0){

              startText.setText(R.string.start);

              switch (saveData.getInt("SAVED_N_LEVEl",1)){
                case 1:
                  data.putInt("SAVED_N_COLOR",3);
                  data.putInt("SAVED_N_PERIOD",800); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 2:
                  data.putInt("SAVED_N_COLOR",3);
                  data.putInt("SAVED_N_PERIOD",600); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 3:
                  data.putInt("SAVED_N_COLOR",3);
                  data.putInt("SAVED_N_PERIOD",400); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 4:
                  data.putInt("SAVED_N_COLOR",4);
                  data.putInt("SAVED_N_PERIOD",800); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 5:
                  data.putInt("SAVED_N_COLOR",4);
                  data.putInt("SAVED_N_PERIOD",600); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 6:
                  data.putInt("SAVED_N_COLOR",4);
                  data.putInt("SAVED_N_PERIOD",400); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 7:
                  data.putInt("SAVED_N_COLOR",5);
                  data.putInt("SAVED_N_PERIOD",800); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 8:
                  data.putInt("SAVED_N_COLOR",5);
                  data.putInt("SAVED_N_PERIOD",600); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 9:
                  data.putInt("SAVED_N_COLOR",5);
                  data.putInt("SAVED_N_PERIOD",400); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;
                case 10:
                  data.putInt("SAVED_N_COLOR",5);
                  data.putInt("SAVED_N_PERIOD",400); data.commit();
                  startActivity(new Intent(GameLoading.this, Level_from1to10.class));
                  Animatoo.animateZoom(GameLoading.this);
                  finish();
                  break;

                  default: cancel();
              }
            }
            else {
              if(time > 0) startText.setText(String.valueOf(time));
            }
          }
        });
      }
    },delay,period);
  }
    @Override
    public void onBackPressed() {

    }
}