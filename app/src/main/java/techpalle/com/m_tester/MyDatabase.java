package techpalle.com.m_tester;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HARSH on 10/19/2016.
 */
public class MyDatabase {


    MyHelper m;
    SQLiteDatabase s;

    public MyDatabase(Context c)
    {
        m = new MyHelper(c, "techpalle.db",null,1);
    }//null-cursor factory




    public void opendb()
    {
        s = m.getWritableDatabase();
    }

    public void insertExamData(String tname, int que, int marks)
    {
        ContentValues c = new ContentValues();
        c.put("topicname",tname);
        c.put("question",que);
        c.put("marks",marks);
        s.insert("exams", null, c);
    }

    public Cursor getExamData(int pos)
    {
        Cursor c = null;
        c = s.query("exams",null,"_id=?",new String[]{""+pos},null,null,null);
        return c;
    }

    public void insertAptitudeData(String que, String op1, String op2, String op3, String op4, String ans, float posMark, float negMark)
    {
        ContentValues c = new ContentValues();
        c.put("question",que);
        c.put("op1",op1);
        c.put("op2",op2);
        c.put("op3",op3);
        c.put("op4",op4);
        c.put("ans",ans);
        c.put("positive",posMark);
        c.put("negative",negMark);
        s.insert("aptitude", null, c);
    }

    public Cursor getAptitudeData(int pos)
    {
        Cursor c = null;
        c = s.query("aptitude",null,"_id=?",new String[]{""+pos},null,null,null);
        return c;
    }

    public Cursor getAptitudeAnswers()
    {
        Cursor c = null;
        c = s.query("aptitude",null,null,null,null,null,null);
        return c;
    }


    public class MyHelper extends SQLiteOpenHelper
    {

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table aptitude(_id integer primary key, question text, op1 text, op2 text, op3 text, op4 text, ans text, positive float, negative float);");
            db.execSQL("create table exams(_id integer primary key, topicname text, question integer, marks integer);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }



}
