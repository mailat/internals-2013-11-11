package com.appsrise.demo14_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RebootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("14_BroadcastReceiver", "We just catched: android.intent.action.BOOT_COMPLETED");
	}

}
