package world.chat.kishor.monus;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CutomizeAlertDialog extends AppCompatActivity
{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomize_alert_dialog);
        button=(Button)findViewById(R.id.Button23);

    }
    public void onPress(View view)
    {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.mylayout);
        dialog.show();
        final EditText editText=(EditText)dialog.findViewById(R.id.editText22);
        Button button=(Button)dialog.findViewById(R.id.Button33);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String str=editText.getText().toString();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
