package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
/* loaded from: classes.dex */
public class Flag13Activity extends AppCompactActivity {
    public Flag13Activity() {
        this.name = "Flag 13 - Create a hex://open/ link";
        this.tag = "Deeplink";
        this.tagColor = R.color.pink;
        this.flag = "M6g6tRLo6pkUO4KR2Wer18bhc8UuT+IM2y9bdRICcdo/u6y9bdnmEp7f8LLuKw+1";
    }

    private boolean isDeeplink(Intent intent) {
        String action;
        return (intent == null || (action = intent.getAction()) == null || !action.equals("android.intent.action.VIEW") || !intent.getCategories().contains("android.intent.category.BROWSABLE") || intent.getStringExtra("com.android.browser.application_id") == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        if (isDeeplink(intent)) {
            Uri data = intent.getData();
            if (data.getHost().equals("flag") && data.getQueryParameter("action").equals("give-me")) {
                this.f.addTag(data.getQueryParameter("action"));
                success(this);
                return;
            } else if (!data.getHost().equals("open") || data.getQueryParameter("message") == null) {
                return;
            } else {
                Toast.makeText(this, "Website: " + data.getQueryParameter("message"), 1).show();
                return;
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("https://ht-api-mocks-lcfc4kr5oa-uc.a.run.app/android-link-builder?href=hex://open?message=Hello+World"));
        startActivity(intent2);
    }
}
