package space.ZV.coloredballs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class GameSettings extends AppCompatActivity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_setting);
    Window w = getWindow();
    w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
    final SharedPreferences.Editor data = saveData.edit();
    final MediaPlayer soundMP = MediaPlayer.create(this, R.raw.click);

    ImageView backToMenu = (ImageView) findViewById(R.id.backToMenu);
    backToMenu.setSoundEffectsEnabled(false);
    backToMenu.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        try {
          if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
          startActivity(new Intent(GameSettings.this, MainActivity.class));
          Animatoo.animateSlideRight(GameSettings.this);
          finish();
        } catch (Exception e) {

        }
      }
    });

    final TextView caseSwitch = (TextView) findViewById(R.id.caseSwitch);

    if(saveData.getInt("SAVED_SOUND", 1) == 1)
      caseSwitch.setText(R.string.on);
    else
      caseSwitch.setText(R.string.off);

    caseSwitch.setSoundEffectsEnabled(false);
    caseSwitch.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        try {
          if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();

          if (saveData.getInt("SAVED_SOUND", 1) == 1) {
            data.putInt("SAVED_SOUND",0);
            data.commit();
            caseSwitch.setText(R.string.off);
          }else{
            data.putInt("SAVED_SOUND",1);
            data.commit();
            caseSwitch.setText(R.string.on);
          }

        } catch (Exception e) {

        }
      }
    });
  }
  @Override
  public void onBackPressed() {
    startActivity(new Intent(GameSettings.this,MainActivity.class));
    finish();
  }
}
