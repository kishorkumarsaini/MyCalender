package sqldatabase.kishor.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kishor on 3/15/18.
 */

public class SqlHelper extends SQLiteOpenHelper
{
    public static  final String DATABASE_NAME ="MyDb";
    public static  final String TABLE_NAME="Student";
    public static  final String COLUMN1="Name";
    public static  final String COLUMN2="Email";
    public static  final String COLUMN3="Password";




    public SqlHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+"(Name text,Email text,Password Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public  boolean insertData(String Name,String Email,String Password)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN1,Name);
        contentValues.put(COLUMN2,Email);
        contentValues.put(COLUMN3,Password);
           long result= db.insert(TABLE_NAME,null,contentValues);
            if(result==-1)
            {
                return false;

            }
        else
            return true;

    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String name,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN1,name);
        values.put(COLUMN2,email);
        values.put(COLUMN3,password);
        db.update(TABLE_NAME,values,"Name =?",new String[] {name});
        return true;
    }
    public Integer deleteData(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"Name=?",new String[]{name});

    }
}
