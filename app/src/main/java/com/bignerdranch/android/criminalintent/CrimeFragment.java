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

import java.util.UUID;


/**
 * Created by Kavya on 17-07-2018.
 */

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*UUID crimeId = (UUID)
                getActivity().getIntent()
                        .getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);*/
        /*mCrime =
                CrimeLab.get(getActivity()).getCrime(crimeId);*/
        UUID crimeId = (UUID)
                getArguments().getSerializable(ARG_CRIME_ID);
        mCrime =
                CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container,
                        false);
        mTitleField = (EditText)
                v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getmTitle());
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
        mSolvedCheckBox.setChecked(mCrime.ismSolved());
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


