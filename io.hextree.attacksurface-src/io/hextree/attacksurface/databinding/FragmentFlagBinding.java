package io.hextree.attacksurface.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.hextree.attacksurface.R;
/* loaded from: classes.dex */
public final class FragmentFlagBinding implements ViewBinding {
    public final TextView flagDescription;
    public final TextView flagName;
    public final CheckBox flagSolved;
    public final LinearLayout flagView;
    public final LinearLayout linearLayout;
    public final LinearLayout linearLayout2;
    private final LinearLayout rootView;
    public final TextView tag;
    public final TextView textView6;

    private FragmentFlagBinding(LinearLayout linearLayout, TextView textView, TextView textView2, CheckBox checkBox, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.flagDescription = textView;
        this.flagName = textView2;
        this.flagSolved = checkBox;
        this.flagView = linearLayout2;
        this.linearLayout = linearLayout3;
        this.linearLayout2 = linearLayout4;
        this.tag = textView3;
        this.textView6 = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFlagBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFlagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_flag, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFlagBinding bind(View view) {
        int i = R.id.flag_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.flag_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.flag_solved;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.linearLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.linearLayout2;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.tag;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.textView6;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new FragmentFlagBinding(linearLayout, textView, textView2, checkBox, linearLayout, linearLayout2, linearLayout3, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
