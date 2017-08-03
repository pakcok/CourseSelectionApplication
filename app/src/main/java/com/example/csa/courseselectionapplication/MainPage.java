package com.example.csa.courseselectionapplication;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;

import com.example.csa.courseselectionapplication.helper.SessionManager;
import com.example.csa.courseselectionapplication.helper.SQLiteHandler;

import org.w3c.dom.Text;

public class MainPage extends AppCompatActivity {

    private SQLiteHandler db;
    private SessionManager session;

    private TextView fullName;
    private TextView mTextMessage;
    private TextView currentYear;
    private TextView gpa;
    private CalendarView calendarView;
    private LinearLayout planningView;
    private LinearLayout homeView;
    private int year;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    homeView.setVisibility(View.VISIBLE);
                    calendarView.setVisibility(View.GONE);
                    planningView.setVisibility(View.GONE);
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_calendar:
                    homeView.setVisibility(View.GONE);
                    planningView.setVisibility(View.GONE);
                    calendarView.setVisibility(View.VISIBLE);
                    mTextMessage.setText(R.string.title_calendar);
                    return true;
                case R.id.navigation_plan:
                    homeView.setVisibility(View.GONE);
                    planningView.setVisibility(View.VISIBLE);
                    calendarView.setVisibility(View.GONE);
                    mTextMessage.setText(R.string.title_plan);
                    return true;
            }
            return false;
        }

    };

    private Button.OnClickListener mOnClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent startCoursesFilter = new Intent(MainPage.this, CourseFilterActivity.class);
            startActivity(startCoursesFilter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

		fullName = (TextView) findViewById(R.id.full_name);
        //gpa = (TextView) findViewById(R.id.gpa);
		
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        // Getting data from previous activity
        String student_id = getIntent().getStringExtra("student_id");

        // Fetching user details from SQLite
        HashMap<String, String> student = db.getUserDetails(student_id);

        //String student_id = student.get("student_id");
        String username = student.get("username");
        // Displaying the student details on the screen
        fullName.setText(username);

        /*
        HashMap<String, String> student_GPA = db.getGPA(student_id);
        int sumGrade = Integer.parseInt(student_GPA.get("sumGrade"));
        int sumUnit = Integer.parseInt(student_GPA.get("sumUnit"));

        gpa.setText(sumGrade);
        */



        mTextMessage = (TextView) findViewById(R.id.message);

        //
        homeView = (LinearLayout) findViewById(R.id.home_view);
        homeView.setVisibility(View.VISIBLE);

        planningView = (LinearLayout) findViewById(R.id.planning_form);
        planningView.setVisibility(View.GONE);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setVisibility(View.GONE);

        //Get the current year
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        currentYear = (TextView) findViewById(R.id.yearTextView);
        currentYear.setText(Integer.toString(year));
        //int month = c.get(Calendar.MONTH);

        //pages switch
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Next button direction
        Button nextButton = (Button) findViewById(R.id.planNext_Button);
        nextButton.setOnClickListener(mOnClickListener);






    }

}
