package com.example.nowinning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import static com.example.nowinning.BSOActivity.btn_SBO;
import static com.example.nowinning.BSOActivity.layout_field;

public class DefenceActivity extends Fragment implements View.OnTouchListener {

    float dX;
    float dY;
    int lastAction;
    public static FrameLayout layout_defence;
    public static ConstraintLayout layout_def_field;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.activity_field, container, false);

        final View dragView0 = v.findViewById(R.id.def0);
        dragView0.setOnTouchListener(this);

        final View dragView1 = v.findViewById(R.id.def1);
        dragView1.setOnTouchListener(this);

        final View dragView2 = v.findViewById(R.id.def2);
        dragView2.setOnTouchListener(this);

        final View dragView3 = v.findViewById(R.id.def3);
        dragView3.setOnTouchListener(this);

        final View dragView4 = v.findViewById(R.id.def4);
        dragView4.setOnTouchListener(this);

        final View dragView5 = v.findViewById(R.id.def5);
        dragView5.setOnTouchListener(this);

        final View dragView6 = v.findViewById(R.id.def6);
        dragView6.setOnTouchListener(this);

        final View dragView7 = v.findViewById(R.id.def7);
        dragView7.setOnTouchListener(this);

        final View dragView8 = v.findViewById(R.id.def8);
        dragView8.setOnTouchListener(this);

        layout_defence = (FrameLayout) v.findViewById(R.id.layout_defence);

        return  v;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;
                break;

            case MotionEvent.ACTION_MOVE:
                int viewWidth = view.getWidth();
                int viewHeight = view.getHeight();

                View viewParent = (View)view.getParent();
                int parentWidth = viewParent.getWidth();
                int parentHeight = viewParent.getHeight();

                float newX = event.getRawX() + dX;
                newX = Math.max(layoutParams.leftMargin, newX); // Don't allow the FAB past the left hand side of the parent
                newX = Math.min(parentWidth - viewWidth - layoutParams.rightMargin, newX); // Don't allow the FAB past the right hand side of the parent

                float newY = event.getRawY() + dY;
                newY = Math.max(layoutParams.topMargin, newY); // Don't allow the FAB past the top of the parent
                newY = Math.min(parentHeight - viewHeight - layoutParams.bottomMargin, newY); // Don't allow the FAB past the bottom of the parent

                view.animate()
                        .x(newX)
                        .y(newY)
                        .setDuration(0)
                        .start();

                view.setY(event.getRawY() + dY);
                view.setX(event.getRawX() + dX);
                lastAction = MotionEvent.ACTION_MOVE;
                break;

            case MotionEvent.ACTION_UP:
                //if (lastAction == MotionEvent.ACTION_DOWN)
                Toast.makeText(getActivity(), dX+", "+dY, Toast.LENGTH_SHORT).show();
                layout_defence.setVisibility(View.INVISIBLE);
                layout_field.setVisibility(View.VISIBLE);
                break;

            default:
                return false;

        }
        return true;

    }
}
