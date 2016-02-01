package me.zircon.v2test.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.zircon.v2test.R;


/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;

    public SpaceItemDecoration(Context context) {
        mContext = context;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager)layoutManager;
            int orientation = linearLayoutManager.getOrientation();
            if (LinearLayoutManager.HORIZONTAL == orientation) {
                outRect.set(0, 0, mContext.getResources().getDimensionPixelSize(R.dimen.space_width), 0);
                return;
            } else if (LinearLayoutManager.VERTICAL == orientation) {
                outRect.set(0, 0, 0, mContext.getResources().getDimensionPixelSize(R.dimen.space_height));
                return;
            }
        }
        outRect.set(0, 0, 0, 0);
    }
}
