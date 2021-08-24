package com.ds.dsloglibrary;

import android.content.Context;
import android.widget.Toast;

public class DSLogsUtil {

    public static void dsToasty(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
