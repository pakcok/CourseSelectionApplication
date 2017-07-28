package com.example.csa.courseselectionapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Pakco's Desktop on 2017-07-27.
 */

public class AvailableCourseListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listCourseTitle; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listCourseSection;

    public AvailableCourseListAdapter (Context context, List<String> listCourseTitle,
                                       HashMap<String, List<String>> listCourseSection) {
        this._context = context;
        this._listCourseTitle = listCourseTitle;
        this._listCourseSection = listCourseSection;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listCourseSection.get(this._listCourseTitle.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.available_course_section, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.available_course_info);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listCourseSection.get(this._listCourseTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listCourseTitle.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listCourseTitle.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.available_course_title, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.available_course_name);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
