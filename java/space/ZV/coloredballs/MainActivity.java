package space.ZV.coloredballs;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
        final SharedPreferences.Editor data = saveData.edit();

        final MediaPlayer soundMP = MediaPlayer.create(this, R.raw.click);

        findViewById(R.id.buttonStart).setSoundEffectsEnabled(false);
        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1){
                        soundMP.start();
                    }
                    startActivity(new Intent(MainActivity.this, GameMenuLevel1_20.class));
                    Animatoo.animateShrink(MainActivity.this);
                    finish();
                } catch (Exception e){
                    
                }
            }
        });


        if(isNetworkConnected()) {
            findViewById(R.id.buttonSetting).setSoundEffectsEnabled(false);
            findViewById(R.id.buttonSetting).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    try {
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) {
                            soundMP.start();
                        }
                        startActivity(new Intent(MainActivity.this, GameSettings.class));
                        Animatoo.animateShrink(MainActivity.this);
                        finish();
                    } catch (Exception e) {

                    }
                }
            });
        }

        findViewById(R.id.buttonExit).setSoundEffectsEnabled(false);
        findViewById(R.id.buttonExit).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1){
                        soundMP.start();
                    }
                    Animatoo.animateShrink(MainActivity.this);
                    finish();
                } catch (Exception e){

                }
            }
        }
        );
    }

    private boolean isNetworkConnected()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    @Override
    public void onBackPressed(){

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast=Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }



}
