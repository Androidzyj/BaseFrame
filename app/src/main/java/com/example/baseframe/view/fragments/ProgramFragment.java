package com.example.baseframe.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseframe.R;

/**
 * Created by Administrator on 2019/9/9 0009
 */
public class ProgramFragment extends Fragment {
    public static ProgramFragment create(){return new ProgramFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_program,container,false);
    }
}
