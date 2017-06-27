package com.example.xksparker.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Piotr Majewski on 2017-06-27.
 */

public class Locate extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String wiadmosc = "";
        Object[] pdus = (Object[]) bundle.get("pdus");
        msgs = new SmsMessage[pdus.length];
        for (int x = 0; x < msgs.length; x++){
            msgs[x]=SmsMessage.createFromPdu((byte[]) pdus[x]);
            wiadmosc=msgs[x].getMessageBody();
            Toast.makeText(context, wiadmosc, Toast.LENGTH_LONG).show();
        }
    }
}
