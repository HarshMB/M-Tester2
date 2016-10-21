package techpalle.com.m_tester;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    TextView tv1,tv2,tv3,tv4,tv6;
    Button b1,b2,b3,b4;
    ImageView imagView2;
    //Button bapti;
    MyDatabase myDatabase;
    Cursor cursor;
    int currentPage;
    String op1,op2,op3,op4;
    /*boolean firstTime=true;
    boolean strBtn1,strBtn2,strBtn3,strBtn4;*/

    static LinkedHashMap map = new LinkedHashMap();

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);


        /*bapti = (Button) v.findViewById(R.id.buttonApti);

        bapti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDatabase.opendb();
                myDatabase.insertCourseData("The length of the bridge, which a train 130 metres long and travelling at 45 km/hr can cross in 30 seconds, is:","200 m","225m","245m","250m","245m",1,0);
                myDatabase.insertCourseData("The cost price of 20 articles is the same as the selling price of x articles. If the profit is 25%, then the value of x is:","15","16","18","25","16",1,0);
                myDatabase.insertCourseData("What percentage of numbers from 1 to 70 have 1 or 9 in the unit's digit?","1","14","20","21","20",1,0);
                myDatabase.insertCourseData("It was Sunday on Jan 1, 2006. What was the day of the week Jan 1, 2010?","Sunday","Saturday","Friday","Wednesday","Friday",1,0);
                myDatabase.insertCourseData("Which one of the following is not a prime number?","31","61","71","91","91",1,0);
                myDatabase.insertCourseData("A man has Rs. 480 in the denominations of one-rupee notes, five-rupee notes and ten-rupee notes. The number of notes of each denomination is equal. What is the total number of notes that he has ?","45","60","75","90","90",1,0);
                myDatabase.insertCourseData("Running at the same constant rate, 6 identical machines can produce a total of 270 bottles per minute. At this rate, how many bottles could 10 such machines produce in 4 minutes?","648","1800","2700","10800","1800",1,0);
                myDatabase.insertCourseData("An aeroplane covers a certain distance at a speed of 240 kmph in 5 hours. To cover the same distance in 1hours, it must travel at a speed of:","300 kmph","360 kmph","600 kmph","720 kmph","720 kmph",1,0);
                myDatabase.insertCourseData("A father said to his son, \"I was as old as you are at the present at the time of your birth\". If the father's age is 38 years now, the son's age five years back was:","14 years","19 years","33 years","38 years","14 years",1,0);
                myDatabase.insertCourseData("Two pipes can fill a tank in 20 and 24 minutes respectively and a waste pipe can empty 3 gallons per minute. All the three pipes working together can fill the tank in 15 minutes. The capacity of the tank is:","60 gallons","100 gallons","120 gallons","180 gallons","120 gallons",1,0);
                myDatabase.insertCourseData("How many kilogram of sugar costing Rs. 9 per kg must be mixed with 27 kg of sugar costing Rs. 7 per kg so that there may be a gain of 10% by selling the mixture at Rs. 9.24 per kg?","36 kg","42 kg","54 kg","63 kg","63 kg",1,0);

            }
        });*/


        Bundle bundle = getArguments();
        final int pos = bundle.getInt("number");
        currentPage = pos;
        System.out.println("*************************************************Number in first fragment=" + pos);


       /* final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("isSelect",0);

        if(firstTime == true)
        {
            //System.out.println("****************************************************firstTime=true");
            strBtn1 = sharedPreferences.getBoolean(pos+"1", false);
            //System.out.println("****************************************************strBtn1="+strBtn1);
            strBtn2 = sharedPreferences.getBoolean(pos+"2", false);
            //System.out.println("****************************************************strBtn2="+strBtn2);
            strBtn3 = sharedPreferences.getBoolean(pos+"3", false);
            //System.out.println("****************************************************strBtn3="+strBtn3);
            strBtn4 = sharedPreferences.getBoolean(pos+"4", false);
            //System.out.println("****************************************************strBtn4="+strBtn4);

        }
        else
        {
            System.out.println("****************************************************firstTime=false");
            if(strBtn1 == true)
            {
                b1.setBackgroundResource(R.drawable.selectedop);
            }
            else if(strBtn2 == true)
            {
                b2.setBackgroundResource(R.drawable.selectedop);
            }
            else if(strBtn3 == true)
            {
                b3.setBackgroundResource(R.drawable.selectedop);
            }
            else if(strBtn4 == true)
            {
                b4.setBackgroundResource(R.drawable.selectedop);
            }
        }*/


        tv1 = (TextView) v.findViewById(R.id.textView1);
        //tv2 = (TextView) v.findViewById(R.id.textView2);
        tv3 = (TextView) v.findViewById(R.id.textView3);
        tv4 = (TextView) v.findViewById(R.id.textView4);
        tv6 = (TextView) v.findViewById(R.id.textView6);
        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);
        b3 = (Button) v.findViewById(R.id.button3);
        b4 = (Button) v.findViewById(R.id.button4);
        imagView2 = (ImageView) v.findViewById(R.id.imageView2);


        myDatabase = new MyDatabase(getActivity());
        myDatabase.opendb();

        cursor = myDatabase.getAptitudeData(pos+1);

        while(cursor.moveToNext()==true)
        {
            //System.out.println("#####################################################"+cursor.getInt(0)+cursor.getFloat(7)+cursor.getFloat(8)+cursor.getString(1)+cursor.getString(2)+cursor.getString(3)+cursor.getString(4)+cursor.getString(5));
            tv1.setText(""+cursor.getInt(0));
            tv3.setText(""+cursor.getFloat(7));
            tv4.setText(""+cursor.getFloat(8));
            tv6.setText(cursor.getString(1));

            op1 = new String(cursor.getString(2));
            op2 = new String(cursor.getString(3));
            op3 = new String(cursor.getString(4));
            op4 = new String(cursor.getString(5));

            b1.setText("1.  "+op1);
            b2.setText("2.  "+op2);
            b3.setText("3.  "+op3);
            b4.setText("4.  "+op4);

        }

        imagView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imagView2.getTag().equals("bookmarked"))
                {
                    imagView2.setImageResource(R.drawable.review);
                    imagView2.setTag("review");
                }
                else {
                    imagView2.setImageResource(R.drawable.bookmarked);
                    imagView2.setTag("bookmarked");
                }

            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundResource(R.drawable.selectedop);
                b2.setBackgroundResource(R.drawable.rect);
                b3.setBackgroundResource(R.drawable.rect);
                b4.setBackgroundResource(R.drawable.rect);

                map.put(pos, op1);

                /*SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(pos+"1", true);
                editor.commit();
                firstTime = false;*/

                ThirdActivity thirdActivity = (ThirdActivity) getActivity();
                thirdActivity.nextPage(currentPage);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundResource(R.drawable.selectedop);
                b1.setBackgroundResource(R.drawable.rect);
                b3.setBackgroundResource(R.drawable.rect);
                b4.setBackgroundResource(R.drawable.rect);

                map.put(pos,op2);

                /*SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(pos+"2", true);
                editor.commit();
                firstTime = false;*/

                ThirdActivity thirdActivity = (ThirdActivity) getActivity();
                thirdActivity.nextPage(currentPage);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackgroundResource(R.drawable.selectedop);
                b2.setBackgroundResource(R.drawable.rect);
                b4.setBackgroundResource(R.drawable.rect);
                b1.setBackgroundResource(R.drawable.rect);

                map.put(pos,op3);

                /*SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(pos+"3", true);
                editor.commit();
                firstTime = false;*/

                ThirdActivity thirdActivity = (ThirdActivity) getActivity();
                thirdActivity.nextPage(currentPage);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setBackgroundResource(R.drawable.selectedop);
                b2.setBackgroundResource(R.drawable.rect);
                b3.setBackgroundResource(R.drawable.rect);
                b1.setBackgroundResource(R.drawable.rect);

                map.put(pos,op4);

                /*SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(pos+"4", true);
                editor.commit();
                firstTime = false;*/

                ThirdActivity thirdActivity = (ThirdActivity) getActivity();
                thirdActivity.nextPage(currentPage);
            }
        });


        return v;

    }

}
