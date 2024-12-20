package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.hextree.attacksurface.FlagDatabaseHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", FlagDatabaseHelper.COLUMN_VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private volatile /* synthetic */ Object _state;
    private int sequence;

    public static /* synthetic */ void getValue$annotations() {
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = (T) NullSurrogateKt.NULL;
        }
        return updateState(t, t2);
    }

    private final boolean updateState(Object obj, Object obj2) {
        int i;
        StateFlowSlot[] slots;
        getSlots();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !Intrinsics.areEqual(obj3, obj)) {
                return false;
            }
            if (Intrinsics.areEqual(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i2 = this.sequence;
            if ((i2 & 1) == 0) {
                int i3 = i2 + 1;
                this.sequence = i3;
                StateFlowSlot[] slots2 = getSlots();
                Unit unit = Unit.INSTANCE;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = slots2;
                    if (stateFlowSlotArr != null) {
                        for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                            if (stateFlowSlot != null) {
                                stateFlowSlot.makePending();
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.sequence;
                        if (i == i3) {
                            this.sequence = i3 + 1;
                            return true;
                        }
                        slots = getSlots();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    slots2 = slots;
                    i3 = i;
                }
            } else {
                this.sequence = i2 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b7, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r12, r7) == false) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:33:0x00aa, B:35:0x00ae, B:37:0x00b3, B:48:0x00d8, B:50:0x00de, B:39:0x00b9, B:43:0x00c0, B:24:0x0075, B:32:0x0099, B:27:0x0083, B:29:0x0087), top: B:57:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:33:0x00aa, B:35:0x00ae, B:37:0x00b3, B:48:0x00d8, B:50:0x00de, B:39:0x00b9, B:43:0x00c0, B:24:0x0075, B:32:0x0099, B:27:0x0083, B:29:0x0087), top: B:57:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #0 {all -> 0x00f1, blocks: (B:33:0x00aa, B:35:0x00ae, B:37:0x00b3, B:48:0x00d8, B:50:0x00de, B:39:0x00b9, B:43:0x00c0, B:24:0x0075, B:32:0x0099, B:27:0x0083, B:29:0x0087), top: B:57:0x0025 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dc -> B:33:0x00aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ee -> B:33:0x00aa). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object coroutine_suspended;
        ?? r2;
        StateFlowImpl<T> stateFlowImpl;
        Throwable th;
        Job job;
        Object obj;
        StateFlowImpl<T> stateFlowImpl2;
        FlowCollector<? super T> flowCollector2;
        StateFlowSlot stateFlowSlot;
        Object obj2;
        FlowCollector<? super T> flowCollector3;
        StateFlowSlot stateFlowSlot2;
        boolean takePending;
        FlowCollector flowCollector4;
        Object obj3;
        StateFlowSlot stateFlowSlot3;
        try {
            if (continuation instanceof StateFlowImpl$collect$1) {
                stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
                if ((stateFlowImpl$collect$1.label & Integer.MIN_VALUE) != 0) {
                    stateFlowImpl$collect$1.label -= Integer.MIN_VALUE;
                    Object obj4 = stateFlowImpl$collect$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = stateFlowImpl$collect$1.label;
                    if (r2 != 0) {
                        ResultKt.throwOnFailure(obj4);
                        StateFlowSlot allocateSlot = allocateSlot();
                        stateFlowSlot3 = allocateSlot;
                        if (flowCollector instanceof SubscribedFlowCollector) {
                            stateFlowImpl$collect$1.L$0 = this;
                            stateFlowImpl$collect$1.L$1 = flowCollector;
                            stateFlowImpl$collect$1.L$2 = allocateSlot;
                            stateFlowImpl$collect$1.label = 1;
                            stateFlowSlot3 = allocateSlot;
                            if (((SubscribedFlowCollector) flowCollector).onSubscription(stateFlowImpl$collect$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else if (r2 != 1) {
                        try {
                            if (r2 == 2) {
                                obj = stateFlowImpl$collect$1.L$4;
                                job = (Job) stateFlowImpl$collect$1.L$3;
                                StateFlowSlot stateFlowSlot4 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                                FlowCollector<? super T> flowCollector5 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                                stateFlowImpl2 = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                                ResultKt.throwOnFailure(obj4);
                                stateFlowSlot = stateFlowSlot4;
                                flowCollector2 = flowCollector5;
                                obj2 = obj;
                                this = stateFlowImpl2;
                                stateFlowSlot2 = stateFlowSlot;
                                flowCollector3 = flowCollector2;
                                takePending = stateFlowSlot2.takePending();
                                r2 = stateFlowSlot2;
                                flowCollector4 = flowCollector3;
                                if (!takePending) {
                                }
                                Object obj5 = this._state;
                                if (job != null) {
                                }
                                if (obj2 != null) {
                                }
                                if (obj5 == NullSurrogateKt.NULL) {
                                }
                                stateFlowImpl$collect$1.L$0 = this;
                                stateFlowImpl$collect$1.L$1 = flowCollector4;
                                stateFlowImpl$collect$1.L$2 = r2;
                                stateFlowImpl$collect$1.L$3 = job;
                                stateFlowImpl$collect$1.L$4 = obj5;
                                stateFlowImpl$collect$1.label = 2;
                                if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                                }
                            } else if (r2 == 3) {
                                Object obj6 = stateFlowImpl$collect$1.L$4;
                                job = (Job) stateFlowImpl$collect$1.L$3;
                                StateFlowSlot stateFlowSlot5 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                                FlowCollector flowCollector6 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                                StateFlowImpl<T> stateFlowImpl3 = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                                ResultKt.throwOnFailure(obj4);
                                obj2 = obj6;
                                this = stateFlowImpl3;
                                r2 = stateFlowSlot5;
                                flowCollector4 = flowCollector6;
                                Object obj52 = this._state;
                                if (job != null) {
                                    JobKt.ensureActive(job);
                                }
                                if (obj2 != null) {
                                    stateFlowSlot2 = r2;
                                    flowCollector3 = flowCollector4;
                                }
                                obj3 = obj52 == NullSurrogateKt.NULL ? null : obj52;
                                stateFlowImpl$collect$1.L$0 = this;
                                stateFlowImpl$collect$1.L$1 = flowCollector4;
                                stateFlowImpl$collect$1.L$2 = r2;
                                stateFlowImpl$collect$1.L$3 = job;
                                stateFlowImpl$collect$1.L$4 = obj52;
                                stateFlowImpl$collect$1.label = 2;
                                if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                stateFlowImpl2 = this;
                                obj = obj52;
                                stateFlowSlot = r2;
                                flowCollector2 = flowCollector4;
                                obj2 = obj;
                                this = stateFlowImpl2;
                                stateFlowSlot2 = stateFlowSlot;
                                flowCollector3 = flowCollector2;
                                takePending = stateFlowSlot2.takePending();
                                r2 = stateFlowSlot2;
                                flowCollector4 = flowCollector3;
                                if (!takePending) {
                                    stateFlowImpl$collect$1.L$0 = this;
                                    stateFlowImpl$collect$1.L$1 = flowCollector3;
                                    stateFlowImpl$collect$1.L$2 = stateFlowSlot2;
                                    stateFlowImpl$collect$1.L$3 = job;
                                    stateFlowImpl$collect$1.L$4 = obj2;
                                    stateFlowImpl$collect$1.label = 3;
                                    Object awaitPending = stateFlowSlot2.awaitPending(stateFlowImpl$collect$1);
                                    r2 = stateFlowSlot2;
                                    flowCollector4 = flowCollector3;
                                    if (awaitPending == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                Object obj522 = this._state;
                                if (job != null) {
                                }
                                if (obj2 != null) {
                                }
                                if (obj522 == NullSurrogateKt.NULL) {
                                }
                                stateFlowImpl$collect$1.L$0 = this;
                                stateFlowImpl$collect$1.L$1 = flowCollector4;
                                stateFlowImpl$collect$1.L$2 = r2;
                                stateFlowImpl$collect$1.L$3 = job;
                                stateFlowImpl$collect$1.L$4 = obj522;
                                stateFlowImpl$collect$1.label = 2;
                                if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            stateFlowImpl.freeSlot((AbstractSharedFlowSlot) r2);
                            throw th;
                        }
                    } else {
                        StateFlowSlot stateFlowSlot6 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                        flowCollector = (FlowCollector) stateFlowImpl$collect$1.L$1;
                        this = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        stateFlowSlot3 = stateFlowSlot6;
                    }
                    flowCollector4 = flowCollector;
                    job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
                    obj2 = null;
                    r2 = stateFlowSlot3;
                    Object obj5222 = this._state;
                    if (job != null) {
                    }
                    if (obj2 != null) {
                    }
                    if (obj5222 == NullSurrogateKt.NULL) {
                    }
                    stateFlowImpl$collect$1.L$0 = this;
                    stateFlowImpl$collect$1.L$1 = flowCollector4;
                    stateFlowImpl$collect$1.L$2 = r2;
                    stateFlowImpl$collect$1.L$3 = job;
                    stateFlowImpl$collect$1.L$4 = obj5222;
                    stateFlowImpl$collect$1.label = 2;
                    if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                    }
                }
            }
            if (r2 != 0) {
            }
            flowCollector4 = flowCollector;
            job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
            obj2 = null;
            r2 = stateFlowSlot3;
            Object obj52222 = this._state;
            if (job != null) {
            }
            if (obj2 != null) {
            }
            if (obj52222 == NullSurrogateKt.NULL) {
            }
            stateFlowImpl$collect$1.L$0 = this;
            stateFlowImpl$collect$1.L$1 = flowCollector4;
            stateFlowImpl$collect$1.L$2 = r2;
            stateFlowImpl$collect$1.L$3 = job;
            stateFlowImpl$collect$1.L$4 = obj52222;
            stateFlowImpl$collect$1.label = 2;
            if (flowCollector4.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
            }
        } catch (Throwable th3) {
            stateFlowImpl = this;
            th = th3;
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj42 = stateFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = stateFlowImpl$collect$1.label;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int i) {
        return new StateFlowSlot[i];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }
}
