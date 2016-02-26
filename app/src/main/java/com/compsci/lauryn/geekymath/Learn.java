package com.compsci.lauryn.geekymath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

public class Learn extends AppCompatActivity {

    public static boolean mid;
    public static boolean passed=false;
    public static boolean flipper1;
    public static boolean flipper2;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        if(flipper1){
            mViewPager.setCurrentItem(8,false);
            flipper1=false;
        }
        else if(flipper2){
            mViewPager.setCurrentItem(4,false);
            flipper2=false;
        }
        else if(mid){
            mViewPager.setCurrentItem(8,false);
            mid=false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==R.id.main_menu){//Adds the button to go to MainMenu and clears streak
            Intent intent=new Intent(this,MainMenu.class);
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_learn, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.learnText);
            TextView textView1 = (TextView) rootView.findViewById(R.id.Place1);
            TextView textView2 = (TextView) rootView.findViewById(R.id.Place2);
            TextView textView3 = (TextView) rootView.findViewById(R.id.Place3);
            TextView textView4 = (TextView) rootView.findViewById(R.id.Place4);

            ImageView image1= (ImageView) rootView.findViewById(R.id.Image1);
            ImageView image2= (ImageView) rootView.findViewById(R.id.Image2);

            if (getArguments().getInt(ARG_SECTION_NUMBER)==1) {
                textView.setText(getString(R.string.intro));
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                textView.setText(getString(R.string.decimalsystem));
                textView1 = (TextView) rootView.findViewById(R.id.Place1);
                textView1.setText(getString(R.string.fivehundredtwelve));
                textView1.setTextSize(30);
                textView2.setText(getString(R.string.decimalsystem2));
                textView2.setTextSize(20);
                image2.setImageResource(R.drawable.pic_of_num);

                textView3.setText(getString(R.string.decimalsystem3));
                textView3.setTextSize(20);
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {
                textView.setText(getString(R.string.reading1));
                textView1.setText(getString(R.string.fivehundredtwelve));
                textView1.setTextSize(30);
                textView2.setText(getString(R.string.reading2));
                textView2.setTextSize(20);
                textView3.setText(getString(R.string.ten));
                textView3.setTextSize(30);
                textView4.setText(getString(R.string.reading3));
                textView4.setTextSize(20);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER)==4) {
                textView.setText(getString(R.string.bases));
                image1.setImageResource(R.drawable.graph);

                textView1.setText(getString(R.string.bases2));
                textView1.setTextSize(20);
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==5) {
                textView.setText(getString(R.string.practiceProblems));
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==6){
                if(passed){
                    Learn.flipper1=true;
                }
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==7){
                    Test.practice = true;
                    Intent intent = new Intent(getActivity(), Test.class);
                    startActivity(intent);
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==8){
                if(passed){
                    Learn.flipper2=true;
                }
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==9){
                textView.setText(getString(R.string.practiceProblems2));
                textView1.setText(passed+"");
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==10) {
                textView.setText(getString(R.string.finishingup));
            }
            else
                textView.setText(getString(R.string.invalid));
            textView.setTextSize(20);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 10 total pages.
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Introduction";
                case 1:
                    return "Decimal System";
                case 2:
                    return "Reading";
                case 3:
                    return "Binary System";
                case 4:
                    return "Practice Problems Intro";
                case 5:
                    return "Padding/Redirecting Page";
                case 6:
                    return "Practice Problems";
                case 7:
                    return "Padding/Redirecting Page";
                case 8:
                    return "Practice Problems Finishing";
                case 9:
                    return "Finishing Up";
            }
            return null;
        }
    }
}
