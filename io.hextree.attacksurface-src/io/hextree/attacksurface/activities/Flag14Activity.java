package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.SolvedPreferences;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag14Activity extends AppCompactActivity {
    public Flag14Activity() {
        this.name = "Flag 14 - Hijack web login";
        this.tag = "Deeplink";
        this.tagColor = R.color.pink;
        this.flag = "0iax/2Bz8vH9y4lpU6d2NJLnJfpjdLNAE9Cxd1JHHnuWseytzTwR70LTxH7bD0Pp";
        this.hideIntentDialog = true;
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
        if (intent.getAction() == null) {
            Log.i("Hextree", "browser intent");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            String uuid = UUID.randomUUID().toString();
            SolvedPreferences.putString(getPrefixKey("challenge"), uuid);
            intent2.setData(Uri.parse("https://ht-api-mocks-lcfc4kr5oa-uc.a.run.app/android-app-auth?authChallenge=" + uuid));
            startActivity(intent2);
        } else if (intent.getAction() == "android.intent.action.VIEW") {
            Uri data = intent.getData();
            String queryParameter = data.getQueryParameter("type");
            String queryParameter2 = data.getQueryParameter("authToken");
            String queryParameter3 = data.getQueryParameter("authChallenge");
            String string = SolvedPreferences.getString(getPrefixKey("challenge"));
            if (queryParameter == null || queryParameter2 == null || queryParameter3 == null || !queryParameter3.equals(string)) {
                Toast.makeText(this, "Invalid login", 1).show();
                finish();
                return;
            }
            this.f.addTag(queryParameter);
            try {
                String encodeToString = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(queryParameter2.getBytes()));
                if (encodeToString.equals("a/AR9b0XxHEX7zrjx5KNOENTqbsPi6IsX+MijDA/92w=")) {
                    if (queryParameter.equals("user")) {
                        Toast.makeText(this, "User login successful", 1).show();
                    } else if (queryParameter.equals("admin")) {
                        Log.i("Flag14", "hash: " + encodeToString);
                        this.f.addTag(queryParameter2);
                        Toast.makeText(this, "Admin login successful", 1).show();
                        success(this);
                    }
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
