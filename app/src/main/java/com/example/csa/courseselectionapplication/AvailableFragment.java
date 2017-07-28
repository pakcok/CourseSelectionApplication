package com.example.csa.courseselectionapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by Pakco's Desktop on 2017-07-20.
 */

public class AvailableFragment extends Fragment {

    AvailableCourseListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.available_course_filter, container, false);
        return myView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = getView();

        // get the listview
        expListView = (ExpandableListView) myView.findViewById(R.id.availableCourseExpandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new AvailableCourseListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        /*
        // Listview on child click listener
        // TODO: Add selected course to Selected Course List
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Toast.makeText(
                        getContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        */
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        String firstSectionTab = "\t\t\t\t\t\t\t\t\t\t\t";
        String firstDayTab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String courseInfoTitle = "(Section)" + firstSectionTab + "(Location)" + "\n" + "(Days)" + firstDayTab + "(Time)";


        String courseSectionTab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String oneDayTab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String twoDayTab = "\t\t\t\t\t\t\t\t\t\t\t";

        String mon_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String tue_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String wed_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String thu_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String fri_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String sat_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";


        // Adding child data
        listDataHeader.add("INFO 1111");
        listDataHeader.add("BUSI 1110");
        listDataHeader.add("PHIL 1150");

        List<List<String>> coursesAvailable = new  ArrayList<List<String>>();

        // Adding child data
        List<String> INFO_1111 = new ArrayList<String>();
        INFO_1111.add(courseInfoTitle);

        INFO_1111.add(   "S"+"10"    + courseSectionTab   + "Surrey"
                + "\n" + "Tue&Thu"   + twoDayTab          + "10:00am-11:50pm"  );


        INFO_1111.add(   "S"+"20"    + courseSectionTab   + "Richmond"
                + "\n" + "Mon"       + mon_tab          + "1:00pm-3:50pm"  );
        INFO_1111.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Tue"       + tue_tab          + "4:00pm-6:50pm"  );
        INFO_1111.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Wed"       + wed_tab          + "4:00pm-6:50pm"  );
        INFO_1111.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Thu"       + thu_tab          + "4:00pm-6:50pm"  );
        INFO_1111.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Fri"       + fri_tab          + "4:00pm-6:50pm"  );
        INFO_1111.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Sat"       + sat_tab          + "4:00pm-6:50pm"  );
        INFO_1111.add(   "S"+"60"    + courseSectionTab   + "Surrey"
                + "\n" + "Tue&Thu"   + twoDayTab          + "1:00pm-2:50pm"  );

        List<String> BUSI_1110 = new ArrayList<String>();
        BUSI_1110.add(   "S"+"60"    + courseSectionTab   + "Surrey"
                + "\n" + "Tue&Thu"   + twoDayTab          + "1:00pm-2:50pm"  );
        BUSI_1110.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Thu"       + thu_tab          + "4:00pm-6:50pm"  );
        BUSI_1110.add(   "S"+"10"    + courseSectionTab   + "Surrey"
                + "\n" + "Tue&Thu"   + twoDayTab          + "10:00am-11:50pm"  );
        BUSI_1110.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Fri"       + fri_tab          + "4:00pm-6:50pm"  );

        List<String> PHIL_1150 = new ArrayList<String>();
        PHIL_1150.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Wed"       + wed_tab          + "4:00pm-6:50pm"  );
        PHIL_1150.add(   "S"+"20"    + courseSectionTab   + "Richmond"
                + "\n" + "Mon"       + mon_tab          + "1:00pm-3:50pm"  );
        PHIL_1150.add(   "S"+"40"    + courseSectionTab   + "Richmond"
                + "\n" + "Sat"       + sat_tab          + "4:00pm-6:50pm"  );

        coursesAvailable.add(INFO_1111);
        coursesAvailable.add(BUSI_1110);
        coursesAvailable.add(PHIL_1150);

        listDataChild.put(listDataHeader.get(0), coursesAvailable.get(0)); // Header, Child data
        listDataChild.put(listDataHeader.get(1), coursesAvailable.get(1));
        listDataChild.put(listDataHeader.get(2), coursesAvailable.get(2));
    }
}
