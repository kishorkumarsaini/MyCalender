package world.chat.kishor.monus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopUpMenu extends AppCompatActivity
{

    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);
        button=(Button)findViewById(R.id.buttonOne);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                PopupMenu menu=new PopupMenu(PopUpMenu.this,button);
                menu.getMenuInflater().inflate(R.menu.myoptionmenu,menu.getMenu());
                menu.show();


                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem)
                    {

                        Toast.makeText(PopUpMenu.this, menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });


            }


        });
    }
}
