package sqldatabase.kishor.sqldatabase;

import android.database.Cursor;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Name,Email,Password;
    Button Register,ShowData,UpdateData,DeleteData;
    SqlHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.Name);
        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Password);
        Register=(Button)findViewById(R.id.register);
        ShowData=(Button)findViewById(R.id.showdata);
        UpdateData=(Button)findViewById(R.id.update);
        DeleteData=(Button)findViewById(R.id.deleteData);
        sqlHelper=new SqlHelper(this);
        AddData();
        ShowData();
        UpdateData();
        DeleteData();

    }

    private void DeleteData()
    {
        DeleteData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer result=sqlHelper.deleteData(Name.getText().toString());

                if(result>0)
                {
                    Toast.makeText(getApplicationContext(), "Delete Data Success", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Deletion Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void UpdateData()
    {
        UpdateData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               boolean update= sqlHelper.updateData(Name.getText().toString(),Email.getText().toString(),Password.getText().toString());

                if(!Name.getText().toString().equals("") && !Email.getText().toString().equals("") &&  !Password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Data", Toast.LENGTH_SHORT).show();

                    if (update == true) {

                        Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_SHORT).show();
                    }
                }
               else
               {
                   Toast.makeText(getApplicationContext(),"Update Failed",Toast.LENGTH_SHORT).show();
               }

            }

        });

    }

    public void AddData()
    {

        Register.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
               boolean result= sqlHelper.insertData(Name.getText().toString(),Email.getText().toString(),Password.getText().toString());

                if(!Name.getText().toString().equals("") && !Email.getText().toString().equals("") &&  !Password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Data", Toast.LENGTH_SHORT).show();

                    if (result == true) {
                        Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();

                    }
                }
                    else {
                        Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                    }


            }
        });
    }

    public void ShowData()
    {

        ShowData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Cursor rs= sqlHelper.getAllData();
                if(rs.getCount()==0)
                {
                    show("Error","Nothing Found");
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (rs.moveToNext()) {
                    stringBuffer.append("Name="+rs.getString(0)+"\n");
                    stringBuffer.append("Email="+rs.getString(1)+"\n");
                    stringBuffer.append("Password="+rs.getString(2)+"\n");
                }

                show("Data",stringBuffer.toString());

            }
        });


    }
    public void  show(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
