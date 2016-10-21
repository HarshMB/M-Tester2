package techpalle.com.m_tester;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    TextView tv4,tv1,tv2;
    Button b1;
    //Button btn;
    MyDatabase myDatabase;
    Cursor cursor;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

          /*btn = (Button) view.findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDatabase.opendb();
                myDatabase.insertExamData("Aptitude",20,20);
                myDatabase.insertExamData("Puzzle",10,10);
                myDatabase.insertExamData("Technical",30,30);

            }
        });*/


        tv1 = (TextView) view.findViewById(R.id.textView1);
        tv2 = (TextView) view.findViewById(R.id.textView2);
        tv4 = (TextView) view.findViewById(R.id.textView4);
        b1 = (Button) view.findViewById(R.id.button1);

        Bundle bundle = getArguments();
        int pos = bundle.getInt("number");


        myDatabase = new MyDatabase(getActivity());
        myDatabase.opendb();

        cursor = myDatabase.getExamData(pos+1);

        while(cursor.moveToNext()==true)
        {
            tv1.setText(""+cursor.getInt(2));
            tv2.setText(""+cursor.getInt(3));
            tv4.setText(""+cursor.getString(1));
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(),ThirdActivity.class);
                startActivity(i);

            }
        });


        return view;
    }

}
