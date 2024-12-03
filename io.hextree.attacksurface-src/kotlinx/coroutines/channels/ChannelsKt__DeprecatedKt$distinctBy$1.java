package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes.dex */
public final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
    final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a4 -> B:29:0x00c3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ba -> B:28:0x00bc). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        HashSet hashSet;
        ChannelIterator channelIterator;
        ProducerScope producerScope2;
        HashSet hashSet2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HashSet hashSet3 = new HashSet();
            ChannelIterator it = this.$this_distinctBy.iterator();
            producerScope = (ProducerScope) this.L$0;
            hashSet = hashSet3;
            channelIterator = it;
            this.L$0 = producerScope;
            this.L$1 = hashSet;
            this.L$2 = channelIterator;
            this.L$3 = null;
            this.label = 1;
            obj = channelIterator.hasNext(this);
            if (obj == coroutine_suspended) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
        } else if (i == 1) {
            channelIterator = (ChannelIterator) this.L$2;
            hashSet = (HashSet) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        } else if (i == 2) {
            Object obj3 = this.L$3;
            ChannelIterator channelIterator2 = (ChannelIterator) this.L$2;
            hashSet2 = (HashSet) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj3;
            channelIterator = channelIterator2;
            if (!hashSet2.contains(obj)) {
            }
            hashSet = hashSet2;
            producerScope = producerScope2;
            this.L$0 = producerScope;
            this.L$1 = hashSet;
            this.L$2 = channelIterator;
            this.L$3 = null;
            this.label = 1;
            obj = channelIterator.hasNext(this);
            if (obj == coroutine_suspended) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
        } else if (i == 3) {
            Object obj4 = this.L$3;
            ChannelIterator channelIterator3 = (ChannelIterator) this.L$2;
            hashSet2 = (HashSet) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            hashSet2.add(obj4);
            channelIterator = channelIterator3;
            hashSet = hashSet2;
            producerScope = producerScope2;
            this.L$0 = producerScope;
            this.L$1 = hashSet;
            this.L$2 = channelIterator;
            this.L$3 = null;
            this.label = 1;
            obj = channelIterator.hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function2<E, Continuation<? super K>, Object> function2 = this.$selector;
                this.L$0 = producerScope;
                this.L$1 = hashSet;
                this.L$2 = channelIterator;
                this.L$3 = next;
                this.label = 2;
                Object invoke = function2.invoke(next, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                HashSet hashSet4 = hashSet;
                obj2 = next;
                obj = invoke;
                producerScope2 = producerScope;
                hashSet2 = hashSet4;
                if (!hashSet2.contains(obj)) {
                    this.L$0 = producerScope2;
                    this.L$1 = hashSet2;
                    this.L$2 = channelIterator;
                    this.L$3 = obj;
                    this.label = 3;
                    if (producerScope2.send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelIterator3 = channelIterator;
                    obj4 = obj;
                    hashSet2.add(obj4);
                    channelIterator = channelIterator3;
                }
                hashSet = hashSet2;
                producerScope = producerScope2;
                this.L$0 = producerScope;
                this.L$1 = hashSet;
                this.L$2 = channelIterator;
                this.L$3 = null;
                this.label = 1;
                obj = channelIterator.hasNext(this);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
