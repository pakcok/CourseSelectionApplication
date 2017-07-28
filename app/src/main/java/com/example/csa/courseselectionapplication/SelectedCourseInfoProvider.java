package com.example.csa.courseselectionapplication;

/**
 * Created by Pakco's Desktop on 2017-07-26.
 */

public class SelectedCourseInfoProvider {
    private int _course_number;
    private String _course_title;
    private String _course_info;

    public SelectedCourseInfoProvider (int course_number, String course_title, String course_info) {
        this.setCourse_number(course_number);
        this.setCourse_title(course_title);
        this.setCourse_info(course_info);
    }

    public int getCoures_number() {
        return _course_number;
    }

    public void setCourse_number(int course_number) {
        this._course_number = course_number;
    }

    public String getCourse_title() {
        return _course_title;
    }

    public void setCourse_title(String course_title) {
        this._course_title = course_title;
    }

    public String getCourse_info() {
        return _course_info;
    }

    public void setCourse_info(String course_info) {
        this._course_info = course_info;
    }
}
