package kotlin.enums;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* JADX WARN: Incorrect field signature: [TE; */
/* compiled from: EnumEntries.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "", "invoke", "()[Ljava/lang/Enum;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class EnumEntriesKt$enumEntries$1 extends Lambda implements Function0<E[]> {
    final /* synthetic */ Enum[] $entries;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: ([TE;)V */
    public EnumEntriesKt$enumEntries$1(Enum[] enumArr) {
        super(0);
        this.$entries = enumArr;
    }

    /* JADX WARN: Incorrect return type in method signature: ()[TE; */
    @Override // kotlin.jvm.functions.Function0
    public final Enum[] invoke() {
        return this.$entries;
    }
}
