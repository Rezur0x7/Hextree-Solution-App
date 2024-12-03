package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.SolvedPreferences;
/* loaded from: classes.dex */
public class Flag4Activity extends AppCompactActivity {
    public Flag4Activity() {
        this.name = "Flag 4 - State machine";
        this.flag = "2ftukoQ59QLkG42FGkCkdyK7+Jwi0uY7QfC2sPyofRcgvI+kzSIwqP0vMJ9fCbRn";
    }

    /* loaded from: classes.dex */
    public enum State {
        INIT(0),
        PREPARE(1),
        BUILD(2),
        GET_FLAG(3),
        REVERT(4);
        
        private final int value;

        State(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static State fromInt(int i) {
            State[] values;
            for (State state : values()) {
                if (state.getValue() == i) {
                    return state;
                }
            }
            return INIT;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        stateMachine(getIntent());
    }

    private State getCurrentState() {
        return State.fromInt(SolvedPreferences.getInt(getPrefixKey("state")));
    }

    private void setCurrentState(State state) {
        SolvedPreferences.putInt(getPrefixKey("state"), state.getValue());
    }

    public void stateMachine(Intent intent) {
        String action = intent.getAction();
        int i = AnonymousClass1.$SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State[getCurrentState().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.f.addTag(State.GET_FLAG);
                        setCurrentState(State.INIT);
                        success(this);
                        Log.i("Flag4StateMachine", "solved");
                        return;
                    } else if (i == 5 && "INIT_ACTION".equals(action)) {
                        setCurrentState(State.INIT);
                        Toast.makeText(this, "Transitioned from REVERT to INIT", 0).show();
                        Log.i("Flag4StateMachine", "Transitioned from REVERT to INIT");
                        return;
                    }
                } else if ("GET_FLAG_ACTION".equals(action)) {
                    setCurrentState(State.GET_FLAG);
                    Toast.makeText(this, "Transitioned from BUILD to GET_FLAG", 0).show();
                    Log.i("Flag4StateMachine", "Transitioned from BUILD to GET_FLAG");
                    return;
                }
            } else if ("BUILD_ACTION".equals(action)) {
                setCurrentState(State.BUILD);
                Toast.makeText(this, "Transitioned from PREPARE to BUILD", 0).show();
                Log.i("Flag4StateMachine", "Transitioned from PREPARE to BUILD");
                return;
            }
        } else if ("PREPARE_ACTION".equals(action)) {
            setCurrentState(State.PREPARE);
            Toast.makeText(this, "Transitioned from INIT to PREPARE", 0).show();
            Log.i("Flag4StateMachine", "Transitioned from INIT to PREPARE");
            return;
        }
        Toast.makeText(this, "Unknown state. Transitioned to INIT", 0).show();
        Log.i("Flag4StateMachine", "Unknown state. Transitioned to INIT");
        setCurrentState(State.INIT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.hextree.attacksurface.activities.Flag4Activity$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State[State.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State[State.BUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State[State.GET_FLAG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$hextree$attacksurface$activities$Flag4Activity$State[State.REVERT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
