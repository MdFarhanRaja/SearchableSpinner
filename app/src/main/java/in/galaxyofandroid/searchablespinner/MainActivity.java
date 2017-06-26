package in.galaxyofandroid.searchablespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinnerItemClickListener;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity
{
    ArrayList<String> items=new ArrayList<>();
    SpinnerDialog spinnerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selectedItems=(TextView)findViewById(R.id.txt);


        items.add("Mumbai");
        items.add("Delhi");
        items.add("Bengaluru");
        items.add("Hyderabad");
        items.add("Ahmedabad");
        items.add("Chennai");
        items.add("Kolkata");
        items.add("Surat");
        items.add("Pune");
        items.add("Jaipur");
        items.add("Lucknow");
        items.add("Kanpur");

        spinnerDialog=new SpinnerDialog(MainActivity.this,items,"Select or Search City",R.style.DialogAnimations_SmileWindow);

        spinnerDialog.bindOnSpinnerListener(new OnSpinnerItemClickListener()
        {
            @Override
            public void onClick(String item, int position)
            {
                Toast.makeText(MainActivity.this, item + "  " + position+"", Toast.LENGTH_SHORT).show();
                selectedItems.setText(item + " Position: " + position);
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                spinnerDialog.showSpinnerDialog();
            }
        });
    }




}
