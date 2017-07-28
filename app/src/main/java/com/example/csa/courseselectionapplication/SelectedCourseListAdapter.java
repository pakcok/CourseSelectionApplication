package com.example.csa.courseselectionapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pakco's Desktop on 2017-07-26.
 */

public class SelectedCourseListAdapter extends ArrayAdapter{
    List list = new ArrayList();

    public SelectedCourseListAdapter (Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler {
        TextView Number;
        TextView Title;
        TextView Info;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.selected_row_layout, parent, false);

            handler = new DataHandler();
            handler.Title = (TextView) row.findViewById(R.id.selected_course_title);
            handler.Info = (TextView) row.findViewById(R.id.selected_course_info);
            row.setTag(handler);
        }
        else
        {
            handler = (DataHandler) row.getTag();
        }


        SelectedCourseInfoProvider dataProvider;
        dataProvider = (SelectedCourseInfoProvider) this.getItem(position);
        handler.Title.setText(dataProvider.getCourse_title());
        handler.Info.setText(dataProvider.getCourse_info());

        return row;
    }
}
