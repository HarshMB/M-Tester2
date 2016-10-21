package techpalle.com.m_tester;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyAdapter myAdapter;
    TabLayout tabLayout;

    public class MyAdapter extends FragmentPagerAdapter
    {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            SecondFragment secondFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("number",position);
            secondFragment.setArguments(bundle);
            return secondFragment;


           /* switch(position)
            {
                case 0:
                    FirstFragment firstFragment = new FirstFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("number",position);
                    firstFragment.setArguments(bundle);
                    return firstFragment;
                case 1:
                    FirstFragment firstFragment2 = new FirstFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("number",position);
                    firstFragment2.setArguments(bundle2);
                    return firstFragment2;
            }
            return null;*/

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section "+(position+1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        myAdapter = new MyAdapter(getSupportFragmentManager());


        viewPager = (ViewPager) findViewById(R.id.viewPager1);
        viewPager.setAdapter(myAdapter);
        viewPager.setVerticalScrollBarEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabpane);
        tabLayout.setupWithViewPager(viewPager);



        final ActionBar actionBar = getSupportActionBar();
        //tv2.setText(c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+" |");
        CountDownTimer countDownTimer = new CountDownTimer(7200000, 1000) {//30 sec == 30000
            @Override
            public void onTick(long millisUntilFinished) {

                Calendar c = Calendar.getInstance();

                int sec = (int) (millisUntilFinished/1000);
                int min = sec/60;
                sec = sec %60;
                int hour = min/60;
                min = min % 60;
                actionBar.setTitle(hour+":"+min+":"+sec);
                //actionBar.setSubtitle("Aptitude");

            }

            @Override
            public void onFinish() {

                Toast.makeText(SecondActivity.this, "Test Finish", Toast.LENGTH_SHORT).show();

            }
        };
        countDownTimer.start();





        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
