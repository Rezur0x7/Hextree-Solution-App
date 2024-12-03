package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
/* loaded from: classes.dex */
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0054). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f8 -> B:10:0x0023). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        ChannelIterator it2;
        ProducerScope producerScope3;
        ChannelIterator channelIterator;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.$this_dropWhile.iterator();
            producerScope = (ProducerScope) this.L$0;
            this.L$0 = producerScope;
            this.L$1 = it;
            this.L$2 = null;
            this.label = 1;
            obj = it.hasNext(this);
            if (obj == coroutine_suspended) {
            }
            ProducerScope producerScope4 = producerScope;
            ChannelIterator channelIterator2 = it;
            producerScope2 = producerScope4;
            if (((Boolean) obj).booleanValue()) {
            }
            it2 = this.$this_dropWhile.iterator();
            this.L$0 = producerScope2;
            this.L$1 = it2;
            this.label = 4;
            hasNext = it2.hasNext(this);
            if (hasNext == coroutine_suspended) {
            }
        } else if (i == 1) {
            it = (ChannelIterator) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope42 = producerScope;
            ChannelIterator channelIterator22 = it;
            producerScope2 = producerScope42;
            if (((Boolean) obj).booleanValue()) {
            }
            it2 = this.$this_dropWhile.iterator();
            this.L$0 = producerScope2;
            this.L$1 = it2;
            this.label = 4;
            hasNext = it2.hasNext(this);
            if (hasNext == coroutine_suspended) {
            }
        } else if (i == 2) {
            Object obj2 = this.L$2;
            ProducerScope producerScope5 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            ChannelIterator channelIterator3 = (ChannelIterator) this.L$1;
            Object obj3 = obj2;
            it = channelIterator3;
            if (((Boolean) obj).booleanValue()) {
                this.L$0 = producerScope5;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
                if (producerScope5.send(obj3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                producerScope2 = producerScope5;
                it2 = this.$this_dropWhile.iterator();
                this.L$0 = producerScope2;
                this.L$1 = it2;
                this.label = 4;
                hasNext = it2.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            } else {
                producerScope = producerScope5;
                this.L$0 = producerScope;
                this.L$1 = it;
                this.L$2 = null;
                this.label = 1;
                obj = it.hasNext(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ProducerScope producerScope422 = producerScope;
                ChannelIterator channelIterator222 = it;
                producerScope2 = producerScope422;
                if (((Boolean) obj).booleanValue()) {
                    Object next = channelIterator222.next();
                    Function2<E, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    this.L$0 = producerScope2;
                    this.L$1 = channelIterator222;
                    this.L$2 = next;
                    this.label = 2;
                    Object invoke = function2.invoke(next, this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelIterator3 = channelIterator222;
                    obj3 = next;
                    obj = invoke;
                    producerScope5 = producerScope2;
                    it = channelIterator3;
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
                it2 = this.$this_dropWhile.iterator();
                this.L$0 = producerScope2;
                this.L$1 = it2;
                this.label = 4;
                hasNext = it2.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            }
        } else if (i == 3) {
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            it2 = this.$this_dropWhile.iterator();
            this.L$0 = producerScope2;
            this.L$1 = it2;
            this.label = 4;
            hasNext = it2.hasNext(this);
            if (hasNext == coroutine_suspended) {
            }
        } else if (i == 4) {
            channelIterator = (ChannelIterator) this.L$1;
            producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (!((Boolean) obj).booleanValue()) {
            }
        } else if (i != 5) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            channelIterator = (ChannelIterator) this.L$1;
            producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            it2 = channelIterator;
            producerScope2 = producerScope3;
            this.L$0 = producerScope2;
            this.L$1 = it2;
            this.label = 4;
            hasNext = it2.hasNext(this);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            ProducerScope producerScope6 = producerScope2;
            channelIterator = it2;
            obj = hasNext;
            producerScope3 = producerScope6;
            if (!((Boolean) obj).booleanValue()) {
                this.L$0 = producerScope3;
                this.L$1 = channelIterator;
                this.label = 5;
                if (producerScope3.send(channelIterator.next(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it2 = channelIterator;
                producerScope2 = producerScope3;
                this.L$0 = producerScope2;
                this.L$1 = it2;
                this.label = 4;
                hasNext = it2.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
