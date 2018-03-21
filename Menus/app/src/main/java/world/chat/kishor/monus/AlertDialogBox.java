package world.chat.kishor.monus;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogBox extends AppCompatActivity
{
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_box);
        button=(Button)findViewById(R.id.myButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openAlert(view);

            }
        });
    }

    private void openAlert(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(AlertDialogBox.this);
        builder.setTitle("Demo Of AlertDialogBox");
        builder.setMessage("Do u want to proceed");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent main=new Intent(AlertDialogBox.this,MainActivity.class);
                startActivity(main);


            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {


            }
        });
        builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                finish();

            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
