package io.hextree.attacksurface;

import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class LogHelper {
    private static final String ALGORITHM = "AES";
    private List<String> tags = new ArrayList();

    public LogHelper(Context context) {
        try {
            Class<?> cls = Class.forName("android.content.res.Resources");
            Object invoke = Context.class.getMethod("getResources", new Class[0]).invoke(context, new Object[0]);
            this.tags.add((String) cls.getMethod("getString", Integer.TYPE).invoke(invoke, Integer.valueOf(((Integer) Class.forName(context.getPackageName() + ".R$string").getField("secret").get(null)).intValue())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tags.add(context.getPackageName());
        this.tags.add(getClass().getCanonicalName());
    }

    public String appendLog(String str) {
        return append(str, getPrefix());
    }

    public String rotateLog(String str) {
        return rotate(str, getPrefix());
    }

    public void addTag(Object obj) {
        this.tags.add(obj.toString());
    }

    private SecretKeySpec getPrefix() {
        try {
            Collections.sort(this.tags);
            StringBuilder sb = new StringBuilder();
            for (String str : this.tags) {
                sb.append(str);
                sb.append("|");
            }
            return new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(sb.toString().getBytes(StandardCharsets.UTF_8)), 0, 16, ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate key from secrets.", e);
        }
    }

    private String rotate(String str, SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, secretKeySpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String append(String str, SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(str)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
