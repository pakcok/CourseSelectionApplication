package com.example.csa.courseselectionapplication;

import java.util.ArrayList;

/**
 * Created by Pakco's Desktop on 2017-07-27.
 */

public class AvailableCourseInfoProvider {

    //private String pName;
    //private int course_number;

    //private String _course_section;
    private String _course_title;
    private ArrayList<CourseSection> _courseSectionList;

    public AvailableCourseInfoProvider(String course_title, ArrayList<CourseSection> courseSectionList) {
        super();
        this._course_title = course_title;
        this._courseSectionList = courseSectionList;
    }

    public String getCourse_title() {
        return _course_title;
    }

    public void setCourse_title(String course_title) {
        this._course_title = course_title;
    }

    public ArrayList<CourseSection> getcourseSectionList() {
        return _courseSectionList;
    }

    public void setcourseSectionList(ArrayList<CourseSection> courseSectionList) {
        this._courseSectionList = courseSectionList;
    }

    //-----------------
    //second level item
    //-----------------
    public static class CourseSection {

        private String _section_info;

        public CourseSection(String section_info) {
            super();
            this.setSectionInfo(section_info);
        }

        public String getSectionInfo() {
            return _section_info;
        }

        public void setSectionInfo(String section_info) {
            this._section_info = section_info;
        }
    }
}