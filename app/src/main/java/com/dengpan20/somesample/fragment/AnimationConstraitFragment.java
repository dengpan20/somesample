package com.dengpan20.somesample.fragment;


import android.os.Bundle;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.transition.TransitionManager;
import com.dengpan20.somesample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimationConstraitFragment extends Fragment {

    ConstraintLayout main;
    ConstraintSet applyConstraitSet = new ConstraintSet();
    ConstraintSet resetConstraitSet = new ConstraintSet();
    private Button btn1,btn2,btn3,applyBtn,resetBtn;

    public AnimationConstraitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animation_constrait, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        main = view.findViewById(R.id.main);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        applyBtn = view.findViewById(R.id.applyBtn);
        resetBtn = view.findViewById(R.id.resetBtn);

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(main);
                trans1();
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(main);
                resetConstraitSet.applyTo(main);
            }
        });

        applyConstraitSet.clone(main);
        resetConstraitSet.clone(main);
    }

    private void trans1() {
        applyConstraitSet.setMargin(R.id.btn1, ConstraintSet.START,8);
        applyConstraitSet.applyTo(main);
    }

}
