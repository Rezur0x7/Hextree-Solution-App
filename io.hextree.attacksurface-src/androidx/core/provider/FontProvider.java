package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import io.hextree.attacksurface.FlagDatabaseHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new Comparator() { // from class: androidx.core.provider.FontProvider$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FontProvider.lambda$static$0((byte[]) obj, (byte[]) obj2);
        }
    };

    private FontProvider() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return FontsContractCompat.FontFamilyResult.create(1, null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, query(context, fontRequest, provider.authority, cancellationSignal));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
        List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(convertToByteArrayList, sByteArrayComparator);
        List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
        for (int i = 0; i < certificates.size(); i++) {
            ArrayList arrayList = new ArrayList(certificates.get(i));
            Collections.sort(arrayList, sByteArrayComparator);
            if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static FontsContractCompat.FontInfo[] query(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        int i;
        Uri withAppendedId;
        int i2;
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        Uri build = new Uri.Builder().scheme(FlagDatabaseHelper.COLUMN_CONTENT).authority(str).build();
        Uri build2 = new Uri.Builder().scheme(FlagDatabaseHelper.COLUMN_CONTENT).authority(str).appendPath("file").build();
        ContentQueryWrapper make = ContentQueryWrapper.make(context, build);
        Cursor cursor = null;
        try {
            boolean z2 = true;
            Cursor query = make.query(build, new String[]{FlagDatabaseHelper.COLUMN_ID, FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = query.getColumnIndex(FlagDatabaseHelper.COLUMN_ID);
                        int columnIndex3 = query.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                        int columnIndex4 = query.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                        int columnIndex5 = query.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                        int columnIndex6 = query.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                        while (query.moveToNext()) {
                            int i3 = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                            int i4 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                i = i4;
                                withAppendedId = ContentUris.withAppendedId(build, query.getLong(columnIndex2));
                            } else {
                                i = i4;
                                withAppendedId = ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            }
                            int i5 = columnIndex5 != -1 ? query.getInt(columnIndex5) : 400;
                            if (columnIndex6 == -1 || query.getInt(columnIndex6) != z2) {
                                i2 = i5;
                                z = false;
                            } else {
                                z = z2;
                                i2 = i5;
                            }
                            arrayList3.add(FontsContractCompat.FontInfo.create(withAppendedId, i, i2, z, i3));
                            z2 = true;
                        }
                        arrayList = arrayList3;
                        if (query != null) {
                            query.close();
                        }
                        make.close();
                        return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    make.close();
                    throw th;
                }
            }
            arrayList = arrayList2;
            if (query != null) {
            }
            make.close();
            return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface ContentQueryWrapper {
        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        static ContentQueryWrapper make(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }
    }

    /* loaded from: classes.dex */
    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }
}
