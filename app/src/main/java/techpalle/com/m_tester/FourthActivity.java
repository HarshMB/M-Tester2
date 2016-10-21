package techpalle.com.m_tester;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class FourthActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);


        int right=0,wrong=0;
        String rightQues="", wrongQues="";

        MyDatabase myDatabase = new MyDatabase(this);
        myDatabase.opendb();

        LinkedHashMap userAns = new LinkedHashMap(ThirdFragment.map);
        LinkedHashMap Ans = new LinkedHashMap();

        Cursor c = myDatabase.getAptitudeAnswers();
        while(c.moveToNext()==true)
        {
            Ans.put(c.getInt(0),c.getString(6));
        }

        ArrayList<String> arrayList = new ArrayList<String>(Ans.values());
        ArrayList<String> arrayList2 = new ArrayList<String>(userAns.values());

        int h=0;
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext())
        {
            String ans = (String) iterator.next();
            String userAns2 = arrayList2.get(h);
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Answers="+ans+"\n"+userAns2);
            if(ans.equals(arrayList2.get(h)))
            {
                right++;
                rightQues = rightQues+(h+1)+" ";
                h++;
            }
            else
            {
                wrong++;
                wrongQues = wrongQues+(h+1)+" ";
                h++;
            }
        }

        textView = (TextView) findViewById(R.id.resultTextView);
        textView.setText("Result:\nRight Answers:"+right+"\n("+rightQues+")"+"\nWrong Answers:"+wrong+"\n("+wrongQues+")");



    }
}
