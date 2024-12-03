package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
/* loaded from: classes.dex */
public class Flag15Activity extends AppCompactActivity {
    public Flag15Activity() {
        this.name = "Flag 15 - Create a intent://flag15/ link";
        this.tag = "Deeplink";
        this.tagColor = R.color.pink;
        this.flag = "Dd9YjTMVuPv+aFFNmgdp4lZSlsia2NPmYxH9Z5cBuOQ=";
    }

    private boolean isDeeplink(Intent intent) {
        return (intent == null || intent.getAction() == null || !intent.getCategories().contains("android.intent.category.BROWSABLE") || intent.getStringExtra("com.android.browser.application_id") == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://ht-api-mocks-lcfc4kr5oa-uc.a.run.app/android-link-builder?href=" + Uri.encode("intent:#Intent;...")));
            startActivity(intent2);
        } else if (isDeeplink(intent) && action.equals("io.hextree.action.GIVE_FLAG")) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                finish();
            }
            String string = extras.getString("action", "open");
            if (extras.getBoolean("flag", false) && string.equals("flag")) {
                this.f.addTag(Boolean.valueOf(extras.getBoolean("flag", false)));
                this.f.addTag(string);
                success(this);
            } else if (string.equals("open")) {
                Toast.makeText(this, "Website: " + extras.getString("message", "open"), 1).show();
            }
        }
    }
}
