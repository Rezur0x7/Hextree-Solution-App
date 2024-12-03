package io.hextree.attacksurface;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.hextree.attacksurface.activities.Flag10Activity;
import io.hextree.attacksurface.activities.Flag11Activity;
import io.hextree.attacksurface.activities.Flag12Activity;
import io.hextree.attacksurface.activities.Flag13Activity;
import io.hextree.attacksurface.activities.Flag14Activity;
import io.hextree.attacksurface.activities.Flag15Activity;
import io.hextree.attacksurface.activities.Flag16Activity;
import io.hextree.attacksurface.activities.Flag17Activity;
import io.hextree.attacksurface.activities.Flag18Activity;
import io.hextree.attacksurface.activities.Flag19Activity;
import io.hextree.attacksurface.activities.Flag1Activity;
import io.hextree.attacksurface.activities.Flag20Activity;
import io.hextree.attacksurface.activities.Flag21Activity;
import io.hextree.attacksurface.activities.Flag22Activity;
import io.hextree.attacksurface.activities.Flag23Activity;
import io.hextree.attacksurface.activities.Flag24Activity;
import io.hextree.attacksurface.activities.Flag25Activity;
import io.hextree.attacksurface.activities.Flag26Activity;
import io.hextree.attacksurface.activities.Flag27Activity;
import io.hextree.attacksurface.activities.Flag28Activity;
import io.hextree.attacksurface.activities.Flag29Activity;
import io.hextree.attacksurface.activities.Flag2Activity;
import io.hextree.attacksurface.activities.Flag30Activity;
import io.hextree.attacksurface.activities.Flag31Activity;
import io.hextree.attacksurface.activities.Flag32Activity;
import io.hextree.attacksurface.activities.Flag33Activity1;
import io.hextree.attacksurface.activities.Flag33Activity2;
import io.hextree.attacksurface.activities.Flag34Activity;
import io.hextree.attacksurface.activities.Flag35Activity;
import io.hextree.attacksurface.activities.Flag36Activity;
import io.hextree.attacksurface.activities.Flag3Activity;
import io.hextree.attacksurface.activities.Flag4Activity;
import io.hextree.attacksurface.activities.Flag5Activity;
import io.hextree.attacksurface.activities.Flag6Activity;
import io.hextree.attacksurface.activities.Flag7Activity;
import io.hextree.attacksurface.activities.Flag8Activity;
import io.hextree.attacksurface.activities.Flag9Activity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HextreeActivityFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    MyHextreeActivityRecyclerViewAdapter adapter;
    private int mColumnCount = 1;

    public static HextreeActivityFragment newInstance(int i) {
        HextreeActivityFragment hextreeActivityFragment = new HextreeActivityFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_COLUMN_COUNT, i);
        hextreeActivityFragment.setArguments(bundle);
        return hextreeActivityFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_flag_list, viewGroup, false);
        if (inflate instanceof RecyclerView) {
            Context context = inflate.getContext();
            RecyclerView recyclerView = (RecyclerView) inflate;
            if (this.mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, this.mColumnCount));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Flag1Activity());
            arrayList.add(new Flag2Activity());
            arrayList.add(new Flag3Activity());
            arrayList.add(new Flag4Activity());
            arrayList.add(new Flag5Activity());
            arrayList.add(new Flag6Activity());
            arrayList.add(new Flag7Activity());
            arrayList.add(new Flag8Activity());
            arrayList.add(new Flag9Activity());
            arrayList.add(new Flag10Activity());
            arrayList.add(new Flag11Activity());
            arrayList.add(new Flag12Activity());
            arrayList.add(new Flag13Activity());
            arrayList.add(new Flag14Activity());
            arrayList.add(new Flag15Activity());
            arrayList.add(new Flag16Activity());
            arrayList.add(new Flag17Activity());
            arrayList.add(new Flag18Activity());
            arrayList.add(new Flag19Activity());
            arrayList.add(new Flag20Activity());
            arrayList.add(new Flag21Activity());
            arrayList.add(new Flag22Activity());
            arrayList.add(new Flag23Activity());
            arrayList.add(new Flag24Activity());
            arrayList.add(new Flag25Activity());
            arrayList.add(new Flag26Activity());
            arrayList.add(new Flag27Activity());
            arrayList.add(new Flag28Activity());
            arrayList.add(new Flag29Activity());
            arrayList.add(new Flag30Activity());
            arrayList.add(new Flag31Activity());
            arrayList.add(new Flag32Activity());
            arrayList.add(new Flag33Activity1());
            arrayList.add(new Flag33Activity2());
            arrayList.add(new Flag34Activity());
            arrayList.add(new Flag35Activity());
            arrayList.add(new Flag36Activity());
            MyHextreeActivityRecyclerViewAdapter myHextreeActivityRecyclerViewAdapter = new MyHextreeActivityRecyclerViewAdapter(arrayList);
            this.adapter = myHextreeActivityRecyclerViewAdapter;
            recyclerView.setAdapter(myHextreeActivityRecyclerViewAdapter);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.adapter.notifyDataSetChanged();
        super.onResume();
    }
}
