package chronometer.kishor.chronemeter;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=(Chronometer)findViewById(R.id.chronometer2);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        calendarView=(CalendarView)findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2)
            {
                Toast.makeText(getApplicationContext(),i2+"/"+(i1+1)+"/"+i,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
