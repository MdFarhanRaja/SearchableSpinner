package in.galaxyofandroid.searchablespinner;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinnerItemClickListener;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import in.galaxyofandroid.spinerdialog.SpinnerDialogItem;

public class MainActivity extends AppCompatActivity {
    ArrayList<SpinnerDialogItem> items = new ArrayList<>();
    SpinnerDialog spinnerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selectedItems = (TextView) findViewById(R.id.txt);

        items.add(new SpinnerDialogItem("MU", "Mumbai"));
        items.add(new SpinnerDialogItem("DE", "Delhi"));
        items.add(new SpinnerDialogItem("BE", "Bengaluru"));
        items.add(new SpinnerDialogItem("HY", "Hyderabad"));
        items.add(new SpinnerDialogItem("AH", "Ahmedabad"));
        items.add(new SpinnerDialogItem("CH", "Chennai"));
        items.add(new SpinnerDialogItem("KO", "Kolkata"));
        items.add(new SpinnerDialogItem("SU", "Surat"));
        items.add(new SpinnerDialogItem("PU", "Pune"));
        items.add(new SpinnerDialogItem("JA", "Jaipur"));
        items.add(new SpinnerDialogItem("LU", "Lucknow"));
        items.add(new SpinnerDialogItem("KA", "Kanpur"));

        spinnerDialog = new SpinnerDialog(MainActivity.this, items, "Select or Search City", R.style.SpinnerDialogSlideFromBottomAnimation);

        spinnerDialog.bindOnSpinnerListener(new OnSpinnerItemClickListener() {
            @Override
            public void onClick(String id, String value, int position) {
                Toast.makeText(MainActivity.this, format(id, value, position), Toast.LENGTH_SHORT).show();
                selectedItems.setText(format(id, value, position));
            }

            @NonNull
            private String format(String id, String value, int position) {
                return id + " " + value + " " + position;
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog.showSpinnerDialog();
            }
        });
    }


}
