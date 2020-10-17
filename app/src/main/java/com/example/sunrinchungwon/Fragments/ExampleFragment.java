package com.example.sunrinchungwon.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunrinchungwon.Adapters.RecyclerViewAdapter;
import com.example.sunrinchungwon.MainActivity;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.recycler_item;

import java.util.ArrayList;
import java.util.List;

public class ExampleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    private String mParam1;
    private String mParam2;
    MainActivity mainActivity;

    String title;
    String date;
    String isResponed;
    private Context context=getContext();
    private OnFragmentInteractionListener mListener;

    public ExampleFragment() {

    }


    public static ExampleFragment newInstance(String param1, String param2) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_example, container, false);
        mainActivity = (MainActivity) getActivity();
        recyclerView = v.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        recyclerView.addItemDecoration( new DividerItemDecoration(mainActivity,linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);
        List<recycler_item> recycler_item = new ArrayList<>();
        recycler_item.add(new recycler_item("김덕배","010-1234-5678","기모링!"));
        recycler_item.add(new recycler_item("강구팔","010-5678-1234","기모링!"));
        recycler_item.add(new recycler_item("이배윤","010-3412-7856","기모링!"));
        recycler_item.add(new recycler_item("버기","123-1256-3478","기모링!")); recycler_item.add(new recycler_item("김덕배","010-1234-5678","기모링!"));
        recycler_item.add(new recycler_item("강구팔","010-5678-1234","기모링!"));
        recycler_item.add(new recycler_item("이배윤","010-3412-7856","기모링!"));
        recycler_item.add(new recycler_item("버기","123-1256-3478","기모링!")); recycler_item.add(new recycler_item("김덕배","010-1234-5678","기모링!"));
        recycler_item.add(new recycler_item("강구팔","010-5678-1234","기모링!"));

        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity,recycler_item);
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
