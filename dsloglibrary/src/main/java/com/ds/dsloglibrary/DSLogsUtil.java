package com.ds.dsloglibrary;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DSLogsUtil {

    public static void dsToasty(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean isValidEmail(String text) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static List<String> getSegmanetOfDate(String date, String inputDateFormat) {
        List<String> datePart = new ArrayList();
        Date dateOfDay= null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(inputDateFormat);
            dateOfDay = sdf.parse(date);
        } catch(Exception e) {
            e.printStackTrace();
            return datePart;
        }

        Calendar born = Calendar.getInstance();
        if(dateOfDay != null) {
            born.setTime(dateOfDay);
            String month = new DateFormatSymbols().getShortMonths()[born.get(Calendar.MONTH)];
            datePart.add(born.get(Calendar.DAY_OF_MONTH)+"");
            datePart.add(month+"");
            datePart.add(born.get(Calendar.YEAR)+"");
        }
        return datePart;
    }


    public static boolean isPastDate(String userDateStr,String inputDateFormat) {
        boolean setDatebooleanValue = false;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(inputDateFormat);
            String currDateStr = getCurrentDate(inputDateFormat);
            Date currDate = formatter.parse(currDateStr);
            Date userDate = formatter.parse(userDateStr);
            int compareValue = userDate.compareTo(currDate);

            if (compareValue < 0) {
                setDatebooleanValue = true;
            } else {
                setDatebooleanValue = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setDatebooleanValue;
    }

    public static String getCurrentDate(String inputDateFormat) {
        final Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputDateFormat);
        return simpleDateFormat.format(c.getTime());
    }



    public static String getCurrentDateDDMMMYYYY(String inputDateFormat) {
        final Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputDateFormat);
        return simpleDateFormat.format(c.getTime());
    }

    public static void hideKeyboard(Activity ctx) {

        if(ctx.getCurrentFocus() != null && ctx.getCurrentFocus() instanceof EditText){
            InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(ctx.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }
}
