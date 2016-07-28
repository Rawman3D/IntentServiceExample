package com.example.kabinkale.serviceintenttest;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;

/**
 * Created by Kabin Kale on 7/28/2016.
 */

/**
 * This class is an intent service class that does work one by one after queuing it.
 */
public class SimpleIntentService extends IntentService {
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";

    public SimpleIntentService() {
        super(MainActivity.class.getSimpleName());
    }
    public SimpleIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String msg = intent.getStringExtra(PARAM_IN_MSG);

        SystemClock.sleep(1000);
        String resultText = (msg + " " + DateFormat.format("MM/dd/yy h:mm:ssaa", System.currentTimeMillis()));

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        broadcastIntent.putExtra(PARAM_OUT_MSG, resultText);
        sendBroadcast(broadcastIntent);
    }
}
