package techpalle.com.m_tester;

import android.content.Context;
import android.database.Cursor;

import java.util.LinkedHashMap;

/**
 * Created by HARSH on 10/19/2016.
 */
public class Result {

    private String correctAns[][];
    private String candidateAns[][];
    int rightAns = 0, wrongAns = 0;
    String rightAnsNos[], wrongAnsNos[];
    static Cursor cursor;


    public Result(Context c)
    {
        LinkedHashMap map = new LinkedHashMap();
        cursor = new MyDatabase(c).getAptitudeAnswers();

        while(cursor.moveToNext()==true)
        {
            System.out.println("#####################################################"+cursor.getInt(0)+cursor.getString(6)+"\n");
        }
    }

    public static void main(String[] a) {



    }


}
