package com.example.csa.courseselectionapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Pakco's Desktop on 2017-07-20.
 */

public class SelectedFragment extends Fragment{

    View myView;

    List<String> listCourseTitle;
    HashMap<String, List<String>> listCourseInfo;

    int[] selected_course_number;
    String[] selected_course_list;
    String[] selected_course_info;

    String[] course_title;
    String[] course_info;
    SelectedCourseListAdapter selected_course_ListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.selected_course_filter, container, false);

        String firstSectionTab = "\t\t\t\t\t\t\t\t\t\t\t";
        String firstDayTab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";

        String courseLocationTab = "\t\t\t\t\t\t\t\t\t";
        String oneDayTab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String twoDayTab = "\t\t\t\t\t\t";

        String mon_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String tue_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String wed_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String thu_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String fri_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
        String sat_tab = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";


        int[] selected_course_number = { 1,
                2,
                3,
                4 };
        String[] selected_course_list = { "INFO 1111" + " (S" + "10" + ")" ,
                "BUSI 1110" + " (S" + "30" + ")",
                "PHIL 1150" + " (S" + "15" + ")",
                "INFO 2413" + " (S" + "06" + ")" };
        String[] selected_course_info = { "TeacherName" + "\n" + "Surrey" + courseLocationTab + "Room Number" +"\n" + "Tue&Thu" + twoDayTab + "10:00am-11:50pm",
                "TeacherName" + "\n" + "Surrey" + courseLocationTab + "Room Number" +"\n" + "Tue&Thu" + twoDayTab + "10:00am-11:50pm",
                "TeacherName" + "\n" + "Surrey" + courseLocationTab + "Room Number" +"\n" + "Tue&Thu" + twoDayTab + "10:00am-11:50pm",
                "TeacherName" + "\n" + "Surrey" + courseLocationTab + "Room Number" +"\n" + "Tue&Thu" + twoDayTab + "10:00am-11:50pm" };

        ListView courselistView = (ListView) myView.findViewById(R.id.list_selected_course);

        selected_course_ListAdapter = new SelectedCourseListAdapter(getContext(), R.layout.selected_row_layout);

        int i = 0;
        for(String titles: selected_course_list)
        {
            SelectedCourseInfoProvider dataProvider = new SelectedCourseInfoProvider(selected_course_number[i],
                    titles,selected_course_info[i] );
            selected_course_ListAdapter.add(dataProvider);
            i++;
        }

        courselistView.setAdapter(selected_course_ListAdapter);

        return myView;
    }

}
