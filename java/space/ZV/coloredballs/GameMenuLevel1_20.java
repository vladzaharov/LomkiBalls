package space.ZV.coloredballs;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GameMenuLevel1_20 extends AppCompatActivity {

    Dialog windowAd;
    static final int TIME_WAIT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1_20);
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView[] level = {(TextView) findViewById(R.id.textView1), (TextView) findViewById(R.id.textView2), (TextView) findViewById(R.id.textView3),
                (TextView) findViewById(R.id.textView4), (TextView) findViewById(R.id.textView5), (TextView) findViewById(R.id.textView6),
                (TextView) findViewById(R.id.textView7), (TextView) findViewById(R.id.textView8), (TextView) findViewById(R.id.textView9),
                (TextView) findViewById(R.id.textView10), (TextView) findViewById(R.id.textView11), (TextView) findViewById(R.id.textView12),
                (TextView) findViewById(R.id.textView13), (TextView) findViewById(R.id.textView14), (TextView) findViewById(R.id.textView15),
                (TextView) findViewById(R.id.textView16), (TextView) findViewById(R.id.textView17), (TextView) findViewById(R.id.textView18),
                (TextView) findViewById(R.id.textView19), (TextView) findViewById(R.id.textView20)};
        ImageView[] level_img = {(ImageView) findViewById(R.id.imageView1), (ImageView) findViewById(R.id.imageView2),(ImageView) findViewById(R.id.imageView3),
                (ImageView) findViewById(R.id.imageView4), (ImageView) findViewById(R.id.imageView5),(ImageView) findViewById(R.id.imageView6),
                (ImageView) findViewById(R.id.imageView7), (ImageView) findViewById(R.id.imageView8),(ImageView) findViewById(R.id.imageView9),
                (ImageView) findViewById(R.id.imageView10), (ImageView) findViewById(R.id.imageView11),(ImageView) findViewById(R.id.imageView12),
                (ImageView) findViewById(R.id.imageView13), (ImageView) findViewById(R.id.imageView14),(ImageView) findViewById(R.id.imageView15),
                (ImageView) findViewById(R.id.imageView16), (ImageView) findViewById(R.id.imageView17),(ImageView) findViewById(R.id.imageView18),
                (ImageView) findViewById(R.id.imageView19), (ImageView) findViewById(R.id.imageView20)};

        final MediaPlayer soundMP = MediaPlayer.create(this, R.raw.click);
        final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
        final SharedPreferences.Editor data = saveData.edit();

       // data.putInt("SEVED_OPENLEVEL", 0); data.commit();

        for(int i=saveData.getInt("SEVED_OPENLEVEL", 0)+1; i<20;++i){
            level[i].setText("");
            level_img[i].setImageResource(R.drawable.castle);
        }

        Calendar timeLifeCalendarNow = Calendar.getInstance();
        long timeNow = timeLifeCalendarNow.getTimeInMillis() - saveData.getLong("SAVED_TIME", 1);
        long minute = TIME_WAIT - timeNow / 1000 / 60;

        for (int i = 1; i < 5; ++i)
            if ((minute == -1 * i || minute <= -5)/* && saveData.getInt("SAVED_LOCKTIME", -1) == 0*/) {
                if(saveData.getInt("SAVED_LIFE", -1) + i < 5){
                    data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) + i);
                    data.commit();
                    data.putLong("SAVED_TIME", saveData.getLong("SAVED_TIME", 1) + 60 * i * 1000);
                    data.commit();
                }
                else{
                    data.putInt("SAVED_LIFE", 5);
                    data.commit();
                    data.putInt("SAVED_LOCKTIME", 0);
                    data.commit();
                }
            }

        for(int i=0; i<20; i++){
            level[i].setSoundEffectsEnabled(false);
        }

        if(0 <= saveData.getInt("SEVED_OPENLEVEL", 0))
        level[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    openLevel(1,saveData, data, soundMP);
                } catch (Exception e){ }
            }
        });

        if(1 <= saveData.getInt("SEVED_OPENLEVEL", 0))
        level[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    openLevel(2,saveData, data, soundMP);
                } catch (Exception e){ }
            }
        });

        if(2 <= saveData.getInt("SEVED_OPENLEVEL", 0))
        level[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    openLevel(3,saveData, data, soundMP);
                } catch (Exception e){ }
            }
        });

        if(3 <= saveData.getInt("SEVED_OPENLEVEL", 0))
        level[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    openLevel(4,saveData, data, soundMP);
                } catch (Exception e){ }
            }
        });

        if(4 <= saveData.getInt("SEVED_OPENLEVEL", 0))
        level[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    openLevel(5,saveData, data, soundMP);
                } catch (Exception e){ }
            }
        });

        if(5 <= saveData.getInt("SEVED_OPENLEVEL", 0))
            level[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        openLevel(6,saveData, data, soundMP);
                    } catch (Exception e){ }
                }
            });

        if(6 <= saveData.getInt("SEVED_OPENLEVEL", 0))
            level[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        openLevel(7,saveData, data, soundMP);
                    } catch (Exception e){ }
                }
            });

        if(7 <= saveData.getInt("SEVED_OPENLEVEL", 0))
            level[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        openLevel(8,saveData, data, soundMP);
                    } catch (Exception e){ }
                }
            });

        if(8 <= saveData.getInt("SEVED_OPENLEVEL", 0))
            level[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        openLevel(9,saveData, data, soundMP);
                    } catch (Exception e){ }
                }
            });

        if(9 <= saveData.getInt("SEVED_OPENLEVEL", 0))
            level[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        openLevel(10,saveData, data, soundMP);
                    } catch (Exception e){ }
                }
            });


        findViewById(R.id.backMenu).setSoundEffectsEnabled(false);
        findViewById(R.id.backMenu).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    startActivity(new Intent(GameMenuLevel1_20.this,MainActivity.class));
                    Animatoo.animateSlideRight(GameMenuLevel1_20.this);
                    finish();
                } catch (Exception e){

                }
            }
        });

        findViewById(R.id.up).setSoundEffectsEnabled(false);
        findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    startActivity(new Intent(GameMenuLevel1_20.this,GameMenuLevel21_40.class));
                    Animatoo.animateSlideLeft(GameMenuLevel1_20.this);
                    finish();
                } catch (Exception e){

                }
            }
        });

    }


    void openLevel(int N, final SharedPreferences saveData, final SharedPreferences.Editor data, final MediaPlayer soundMP){
        Calendar timeLifeCalendar = Calendar.getInstance();
        long timeNow = timeLifeCalendar.getTimeInMillis() - saveData.getLong("SAVED_TIME", 1);
        long minute = TIME_WAIT - timeNow / 1000 / 60;

        if(saveData.getInt("SAVED_LIFE", -1) != 0 || saveData.getInt("SAVED_LOCKLEVEL", 0) == 1 || minute < 0){
            data.putInt("SAVED_LOCKLEVEL", 0);
            data.putInt("SAVED_N_LEVEl",N);
            data.commit();
            startActivity(new Intent(GameMenuLevel1_20.this,GameLoading.class));
            Animatoo.animateFade(GameMenuLevel1_20.this);
            finish();
        }else{
            windowAd = new Dialog(GameMenuLevel1_20.this);
            windowAd.requestWindowFeature(Window.FEATURE_NO_TITLE);
            windowAd.setContentView(R.layout.activity_window_nolife);
            windowAd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            windowAd.setCancelable(false);
            windowAd.show();

            final TextView infoTime = (TextView) windowAd.findViewById(R.id.infoTime);
            final Timer timer = new Timer();
            long delay = 0;
            long period = 1000;

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    final Calendar timeLifeCalendarNow = Calendar.getInstance();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            long timeNow = timeLifeCalendarNow.getTimeInMillis() - saveData.getLong("SAVED_TIME", 1);
                            long minute = TIME_WAIT - timeNow / 1000 / 60;
                            long second = 59 - timeNow / 1000 % 60;
                            infoTime.setText(String.format(Locale.getDefault(), "%01d:%02d", minute, second));
                            if(minute < 0){
                                data.putInt("SAVED_LOCKLEVEL", 1);
                                data.commit();
                                windowAd.cancel();
                                timer.cancel();
                                timer.purge();
                            }
                        }
                    });
                }
            }, delay, period);


            TextView btncloseOff = (TextView) windowAd.findViewById(R.id.btncloseOff);
            btncloseOff.setSoundEffectsEnabled(false);
            btncloseOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        timer.cancel();
                        timer.purge();
                        windowAd.cancel();
                    } catch (Exception e) {

                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(GameMenuLevel1_20.this,MainActivity.class));
        finish();
    }
}
