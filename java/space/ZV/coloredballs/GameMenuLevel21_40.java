package space.ZV.coloredballs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class GameMenuLevel21_40 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_21_40);
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final MediaPlayer soundMP = MediaPlayer.create(this, R.raw.click);
        final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
        final SharedPreferences.Editor data = saveData.edit();

        findViewById(R.id.backMenu).setSoundEffectsEnabled(false);
        findViewById(R.id.backMenu).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    startActivity(new Intent(GameMenuLevel21_40.this,MainActivity.class));
                    finish();
                } catch (Exception e){

                }
            }
        });

        findViewById(R.id.down).setSoundEffectsEnabled(false);
        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    startActivity(new Intent(GameMenuLevel21_40.this,GameMenuLevel1_20.class));
                    Animatoo.animateSlideRight(GameMenuLevel21_40.this);
                    finish();
                } catch (Exception e){

                }
            }
        });

        TextView[] level = {(TextView) findViewById(R.id.textView1), (TextView) findViewById(R.id.textView2), (TextView) findViewById(R.id.textView3),
                (TextView) findViewById(R.id.textView4), (TextView) findViewById(R.id.textView5), (TextView) findViewById(R.id.textView6),
                (TextView) findViewById(R.id.textView7), (TextView) findViewById(R.id.textView8), (TextView) findViewById(R.id.textView9),
                (TextView) findViewById(R.id.textView10), (TextView) findViewById(R.id.textView11), (TextView) findViewById(R.id.textView12),
                (TextView) findViewById(R.id.textView13), (TextView) findViewById(R.id.textView14), (TextView) findViewById(R.id.textView15),
                (TextView) findViewById(R.id.textView16), (TextView) findViewById(R.id.textView17), (TextView) findViewById(R.id.textView18),
                (TextView) findViewById(R.id.textView19), (TextView) findViewById(R.id.textView20)};

        level[0].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    data.putInt("SAVED_N_LEVEl",1);
                    data.commit();
                    Intent intent = new Intent(GameMenuLevel21_40.this,GameLoading.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });

        level[1].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    data.putInt("SAVED_N_LEVEl",2);
                    data.commit();
                    Intent intent = new Intent(GameMenuLevel21_40.this,GameLoading.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });

        level[2].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    data.putInt("SAVED_N_LEVEl",3);
                    data.commit();
                    Intent intent = new Intent(GameMenuLevel21_40.this,GameLoading.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
    }
}
