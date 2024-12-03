package io.hextree.attacksurface.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.hextree.attacksurface.R;
/* loaded from: classes.dex */
public final class FlagHomeWidgetBinding implements ViewBinding {
    public final Button btnWidget1;
    private final RelativeLayout rootView;
    public final RelativeLayout widgetBg;

    private FlagHomeWidgetBinding(RelativeLayout relativeLayout, Button button, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.btnWidget1 = button;
        this.widgetBg = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FlagHomeWidgetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FlagHomeWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.flag_home_widget, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FlagHomeWidgetBinding bind(View view) {
        int i = R.id.btn_widget1;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new FlagHomeWidgetBinding(relativeLayout, button, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
