package com.pansoft.monitor.utils;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/**
 * Created by meijun on 17-7-8.
 */

public class IntentUtils {

    /**
     * 前往开启辅助服务界面
     */
    public static void goAccess(Context context) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
