package io.hextree.attacksurface;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import io.hextree.attacksurface.databinding.FragmentFlagBinding;
import java.util.List;
/* loaded from: classes.dex */
public class MyHextreeActivityRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<AppCompactActivity> mValues;

    public MyHextreeActivityRecyclerViewAdapter(List<AppCompactActivity> list) {
        this.mValues = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(FragmentFlagBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        viewHolder.mItem = this.mValues.get(i);
        final AppCompactActivity appCompactActivity = this.mValues.get(i);
        viewHolder.mName.setText(appCompactActivity.name);
        viewHolder.mDescription.setText(appCompactActivity.description);
        viewHolder.mTag.setText(appCompactActivity.tag);
        viewHolder.mTag.setBackgroundColor(ContextCompat.getColor(viewHolder.mTag.getContext(), appCompactActivity.tagColor));
        if (appCompactActivity.isSolved()) {
            viewHolder.mSolved.setChecked(true);
            viewHolder.mName.setAlpha(0.25f);
            viewHolder.mDescription.setAlpha(0.25f);
            viewHolder.mTag.setAlpha(0.25f);
            viewHolder.mSolved.setAlpha(0.25f);
        } else {
            viewHolder.mSolved.setChecked(false);
            viewHolder.mName.setAlpha(1.0f);
            viewHolder.mDescription.setAlpha(1.0f);
            viewHolder.mTag.setAlpha(1.0f);
            viewHolder.mSolved.setAlpha(1.0f);
        }
        viewHolder.mLayout.setOnClickListener(new View.OnClickListener() { // from class: io.hextree.attacksurface.MyHextreeActivityRecyclerViewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("Click", appCompactActivity.name);
                appCompactActivity.clickOnListItem(viewHolder.mLayout.getContext());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mValues.size();
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mDescription;
        public AppCompactActivity mItem;
        public LinearLayout mLayout;
        public final TextView mName;
        public final CheckBox mSolved;
        public final TextView mTag;

        public ViewHolder(FragmentFlagBinding fragmentFlagBinding) {
            super(fragmentFlagBinding.getRoot());
            this.mName = fragmentFlagBinding.flagName;
            this.mDescription = fragmentFlagBinding.flagDescription;
            this.mSolved = fragmentFlagBinding.flagSolved;
            this.mTag = fragmentFlagBinding.tag;
            this.mLayout = fragmentFlagBinding.flagView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return super.toString() + " '" + ((Object) this.mName.getText()) + "'";
        }
    }
}
