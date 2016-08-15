package githubclient.true123.cn.githubclient.ui.activities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import githubclient.true123.cn.githubclient.util.MLog;

/**
 * Created by junbo on 15/8/2016.
 */
public class LineDecoration extends RecyclerView.ItemDecoration {
    public LineDecoration() {
        super();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setAntiAlias(false);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            MLog.i(this,"child.getBottom() + params.bottomMargin="+child.getBottom() + params.bottomMargin);
            MLog.i(this,"child.getWidth()="+child.getWidth());
            MLog.i(this,"bottom"+child.getBottom());

            c.drawLine(params.leftMargin, child.getBottom() + params.bottomMargin, child.getWidth(), child.getBottom() + params.bottomMargin, p);
        }
    }


}
