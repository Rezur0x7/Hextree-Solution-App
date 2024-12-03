package io.hextree.attacksurface;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class AppCompactActivity extends AppCompatActivity {
    Dialog d1;
    Dialog d2;
    public LogHelper f;
    public String name = "Name";
    public String description = getClass().getCanonicalName();
    public final String NO_FLAG = "conditions not met for flag";
    public String flag_out = "conditions not met for flag";
    public final String ACTIVITY = "Activity";
    public final String ACTIVITY_RESULT = "ActivityResult";
    public final String IMPLICIT_INTENT = "ImplicitIntent";
    public final String DEEPLINK = "Deeplink";
    public final String BROADCAST_RECEIVER = "BroadcastReceiver";
    public String tag = "Activity";
    public int tagColor = R.color.yellow;
    public boolean hideIntentDialog = false;
    public String flag = "";
    public boolean allowOpenActivity = false;

    public boolean isSolved() {
        return SolvedPreferences.getBoolean(getPrefixKey("solved"), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getPrefixKey(String str) {
        return getClass().getSimpleName() + ":" + str;
    }

    public void clickOnListItem(Context context) {
        if (isSolved() || this.tag.equals("ImplicitIntent") || this.tag.equals("Deeplink") || this.tag.equals("BroadcastReceiver") || this.allowOpenActivity) {
            Intent intent = new Intent(context, getClass());
            intent.putExtra("hideIntent", true);
            context.startActivity(intent);
        } else if (this.tag.equals("Activity") || this.tag.equals("ActivityResult")) {
            Toast.makeText(context, "Call this activity and match the condition to get " + this.name, 1).show();
        } else {
            Toast.makeText(context, "Interact with this class correctly to get " + this.name, 1).show();
        }
    }

    protected void refreshUI() {
        if (isSolved()) {
            Log.i("Hextree", "refreshUI() isSolved");
            setTheme(R.style.Flag_Solved_Theme_IntentAttackSurfaceActivity);
        } else {
            Log.i("Hextree", "refreshUI()");
            setTheme(R.style.Flag_NotSolved_Theme_IntentAttackSurfaceActivity);
        }
        setContentView(R.layout.activity_flag);
    }

    protected boolean updateText() {
        Log.i("Hextree", "updateText()");
        ((TextView) findViewById(R.id.txt_name)).setText(this.name);
        ((TextView) findViewById(R.id.txt_description)).setText(this.description);
        ((Button) findViewById(R.id.btn_done)).setOnClickListener(new View.OnClickListener() { // from class: io.hextree.attacksurface.AppCompactActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("Hextree", "Done/finish button pressed");
                AppCompactActivity.this.finish();
            }
        });
        if (isSolved() && this.flag_out.equals("conditions not met for flag")) {
            ((TextView) findViewById(R.id.txt_flag)).setText("already solved, but the flag is only shown when conditions are met");
            return false;
        }
        ((TextView) findViewById(R.id.txt_flag)).setText(this.flag_out);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SolvedPreferences.initialize(this);
        refreshUI();
        super.onCreate(bundle);
        updateText();
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_flag), new OnApplyWindowInsetsListener() { // from class: io.hextree.attacksurface.AppCompactActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppCompactActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
        if (getIntent().getBooleanExtra("hideIntent", false) || this.tag.equals("BroadcastReceiver")) {
            return;
        }
        this.d1 = Utils.showIntentDialog(this, "Activity.getIntent()", getIntent(), this.hideIntentDialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    protected boolean alreadyLogged() {
        return ((TextView) findViewById(R.id.txt_flag)).getText().toString().startsWith("HXT");
    }

    public void checkStatus(Activity activity) {
        success(activity);
    }

    public void success(Activity activity) {
        Log.i("Hextree", "success()");
        try {
            Method method = this.f.getClass().getMethod("appendLog", String.class);
            Log.i("method.invoke", "flag: " + this.flag);
            String str = (String) method.invoke(this.f, this.flag);
            this.flag_out = str;
            if (str != null) {
                boolean z = SolvedPreferences.getBoolean(getPrefixKey("solved"), false);
                SolvedPreferences.putBoolean(getPrefixKey("solved"), true);
                if (activity != null && !z) {
                    refreshUI();
                }
                if (activity != null) {
                    updateText();
                    Toast.makeText(this, this.flag_out, 1).show();
                }
                Log.i(FlagDatabaseHelper.TABLE_FLAG, this.flag_out);
                return;
            }
            Toast.makeText(this, "Error decrypting flag. Invalid flag condition?", 1).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(FlagDatabaseHelper.TABLE_FLAG, "Exception decrypting flag");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || intent.getBooleanExtra("hideIntent", false)) {
            return;
        }
        this.d2 = Utils.showIntentDialog(this, "onActivityResult.intent", intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || intent.getBooleanExtra("hideIntent", false)) {
            return;
        }
        this.d2 = Utils.showIntentDialog(this, "onNewIntent.intent", intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Dialog dialog = this.d1;
        if (dialog != null && dialog.isShowing()) {
            this.d1.dismiss();
        }
        Dialog dialog2 = this.d2;
        if (dialog2 != null && dialog2.isShowing()) {
            this.d2.dismiss();
        }
        super.onDestroy();
    }
}
