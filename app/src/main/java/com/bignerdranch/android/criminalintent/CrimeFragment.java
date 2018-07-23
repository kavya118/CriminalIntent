package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


/**
 * Created by Kavya on 17-07-2018.
 */

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v =
                inflater.inflate(R.layout.fragment_crime, container,
                        false);
        mTitleField = (EditText)
                v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
                                                       @Override
                                                       public void beforeTextChanged(
                                                               CharSequence s, int start, int count,
                                                               int after) {
// This space intentionally left blank

                                                       }
                                                       @Override
                                                       public void onTextChanged(
                                                               CharSequence s, int start, int
                                                               before, int count) {
                                                           mCrime.setmTitle(s.toString());
                                                       }
                                                       @Override
                                                       public void afterTextChanged(Editable s)
                                                       {
// This one too
                                                       }
                                                   });
        mDateButton = (Button)
                v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getmDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox =
                (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                               @Override
                                                               public void
                                                               onCheckedChanged(CompoundButton buttonView,
                                                                                boolean isChecked) {
                                                                   mCrime.setmSolved(isChecked);
                                                               }
                                                           });
        return v;
    }
}


