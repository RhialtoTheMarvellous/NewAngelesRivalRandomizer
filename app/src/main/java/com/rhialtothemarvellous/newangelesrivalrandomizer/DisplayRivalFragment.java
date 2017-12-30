package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayRivalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisplayRivalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayRivalFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PLAYER = "player";
    private static final String ARG_RIVAL = "rival";
    
    private Corp mPlayer;
    private CorpOrFederalist mRival;
    
    private OnFragmentInteractionListener mListener;
    
    public DisplayRivalFragment() {
        // Required empty public constructor
    }
    
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayRivalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayRivalFragment newInstance(Corp param1, CorpOrFederalist param2) {
        DisplayRivalFragment fragment = new DisplayRivalFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PLAYER, param1);
        args.putSerializable(ARG_RIVAL, param2);
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPlayer = (Corp) getArguments().getSerializable(ARG_PLAYER);
            mRival = (CorpOrFederalist) getArguments().getSerializable(ARG_RIVAL);
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_rival, container, false);
    
        TextView corpName = view.findViewById(R.id.textView_CorpName);
        corpName.setText(mPlayer.getStringID());
    
        Button revealButton = view.findViewById(R.id.button_RevealRival);
        revealButton.setOnClickListener(this);
        
        return view;
    }
    
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_RevealRival:
                revealRival();
                break;
        }
    }
    
    private void revealRival() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        builder.setMessage("Your rival is " + getString(mRival.getStringID()) + ".");
        
        builder.show();
    }
    
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
