package space.ZV.coloredballs;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static space.ZV.coloredballs.R.array.rainbow;

public class Level_from41to60 extends AppCompatActivity {

    Dialog windowOn;
    Dialog windowOff;
    Dialog window_pause;

    static final int TIME_WAIT = 0;
    int N = 6;
    int[] Colors = new int[6];
    int[] myColors = new int[6];


    int time = -1;
    int c_0 = 0, c_1 = 0, c_2 = 0, c_3 = 0, c_4 = 0, c_5 = 0;
    boolean lock = false;
    boolean minus_life = false;

    Timer plusLife_Timer = new Timer();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //_______________________LAYOUT_______________________________________
        final TextView TL = (TextView) findViewById(R.id.textHeart);
        final ImageView[] cycle = {(ImageView) findViewById(R.id.cycle1),
                (ImageView) findViewById(R.id.cycle2),
                (ImageView) findViewById(R.id.cycle3),
                (ImageView) findViewById(R.id.cycle4),
                (ImageView) findViewById(R.id.cycle5),
                (ImageView) findViewById(R.id.cycle6)};
        final ImageView backToPause = (ImageView) findViewById(R.id.button_pause);
        final Button result = (Button) findViewById(R.id.button_cont);
        final TextView textTime = (TextView) findViewById(R.id.textTime);
        //_____________________________________________________________________

        final SharedPreferences saveData = getSharedPreferences("SAVED", MainActivity.MODE_PRIVATE);
        final SharedPreferences.Editor data = saveData.edit();

        //____________________________
        //data.putInt("SAVED_LIFE",5); data.commit(); data.putInt("SAVED_LOCKTIME",0); data.commit();
        //____________________________

        final int[] rainbows = getResources().getIntArray(rainbow);

        TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));

        if (saveData.getInt("SAVED_LIFE", -1) == 5) {
            textTime.setText("");
        }

        beginGame(cycle, rainbows);

        for (int i = 0; i < 6; i++) myColors[i] = -1;

        cycle[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_0 == 5) c_0 = 0;
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
                        if (c_1 == 5) c_1 = 0;
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
                        if (c_2 == 5) c_2 = 0;
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
                        if (c_3 == 5) c_3 = 0;
                        cycle[3].setColorFilter(rainbows[c_3]);
                        myColors[3] = rainbows[c_3];
                        c_3++;

                    } catch (Exception e) {

                    }
                }
            }
        });

        cycle[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_4 == 5) c_4 = 0;
                        cycle[4].setColorFilter(rainbows[c_4]);
                        myColors[4] = rainbows[c_4];
                        c_4++;

                    } catch (Exception e) {

                    }
                }
            }
        });

        cycle[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {
                    try {
                        if (c_5 == 5) c_5 = 0;
                        cycle[5].setColorFilter(rainbows[c_5]);
                        myColors[5] = rainbows[c_5];
                        c_5++;

                    } catch (Exception e) {

                    }

                }
            }
        });

        result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (lock) {
                    time = -1;
                    endGame(cycle, TL, textTime, saveData, data);
                }
            }
        });

        if (saveData.getInt("SAVED_LIFE", -1) < 5 && saveData.getInt("SAVED_LOCKTIME", 1) == 1) {
            minusLife(TL, textTime, saveData, data);
        } else {
            data.putInt("SAVED_LOCKTIME", 0);
            data.commit();
        }

        backToPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lock) {

                    window_pause = new Dialog(Level_from41to60.this);
                    window_pause.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    window_pause.setContentView(R.layout.activity_window_pause);
                    window_pause.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    window_pause.setCancelable(false);

                    Button buttonCont = (Button) window_pause.findViewById(R.id.buttonCont);
                    buttonCont.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                window_pause.cancel();
                            } catch (Exception e) {

                            }
                        }
                    });

                    Button buttonExit = (Button) window_pause.findViewById(R.id.buttonExit);
                    buttonExit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                plusLife_Timer.cancel();
                                plusLife_Timer.purge();
                                Intent intent = new Intent(Level_from41to60.this, MainActivity.class);
                                startActivity(intent);
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

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level_from41to60.this, MainActivity.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }
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

                        textTime.setText(String.format(Locale.getDefault(), "%02d:%02d", minute, second));

                        for (int i = 1; i < 5; ++i)
                            if (minute == -1 * i) {
                                if(saveData.getInt("SAVED_LIFE", -1) + i < 5){
                                    data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) + i);
                                    data.commit();
                                    TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));
                                    minute = 0;
                                    data.putLong("SAVED_TIME", saveData.getLong("SAVED_TIME", 1) + 60 * i * 1000);
                                    data.commit();
                                }
                                else{
                                    data.putInt("SAVED_LIFE", 5);
                                    data.commit();
                                    TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));
                                    textTime.setText("");
                                    data.putInt("SAVED_LOCKTIME", 0);
                                    data.commit();
                                    cancel();
                                }
                            }

                        if (((minute == 0) && (second == 0))) {

                            data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) + 1);
                            data.commit();

                            data.putLong("SAVED_TIME", Calendar.getInstance().getTimeInMillis());
                            data.commit();

                            TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));

                            if (saveData.getInt("SAVED_LIFE", 1) >= 5) {
                                data.putInt("SAVED_LOCKTIME", 0);
                                data.commit();
                                textTime.setText("");
                                cancel();
                            }
                        }
                    }
                });
            }
        }, plusLife_delay, plusLife_period);

    }

    public void beginGame(final ImageView[] cycle, final int[] rainbows) {
        final Timer timer = new Timer();
        final long delay = 1000;
        long period = 500;

        final Random random = new Random();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                time++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int i = Integer.valueOf(random.nextInt(5));

                        if (time == 0) {
                            cycle[time].setColorFilter(rainbows[i]);
                            Colors[time] = rainbows[i];
                        }
                        if ((time > 0) && (time < 6)) {
                            cycle[time - 1].setColorFilter(null);
                            cycle[time].setColorFilter(rainbows[i]);
                            Colors[time] = rainbows[i];
                        }
                        if (time == 6) {
                            cycle[time - 1].setColorFilter(null);
                        }
                        if (time == 7) {
                            timer.cancel();
                            timer.purge();
                            lock = true;
                        }
                    }
                });
            }
        }, delay, period);
    }

    public void endGame(final ImageView[] cycle,final TextView TL, final TextView textTime, final SharedPreferences saveData, final SharedPreferences.Editor data) {

        final Timer timer = new Timer();
        final long delay = 500;
        long period = 500;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                time++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            if (Colors[time] == myColors[time])
                                cycle[time].setImageResource(R.drawable.yes);
                            else {
                                cycle[time].setImageResource(R.drawable.no);
                                minus_life = true;
                            }
                        lock = false;

                            if(time == 5){
                                timer.cancel();
                                timer.purge();
                                resultLevel(minus_life, TL, textTime,  saveData, data);
                            }
                    }
                });
            }
        }, delay, period);
    }

    public void resultLevel(boolean minus_life,final TextView TL, final TextView textTime, final SharedPreferences saveData, final SharedPreferences.Editor data){

        if (minus_life) {

            data.putInt("SAVED_LIFE", saveData.getInt("SAVED_LIFE", -1) - 1);
            data.apply();

            TL.setText(String.valueOf(saveData.getInt("SAVED_LIFE", -1)));

            if (saveData.getInt("SAVED_LOCKTIME", 0) == 0) {
                data.putInt("SAVED_LOCKTIME", 1);
                data.commit();
                data.putLong("SAVED_TIME", Calendar.getInstance().getTimeInMillis());
                data.commit();
                minusLife(TL, textTime, saveData, data);
            }

            windowOff = new Dialog(Level_from41to60.this);
            windowOff.requestWindowFeature(Window.FEATURE_NO_TITLE);
            windowOff.setContentView(R.layout.activity_window_bed);
            windowOff.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            windowOff.setCancelable(false);

            TextView btncloseOff = (TextView) windowOff.findViewById(R.id.btncloseOff);
            btncloseOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        plusLife_Timer.cancel();
                        plusLife_Timer.purge();
                        Intent intent = new Intent(Level_from41to60.this, GameMenuLevel1_20.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            });

            TextView btnReturn = (TextView) windowOff.findViewById(R.id.btnReturn);
            btnReturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        plusLife_Timer.cancel();
                        plusLife_Timer.purge();
                        Intent intent = new Intent(Level_from41to60.this, GameLoading.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            });

            windowOff.show();

        } else {
            windowOn = new Dialog(Level_from41to60.this);
            windowOn.requestWindowFeature(Window.FEATURE_NO_TITLE);
            windowOn.setContentView(R.layout.activity_window);
            windowOn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            windowOn.setCancelable(false);

            TextView btnclose = (TextView) windowOn.findViewById(R.id.btnclose);
            btnclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(Level_from41to60.this, GameMenuLevel1_20.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            });

            windowOn.show();
        }

    }
}