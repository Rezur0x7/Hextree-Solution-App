package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {114, 121, 128}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u2d2", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i;
        Object invokeSafely$FlowKt__EmittersKt;
        FlowCollector flowCollector2;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        Object invoke;
        try {
            try {
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label -= Integer.MIN_VALUE;
                        Object obj = anonymousClass1.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = anonymousClass1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            Flow flow = this.$this_onCompletion$inlined;
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = flowCollector;
                            anonymousClass1.label = 1;
                            Object collect = flow.collect(flowCollector, anonymousClass1);
                            flowCollector2 = flowCollector;
                            if (collect == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            if (i == 2) {
                                Throwable th = (Throwable) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj);
                                throw th;
                            } else if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                safeCollector2 = (SafeCollector) anonymousClass1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    safeCollector2.releaseIntercepted();
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                    safeCollector2.releaseIntercepted();
                                    throw th;
                                }
                            }
                        } else {
                            FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                            this = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                            flowCollector2 = flowCollector3;
                        }
                        safeCollector = new SafeCollector(flowCollector2, anonymousClass1.getContext());
                        Function3 function3 = this.$action$inlined;
                        anonymousClass1.L$0 = safeCollector;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.label = 3;
                        InlineMarker.mark(6);
                        invoke = function3.invoke(safeCollector, null, anonymousClass1);
                        InlineMarker.mark(7);
                        if (invoke != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector2 = safeCollector;
                        safeCollector2.releaseIntercepted();
                        return Unit.INSTANCE;
                    }
                }
                Function3 function32 = this.$action$inlined;
                anonymousClass1.L$0 = safeCollector;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                InlineMarker.mark(6);
                invoke = function32.invoke(safeCollector, null, anonymousClass1);
                InlineMarker.mark(7);
                if (invoke != coroutine_suspended) {
                }
            } catch (Throwable th3) {
                th = th3;
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                throw th;
            }
            if (i != 0) {
            }
            safeCollector = new SafeCollector(flowCollector2, anonymousClass1.getContext());
        } catch (Throwable th4) {
            Function3 function33 = this.$action$inlined;
            anonymousClass1.L$0 = th4;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new ThrowingCollector(th4), function33, th4, anonymousClass1);
            if (invokeSafely$FlowKt__EmittersKt == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th4;
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }
}
