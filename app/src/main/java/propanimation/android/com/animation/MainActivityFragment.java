package propanimation.android.com.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView wheel = (ImageView)view.findViewById(R.id.wheel);
        AnimatorSet wheelSet = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), R.animator.whheel_spin);
        wheelSet.setTarget(wheel);
        wheelSet.start();

        ImageView sun = (ImageView)view.findViewById(R.id.sun);
        AnimatorSet sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(),R.animator.sun_swing);
        sunSet.setTarget(sun);
        sunSet.start();

        ValueAnimator skyAnim = ObjectAnimator.ofInt(view.findViewById(R.id.car_layout),
        "backgroundColor", Color.rgb(0x66,0xcc,0xff),
                Color.rgb(0x00, 0x66, 0x99));
        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();

        ObjectAnimator cloudAnim1 = ObjectAnimator.ofFloat(view.findViewById(R.id.cloud1),"x",-350);
        cloudAnim1.setDuration(3000);
        cloudAnim1.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim1.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim1.start();

        ObjectAnimator cloudAnim2 = ObjectAnimator.ofFloat(view.findViewById(R.id.cloud2), "x", -300);
        cloudAnim2.setDuration(3000);
        cloudAnim2.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim2.start();
    }
}
