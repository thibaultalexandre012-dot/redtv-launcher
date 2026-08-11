package com.thibault.redtvlauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TARGET_PACKAGE = "com.sfr.android.redtv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PackageManager pm = getPackageManager();
        Intent launchIntent = pm.getLeanbackLaunchIntentForPackage(TARGET_PACKAGE);
        if (launchIntent == null) {
            launchIntent = pm.getLaunchIntentForPackage(TARGET_PACKAGE);
        }

        if (launchIntent != null) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "RED TV introuvable", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
