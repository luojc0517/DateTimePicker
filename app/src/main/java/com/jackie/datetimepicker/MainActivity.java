package com.jackie.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private TimePicker timePicker;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day, hour, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取日历对象
        calendar = Calendar.getInstance();
        //获取日期时间
        year = calendar.get(Calendar.YEAR);
        //月份是从0开始，因此要加以1
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        //初始化日期
        datePicker.init(year, month, day, this);
        //设置监听器
        timePicker.setOnTimeChangedListener(this);


        //对话框形式的datepicker
        new DatePickerDialog(this, this, year, month, day).show();
        //对话框形式的timepicker
        new TimePickerDialog(this, this, hour, min, true).show();


    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        this.hour = hourOfDay;
        this.min = minute;
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.hour = hourOfDay;
        this.min = minute;
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min);
    }
}
