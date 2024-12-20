package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r2.mVerticalChainStyle == 2) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x03de A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<ConstraintWidget> arrayList;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintWidget constraintWidget2;
        int i3;
        ConstraintWidget constraintWidget3;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor constraintAnchor5;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable3;
        ConstraintWidget constraintWidget6;
        ConstraintWidget constraintWidget7;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        float f;
        int size;
        int i4;
        ArrayList<ConstraintWidget> arrayList2;
        int i5;
        boolean z4;
        ConstraintWidget constraintWidget8;
        ConstraintWidget constraintWidget9;
        int i6;
        int i7 = i;
        ConstraintWidget constraintWidget10 = chainHead.mFirst;
        ConstraintWidget constraintWidget11 = chainHead.mLast;
        ConstraintWidget constraintWidget12 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget13 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget14 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget15 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget16 = chainHead.mLastMatchConstraintWidget;
        boolean z5 = constraintWidgetContainer.mListDimensionBehaviors[i7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i7 == 0) {
            z = constraintWidget14.mHorizontalChainStyle == 0;
            z2 = constraintWidget14.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget14.mVerticalChainStyle == 0;
            z2 = constraintWidget14.mVerticalChainStyle == 1;
        }
        boolean z6 = z2;
        boolean z7 = false;
        boolean z8 = z;
        ConstraintWidget constraintWidget17 = constraintWidget10;
        while (true) {
            if (z7) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget17.mListAnchors[i2];
            int i8 = z3 ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            float f3 = f2;
            boolean z9 = z7;
            boolean z10 = constraintWidget17.mListDimensionBehaviors[i7] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget17.mResolvedMatchConstraintDefault[i7] == 0;
            if (constraintAnchor6.mTarget != null && constraintWidget17 != constraintWidget10) {
                margin += constraintAnchor6.mTarget.getMargin();
            }
            int i9 = margin;
            if (!z3 || constraintWidget17 == constraintWidget10 || constraintWidget17 == constraintWidget12) {
                z4 = z8;
            } else {
                z4 = z8;
                i8 = 8;
            }
            if (constraintAnchor6.mTarget != null) {
                if (constraintWidget17 == constraintWidget12) {
                    constraintWidget8 = constraintWidget14;
                    constraintWidget9 = constraintWidget10;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, 6);
                } else {
                    constraintWidget8 = constraintWidget14;
                    constraintWidget9 = constraintWidget10;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, 8);
                }
                if (z10 && !z3) {
                    i8 = 5;
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, (constraintWidget17 == constraintWidget12 && z3 && constraintWidget17.isInBarrier(i7)) ? 5 : i8);
            } else {
                constraintWidget8 = constraintWidget14;
                constraintWidget9 = constraintWidget10;
            }
            if (z5) {
                if (constraintWidget17.getVisibility() == 8 || constraintWidget17.mListDimensionBehaviors[i7] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i6 = 0;
                } else {
                    i6 = 0;
                    linearSystem.addGreaterThan(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget17.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i6, 8);
            }
            ConstraintAnchor constraintAnchor7 = constraintWidget17.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget18 = constraintAnchor7.mOwner;
                if (constraintWidget18.mListAnchors[i2].mTarget != null && constraintWidget18.mListAnchors[i2].mTarget.mOwner == constraintWidget17) {
                    r22 = constraintWidget18;
                }
            }
            if (r22 != null) {
                constraintWidget17 = r22;
                z7 = z9;
            } else {
                z7 = true;
            }
            z8 = z4;
            f2 = f3;
            constraintWidget14 = constraintWidget8;
            constraintWidget10 = constraintWidget9;
        }
        ConstraintWidget constraintWidget19 = constraintWidget14;
        float f4 = f2;
        ConstraintWidget constraintWidget20 = constraintWidget10;
        boolean z11 = z8;
        if (constraintWidget13 != null) {
            int i10 = i2 + 1;
            if (constraintWidget11.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget13.mListAnchors[i10];
                if (constraintWidget13.mListDimensionBehaviors[i7] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget13.mResolvedMatchConstraintDefault[i7] == 0 && !z3 && constraintAnchor8.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                } else if (z3 && constraintAnchor8.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                }
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget11.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                if (z5) {
                    int i11 = i2 + 1;
                    linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i11].mSolverVariable, constraintWidget11.mListAnchors[i11].mSolverVariable, constraintWidget11.mListAnchors[i11].getMargin(), 8);
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null && (size = arrayList.size()) > 1) {
                    float f5 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
                    float f6 = 0.0f;
                    float f7 = 0.0f;
                    ConstraintWidget constraintWidget21 = null;
                    i4 = 0;
                    while (i4 < size) {
                        ConstraintWidget constraintWidget22 = arrayList.get(i4);
                        float f8 = constraintWidget22.mWeight[i7];
                        if (f8 < f6) {
                            if (chainHead.mHasComplexMatchWeights) {
                                linearSystem.addEquality(constraintWidget22.mListAnchors[i2 + 1].mSolverVariable, constraintWidget22.mListAnchors[i2].mSolverVariable, 0, 4);
                                arrayList2 = arrayList;
                                i5 = size;
                                i4++;
                                size = i5;
                                arrayList = arrayList2;
                                f6 = 0.0f;
                            } else {
                                f8 = 1.0f;
                                f6 = 0.0f;
                            }
                        }
                        if (f8 == f6) {
                            linearSystem.addEquality(constraintWidget22.mListAnchors[i2 + 1].mSolverVariable, constraintWidget22.mListAnchors[i2].mSolverVariable, 0, 8);
                            arrayList2 = arrayList;
                            i5 = size;
                            i4++;
                            size = i5;
                            arrayList = arrayList2;
                            f6 = 0.0f;
                        } else {
                            if (constraintWidget21 != null) {
                                SolverVariable solverVariable6 = constraintWidget21.mListAnchors[i2].mSolverVariable;
                                int i12 = i2 + 1;
                                SolverVariable solverVariable7 = constraintWidget21.mListAnchors[i12].mSolverVariable;
                                SolverVariable solverVariable8 = constraintWidget22.mListAnchors[i2].mSolverVariable;
                                arrayList2 = arrayList;
                                SolverVariable solverVariable9 = constraintWidget22.mListAnchors[i12].mSolverVariable;
                                i5 = size;
                                ArrayRow createRow = linearSystem.createRow();
                                createRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                                linearSystem.addConstraint(createRow);
                            } else {
                                arrayList2 = arrayList;
                                i5 = size;
                            }
                            f7 = f8;
                            constraintWidget21 = constraintWidget22;
                            i4++;
                            size = i5;
                            arrayList = arrayList2;
                            f6 = 0.0f;
                        }
                    }
                }
                if (constraintWidget12 == null && (constraintWidget12 == constraintWidget13 || z3)) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget20.mListAnchors[i2];
                    int i13 = i2 + 1;
                    ConstraintAnchor constraintAnchor10 = constraintWidget11.mListAnchors[i13];
                    SolverVariable solverVariable10 = constraintAnchor9.mTarget != null ? constraintAnchor9.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable11 = constraintAnchor10.mTarget != null ? constraintAnchor10.mTarget.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor11 = constraintWidget12.mListAnchors[i2];
                    if (constraintWidget13 != null) {
                        constraintAnchor10 = constraintWidget13.mListAnchors[i13];
                    }
                    if (solverVariable10 != null && solverVariable11 != null) {
                        if (i7 == 0) {
                            f = constraintWidget19.mHorizontalBiasPercent;
                        } else {
                            f = constraintWidget19.mVerticalBiasPercent;
                        }
                        linearSystem.addCentering(constraintAnchor11.mSolverVariable, solverVariable10, constraintAnchor11.getMargin(), f, solverVariable11, constraintAnchor10.mSolverVariable, constraintAnchor10.getMargin(), 7);
                    }
                } else if (z11 || constraintWidget12 == null) {
                    int i14 = 8;
                    if (z6 && constraintWidget12 != null) {
                        boolean z12 = chainHead.mWidgetsMatchCount <= 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                        ConstraintWidget constraintWidget23 = constraintWidget12;
                        constraintWidget = constraintWidget23;
                        while (constraintWidget != null) {
                            ConstraintWidget constraintWidget24 = constraintWidget.mNextChainWidget[i7];
                            while (constraintWidget24 != null && constraintWidget24.getVisibility() == i14) {
                                constraintWidget24 = constraintWidget24.mNextChainWidget[i7];
                            }
                            if (constraintWidget == constraintWidget12 || constraintWidget == constraintWidget13 || constraintWidget24 == null) {
                                constraintWidget2 = constraintWidget23;
                                i3 = i14;
                            } else {
                                ConstraintWidget constraintWidget25 = constraintWidget24 == constraintWidget13 ? null : constraintWidget24;
                                ConstraintAnchor constraintAnchor12 = constraintWidget.mListAnchors[i2];
                                SolverVariable solverVariable12 = constraintAnchor12.mSolverVariable;
                                if (constraintAnchor12.mTarget != null) {
                                    SolverVariable solverVariable13 = constraintAnchor12.mTarget.mSolverVariable;
                                }
                                int i15 = i2 + 1;
                                SolverVariable solverVariable14 = constraintWidget23.mListAnchors[i15].mSolverVariable;
                                int margin2 = constraintAnchor12.getMargin();
                                int margin3 = constraintWidget.mListAnchors[i15].getMargin();
                                if (constraintWidget25 != null) {
                                    constraintAnchor4 = constraintWidget25.mListAnchors[i2];
                                    SolverVariable solverVariable15 = constraintAnchor4.mSolverVariable;
                                    constraintWidget3 = constraintWidget25;
                                    solverVariable2 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                                    solverVariable = solverVariable15;
                                } else {
                                    constraintWidget3 = constraintWidget25;
                                    constraintAnchor4 = constraintWidget13.mListAnchors[i2];
                                    solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                    solverVariable2 = constraintWidget.mListAnchors[i15].mSolverVariable;
                                }
                                if (constraintAnchor4 != null) {
                                    margin3 += constraintAnchor4.getMargin();
                                }
                                int i16 = margin3;
                                int margin4 = constraintWidget23.mListAnchors[i15].getMargin() + margin2;
                                int i17 = z12 ? 8 : 4;
                                if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                                    constraintWidget4 = constraintWidget3;
                                    constraintWidget2 = constraintWidget23;
                                    i3 = 8;
                                } else {
                                    constraintWidget4 = constraintWidget3;
                                    constraintWidget2 = constraintWidget23;
                                    i3 = 8;
                                    linearSystem.addCentering(solverVariable12, solverVariable14, margin4, 0.5f, solverVariable, solverVariable2, i16, i17);
                                }
                                constraintWidget24 = constraintWidget4;
                            }
                            constraintWidget23 = constraintWidget.getVisibility() != i3 ? constraintWidget : constraintWidget2;
                            constraintWidget = constraintWidget24;
                            i14 = i3;
                            i7 = i;
                        }
                        ConstraintAnchor constraintAnchor13 = constraintWidget12.mListAnchors[i2];
                        constraintAnchor = constraintWidget20.mListAnchors[i2].mTarget;
                        int i18 = i2 + 1;
                        constraintAnchor2 = constraintWidget13.mListAnchors[i18];
                        constraintAnchor3 = constraintWidget11.mListAnchors[i18].mTarget;
                        if (constraintAnchor != null) {
                            if (constraintWidget12 != constraintWidget13) {
                                linearSystem.addEquality(constraintAnchor13.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor13.getMargin(), 5);
                            } else if (constraintAnchor3 != null) {
                                linearSystem.addCentering(constraintAnchor13.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor13.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        if (constraintAnchor3 != null && constraintWidget12 != constraintWidget13) {
                            linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), 5);
                        }
                    }
                } else {
                    boolean z13 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget26 = constraintWidget12;
                    ConstraintWidget constraintWidget27 = constraintWidget26;
                    while (constraintWidget27 != null) {
                        ConstraintWidget constraintWidget28 = constraintWidget27.mNextChainWidget[i7];
                        while (constraintWidget28 != null && constraintWidget28.getVisibility() == 8) {
                            constraintWidget28 = constraintWidget28.mNextChainWidget[i7];
                        }
                        if (constraintWidget28 != null || constraintWidget27 == constraintWidget13) {
                            ConstraintAnchor constraintAnchor14 = constraintWidget27.mListAnchors[i2];
                            SolverVariable solverVariable16 = constraintAnchor14.mSolverVariable;
                            SolverVariable solverVariable17 = constraintAnchor14.mTarget != null ? constraintAnchor14.mTarget.mSolverVariable : null;
                            if (constraintWidget26 != constraintWidget27) {
                                solverVariable17 = constraintWidget26.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget27 == constraintWidget12) {
                                solverVariable17 = constraintWidget20.mListAnchors[i2].mTarget != null ? constraintWidget20.mListAnchors[i2].mTarget.mSolverVariable : null;
                            }
                            int margin5 = constraintAnchor14.getMargin();
                            int i19 = i2 + 1;
                            int margin6 = constraintWidget27.mListAnchors[i19].getMargin();
                            if (constraintWidget28 != null) {
                                constraintAnchor5 = constraintWidget28.mListAnchors[i2];
                                solverVariable3 = constraintAnchor5.mSolverVariable;
                            } else {
                                constraintAnchor5 = constraintWidget11.mListAnchors[i19].mTarget;
                                if (constraintAnchor5 != null) {
                                    solverVariable3 = constraintAnchor5.mSolverVariable;
                                } else {
                                    constraintWidget5 = constraintWidget28;
                                    solverVariable3 = null;
                                    SolverVariable solverVariable18 = constraintWidget27.mListAnchors[i19].mSolverVariable;
                                    if (constraintAnchor5 != null) {
                                        margin6 += constraintAnchor5.getMargin();
                                    }
                                    int margin7 = margin5 + constraintWidget26.mListAnchors[i19].getMargin();
                                    if (solverVariable16 != null || solverVariable17 == null || solverVariable3 == null || solverVariable18 == null) {
                                        constraintWidget6 = constraintWidget5;
                                    } else {
                                        if (constraintWidget27 == constraintWidget12) {
                                            margin7 = constraintWidget12.mListAnchors[i2].getMargin();
                                        }
                                        int i20 = margin7;
                                        constraintWidget6 = constraintWidget5;
                                        constraintWidget7 = constraintWidget26;
                                        linearSystem.addCentering(solverVariable16, solverVariable17, i20, 0.5f, solverVariable3, solverVariable18, constraintWidget27 == constraintWidget13 ? constraintWidget13.mListAnchors[i19].getMargin() : margin6, z13 ? 8 : 5);
                                        if (constraintWidget27.getVisibility() != 8) {
                                            constraintWidget27 = constraintWidget7;
                                        }
                                        constraintWidget26 = constraintWidget27;
                                        constraintWidget27 = constraintWidget6;
                                    }
                                }
                            }
                            constraintWidget5 = constraintWidget28;
                            SolverVariable solverVariable182 = constraintWidget27.mListAnchors[i19].mSolverVariable;
                            if (constraintAnchor5 != null) {
                            }
                            int margin72 = margin5 + constraintWidget26.mListAnchors[i19].getMargin();
                            if (solverVariable16 != null) {
                            }
                            constraintWidget6 = constraintWidget5;
                        } else {
                            constraintWidget6 = constraintWidget28;
                        }
                        constraintWidget7 = constraintWidget26;
                        if (constraintWidget27.getVisibility() != 8) {
                        }
                        constraintWidget26 = constraintWidget27;
                        constraintWidget27 = constraintWidget6;
                    }
                }
                if ((z11 && !z6) || constraintWidget12 == null || constraintWidget12 == constraintWidget13) {
                    return;
                }
                ConstraintAnchor constraintAnchor15 = constraintWidget12.mListAnchors[i2];
                if (constraintWidget13 == null) {
                    constraintWidget13 = constraintWidget12;
                }
                int i21 = i2 + 1;
                ConstraintAnchor constraintAnchor16 = constraintWidget13.mListAnchors[i21];
                solverVariable4 = constraintAnchor15.mTarget == null ? constraintAnchor15.mTarget.mSolverVariable : null;
                SolverVariable solverVariable19 = constraintAnchor16.mTarget == null ? constraintAnchor16.mTarget.mSolverVariable : null;
                if (constraintWidget11 == constraintWidget13) {
                    ConstraintAnchor constraintAnchor17 = constraintWidget11.mListAnchors[i21];
                    solverVariable5 = constraintAnchor17.mTarget != null ? constraintAnchor17.mTarget.mSolverVariable : null;
                } else {
                    solverVariable5 = solverVariable19;
                }
                if (constraintWidget12 == constraintWidget13) {
                    constraintAnchor15 = constraintWidget12.mListAnchors[i2];
                    constraintAnchor16 = constraintWidget12.mListAnchors[i21];
                }
                if (solverVariable4 != null || solverVariable5 == null) {
                }
                linearSystem.addCentering(constraintAnchor15.mSolverVariable, solverVariable4, constraintAnchor15.getMargin(), 0.5f, solverVariable5, constraintAnchor16.mSolverVariable, constraintWidget13.mListAnchors[i21].getMargin(), 5);
                return;
            }
        }
        if (z5) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
            if (chainHead.mHasUndefinedWeights) {
            }
            float f62 = 0.0f;
            float f72 = 0.0f;
            ConstraintWidget constraintWidget212 = null;
            i4 = 0;
            while (i4 < size) {
            }
        }
        if (constraintWidget12 == null) {
        }
        if (z11) {
        }
        int i142 = 8;
        if (z6) {
            if (chainHead.mWidgetsMatchCount <= 0) {
            }
            ConstraintWidget constraintWidget232 = constraintWidget12;
            constraintWidget = constraintWidget232;
            while (constraintWidget != null) {
            }
            ConstraintAnchor constraintAnchor132 = constraintWidget12.mListAnchors[i2];
            constraintAnchor = constraintWidget20.mListAnchors[i2].mTarget;
            int i182 = i2 + 1;
            constraintAnchor2 = constraintWidget13.mListAnchors[i182];
            constraintAnchor3 = constraintWidget11.mListAnchors[i182].mTarget;
            if (constraintAnchor != null) {
            }
            if (constraintAnchor3 != null) {
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), 5);
            }
        }
        if (z11) {
        }
        ConstraintAnchor constraintAnchor152 = constraintWidget12.mListAnchors[i2];
        if (constraintWidget13 == null) {
        }
        int i212 = i2 + 1;
        ConstraintAnchor constraintAnchor162 = constraintWidget13.mListAnchors[i212];
        if (constraintAnchor152.mTarget == null) {
        }
        if (constraintAnchor162.mTarget == null) {
        }
        if (constraintWidget11 == constraintWidget13) {
        }
        if (constraintWidget12 == constraintWidget13) {
        }
        if (solverVariable4 != null) {
        }
    }
}
