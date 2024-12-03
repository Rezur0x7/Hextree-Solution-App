package io.hextree.attacksurface;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SolvedPreferences.initialize(this);
        Flag36Preferences.initialize(this);
        initApp(this);
        ((LinearLayout) findViewById(R.id.hextree_logo)).setOnClickListener(new View.OnClickListener() { // from class: io.hextree.attacksurface.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://app.hextree.io/map/android"));
                MainActivity.this.startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() { // from class: io.hextree.attacksurface.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    private void initApp(Context context) {
        if (!Flag36Preferences.getBoolean("solved", false)) {
            Flag36Preferences.putBoolean("solved", false);
        }
        Utils.writeFile(this, "flags/flag34.txt", "HXT{censored}");
        Utils.writeFile(this, "secret.txt", "This is 'secret.txt'.\nTry to read the flag .txt files instead.");
        Utils.writeFile2(this, "flag35.txt", "HXT{censored}");
        if (checkSelfPermission("android.permission.READ_CONTACTS") == 0 || checkSelfPermission("android.permission.WRITE_CONTACTS") == 0) {
            return;
        }
        requestPermissions(new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"}, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
