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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static space.ZV.coloredballs.R.array.rainbow;

public class Level_from1to10 extends AppCompatActivity {

    Dialog windowOn;
    Dialog windowOff;
    Dialog window_pause;
    Dialog window_nolife;

    static final int TIME_WAIT = 0;
    int N_cycle = 4;
    int[] Colors = new int[6];
    int[] myColors = new int[6];

    int time = -1;
    int c_0 = 0, c_1 = 0, c_2 = 0, c_3 = 0;
    boolean lock = false;
    boolean minus_life = false;

    Timer plusLife_Timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_from1to10);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //_______________________LAYOUT_______________________________________
        final TextView TL = (TextView) findViewById(R.id.textHeart);
        final TextView nLevel = (TextView) findViewById(R.id.nLevel);
        final ImageView[] cycle = {(ImageView) findViewById(R.id.cycle1),
                (ImageView) findViewById(R.id.cycle2),
                (ImageView) findViewById(R.id.cycle3),
                (ImageView) findViewById(R.id.cycle4)};
        final ImageView backToPause = (ImageView) findViewById(R.id.button_pause);
        final Button result = (Button) findViewById(R.id.button_cont);
        final TextView textTime = (TextView) findViewById(R.id.textTime);
        //_____________________________________________________________________
        final MediaPlayer soundMP = MediaPlayer.create(this, R.raw.click);

        final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
        final SharedPreferences.Editor data = saveData.edit();

        //____________________________
        //data.putInt("SAVED_LIFE",5); data.commit(); data.putInt("SAVED_LOCKTIME",0); data.commit();
        //____________________________

        final int[] rainbows = getResources().getIntArray(rainbow);

        TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));
        nLevel.setText(String.valueOf(saveData.getInt("SAVED_N_LEVEl",1)));

        if (saveData.getInt("SAVED_LIFE", -1) == 5) {
            textTime.setText("");
        }

        final int N_period =saveData.getInt("SAVED_N_PERIOD",1);
        final int N_color =saveData.getInt("SAVED_N_COLOR",1);

        beginGame(cycle, rainbows, N_color, N_period);

        for (int i = 0; i < N_cycle; i++) myColors[i] = -1;

        cycle[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_0 == N_color) c_0 = 0;
                        cycle[0].setColorFilter(rainbows[c_0]);
                        myColors[0] = rainbows[c_0];
                        c_0++;
                    } catch (Exception e) {

                    }
                }
            }
        });

        cycle[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_1 == N_color) c_1 = 0;
                        cycle[1].setColorFilter(rainbows[c_1]);
                        myColors[1] = rainbows[c_1];
                        c_1++;

                    } catch (Exception e) {

                    }
                }
            }
        });

        cycle[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_2 == N_color) c_2 = 0;
                        cycle[2].setColorFilter(rainbows[c_2]);
                        myColors[2] = rainbows[c_2];
                        c_2++;

                    } catch (Exception e) {

                    }
                }
            }
        });

        cycle[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_3 == N_color) c_3 = 0;
                        cycle[3].setColorFilter(rainbows[c_3]);
                        myColors[3] = rainbows[c_3];
                        c_3++;

                    } catch (Exception e) {

                    }
                }
            }
        });

        result.setSoundEffectsEnabled(false);
        result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (lock) {
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                    time = -1;
                    endGame(cycle, TL, textTime, saveData, data, soundMP);
                }
            }
        });

        if (saveData.getInt("SAVED_LIFE", -1) < 5 && saveData.getInt("SAVED_LOCKTIME", 1) == 1) {
            minusLife(TL, textTime, saveData, data);
        } else {
            data.putInt("SAVED_LOCKTIME", 0);
            data.commit();
        }
        backToPause.setSoundEffectsEnabled(false);
        backToPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();

                    window_pause = new Dialog(Level_from1to10.this);
                    window_pause.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    window_pause.setContentView(R.layout.activity_window_pause);
                    window_pause.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    window_pause.setCancelable(false);
                    window_pause.findViewById(R.id.buttonCont).setSoundEffectsEnabled(false);
                    window_pause.findViewById(R.id.buttonCont).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                                window_pause.cancel();
                            } catch (Exception e) {

                            }
                        }
                    });

                    window_pause.findViewById(R.id.buttonExit).setSoundEffectsEnabled(false);
                    window_pause.findViewById(R.id.buttonExit).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                                //________________МИНУС ЖИЗНЬ_________
                                data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) - 1);
                                data.commit();
                                if (saveData.getInt("SAVED_LOCKTIME", 0) == 0) {
                                    data.putInt("SAVED_LOCKTIME", 1);
                                   // data.commit();
                                    data.putLong("SAVED_TIME", Calendar.getInstance().getTimeInMillis());
                                    data.commit();
                                    minusLife(TL, textTime, saveData, data);
                                }
                                //____________________________________
                                plusLife_Timer.cancel();
                                plusLife_Timer.purge();
                                startActivity(new Intent(Level_from1to10.this, MainActivity.class));
                                finish();
                            } catch (Exception e) {

                            }
                        }
                    });

                    window_pause.show();
                }
            }
        });
    }

    public void minusLife(final TextView TL, final TextView textTime, final SharedPreferences saveData, final SharedPreferences.Editor data) {

        final long plusLife_delay = 0;
        long plusLife_period = 1000;

        plusLife_Timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                final Calendar timeLifeCalendarNow = Calendar.getInstance();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        long timeNow = timeLifeCalendarNow.getTimeInMillis() - saveData.getLong("SAVED_TIME", 1);
                        long minute = TIME_WAIT - timeNow / 1000 / 60;
                        long second = 59 - timeNow / 1000 % 60;

                        for (int i = 1; i < 5; ++i)
                            if (minute == -1 * i || minute <= -5) {
                                if(saveData.getInt("SAVED_LIFE", -1) + i < 5){
                                    data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) + i);
                                  //  data.commit();
                                   // TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));
                                    minute = 0;
                                    data.putLong("SAVED_TIME", saveData.getLong("SAVED_TIME", 1) + 60 * i * 1000);
                                    data.commit();
                                }
                                else{
                                    data.putInt("SAVED_LIFE", 5);
                                  //  data.commit();
                                    //TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));
                                    data.putInt("SAVED_LOCKTIME", 0);
                                    data.commit();
                                    cancel();
                                }
                            }


                        if (((minute == 0) && (second == 0)) && saveData.getInt("SAVED_LIFE", -1) < 5) {

                            data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) + 1);
                           // data.commit();
                            data.putLong("SAVED_TIME", Calendar.getInstance().getTimeInMillis());
                            data.commit();
                           // TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));

                            if (saveData.getInt("SAVED_LIFE", 1) >= 5) {
                                data.putInt("SAVED_LOCKTIME", 0);
                                data.commit();
                                cancel();
                            }
                        }

                        if(saveData.getInt("SAVED_LIFE", -1) != 5)
                            textTime.setText(String.format(Locale.getDefault(), "%02d:%02d", minute, second));
                        else
                            textTime.setText("");

                        TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));
                    }
                });
            }
        }, plusLife_delay, plusLife_period);

    }

    public void beginGame(final ImageView[] cycle, final int[] rainbows, final int N_color, final int N_period) {
        final Timer timer = new Timer();
        final long delay = 1000;
        long period = N_period;

        final Random random = new Random();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                time++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int i = Integer.valueOf(random.nextInt(N_color));

                        if (time == 0) {
                            cycle[time].setColorFilter(rainbows[i]);
                            Colors[time] = rainbows[i];
                        }
                        if ((time > 0) && (time < N_cycle)) {
                            cycle[time - 1].setColorFilter(null);
                            cycle[time].setColorFilter(rainbows[i]);
                            Colors[time] = rainbows[i];
                        }
                        if (time == N_cycle) {
                            cycle[time - 1].setColorFilter(null);
                            timer.cancel();
                            timer.purge();
                            lock = true;
                        }
                    }
                });
            }
        }, delay, period);
    }

    public void endGame(final ImageView[] cycle,final TextView TL, final TextView textTime, final SharedPreferences saveData, final SharedPreferences.Editor data,final MediaPlayer soundMP) {

        final Timer timer = new Timer();
        final long delay = 400;
        long period = 400;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                time++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            if (Colors[time] == myColors[time]) {
                                cycle[time].setColorFilter(null);
                                cycle[time].setImageResource(R.drawable.yes);
                            } else {
                                cycle[time].setImageResource(R.drawable.no);
                                cycle[time].setColorFilter(null);
                                minus_life = true;
                            }
                        lock = false;

                            if(time == N_cycle-1){
                                timer.cancel();
                                timer.purge();
                                resultLevel(minus_life, TL, textTime,  saveData, data, soundMP);
                            }
                    }
                });
            }
        }, delay, period);
    }

    public void resultLevel(boolean minus_life, final TextView TL, final TextView textTime, final SharedPreferences saveData, final SharedPreferences.Editor data, final MediaPlayer soundMP){

        if (minus_life) {

            data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) - 1);
            data.apply();

            TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));

            if(saveData.getInt("SAVED_LIFE", 0) != 0){

                if (saveData.getInt("SAVED_LOCKTIME", 0) == 0) {
                    data.putInt("SAVED_LOCKTIME", 1);
                    data.commit();
                    data.putLong("SAVED_TIME", Calendar.getInstance().getTimeInMillis());
                    data.commit();
                    minusLife(TL, textTime, saveData, data);
                }

                windowOff = new Dialog(Level_from1to10.this);
                windowOff.requestWindowFeature(Window.FEATURE_NO_TITLE);
                windowOff.setContentView(R.layout.activity_window_bed);
                windowOff.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                windowOff.setCancelable(false);
                windowOff.show();
                windowOff.findViewById(R.id.btncloseOff).setSoundEffectsEnabled(false);
                windowOff.findViewById(R.id.btncloseOff).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            plusLife_Timer.cancel();
                            plusLife_Timer.purge();
                            if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                            startActivity(new Intent(Level_from1to10.this, GameMenuLevel1_20.class));
                            finish();
                        } catch (Exception e) {

                        }
                    }
                });

                windowOff.findViewById(R.id.btnReturn).setSoundEffectsEnabled(false);
                windowOff.findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            plusLife_Timer.cancel();
                            plusLife_Timer.purge();
                            if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                            startActivity(new Intent(Level_from1to10.this, GameLoading.class));
                            finish();
                        } catch (Exception e) {

                        }
                    }
                });
            }else{

                window_nolife = new Dialog(Level_from1to10.this);
                window_nolife.requestWindowFeature(Window.FEATURE_NO_TITLE);
                window_nolife.setContentView(R.layout.activity_window_nolife_level);
                window_nolife.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                window_nolife.setCancelable(false);
                window_nolife.show();
                window_nolife.findViewById(R.id.btnEsc).setSoundEffectsEnabled(false);
                window_nolife.findViewById(R.id.btnEsc).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            plusLife_Timer.cancel();
                            plusLife_Timer.purge();
                            if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                            startActivity(new Intent(Level_from1to10.this, MainActivity.class));
                            finish();
                        } catch (Exception e) { }
                    }
                });
            }


        } else {

            if(saveData.getInt("SAVED_N_LEVEl",1) - saveData.getInt("SEVED_OPENLEVEL", 0) == 1 ){
                data.putInt("SEVED_OPENLEVEL", saveData.getInt("SEVED_OPENLEVEL", 0) + 1);
                data.commit();
            }

            windowOn = new Dialog(Level_from1to10.this);
            windowOn.requestWindowFeature(Window.FEATURE_NO_TITLE);
            windowOn.setContentView(R.layout.activity_window);
            windowOn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            windowOn.setCancelable(false);
            windowOn.show();
            windowOn.findViewById(R.id.btnclose).setSoundEffectsEnabled(false);
            windowOn.findViewById(R.id.btnclose).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        plusLife_Timer.cancel();
                        plusLife_Timer.purge();
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        startActivity(new Intent(Level_from1to10.this, GameMenuLevel1_20.class));
                        finish();
                    } catch (Exception e) {  }
                }
            });

            windowOn.findViewById(R.id.upLevel).setSoundEffectsEnabled(false);
            windowOn.findViewById(R.id.upLevel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        plusLife_Timer.cancel();
                        plusLife_Timer.purge();
                        data.putInt("SAVED_N_LEVEl", saveData.getInt("SAVED_N_LEVEl", 0) + 1);
                        data.commit();
                        if (saveData.getInt("SAVED_SOUND", 1) == 1) soundMP.start();
                        startActivity(new Intent(Level_from1to10.this, GameLoading.class));
                        finish();
                    } catch (Exception e) {  }
                }
            });

        }

    }

    @Override
    public void onBackPressed() {

        final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
        final SharedPreferences.Editor data = saveData.edit();

        data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) - 1);
        data.apply();

        plusLife_Timer.cancel();
        plusLife_Timer.purge();

        if (saveData.getInt("SAVED_LOCKTIME", 0) == 0) {
            data.putInt("SAVED_LOCKTIME", 1);
            data.putLong("SAVED_TIME", Calendar.getInstance().getTimeInMillis());
            data.commit();
        }

        startActivity(new Intent(Level_from1to10.this,GameMenuLevel1_20.class));
        finish();
    }
}