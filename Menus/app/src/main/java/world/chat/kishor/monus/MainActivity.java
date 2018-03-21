package world.chat.kishor.monus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String str[]={"Apple","Banana","Orange","Mango","Papaya","Potato"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice,str);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String s1=str[i];
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.myoptionmenu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         super.onOptionsItemSelected(item);
         if(item.getItemId()==R.id.save)
         {
             Toast.makeText(this,"Save Selected",Toast.LENGTH_SHORT).show();
         }
         else if(item.getItemId()==R.id.get)
         {
             Toast.makeText(this,"Get Selected",Toast.LENGTH_SHORT).show();
         }
         else if(item.getItemId()==R.id.reset)
         {
             Toast.makeText(this,"Reset Selected",Toast.LENGTH_SHORT).show();
         }



         return  true;



    }
}
