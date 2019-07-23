package in.galaxyofandroid.searchablespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnAfterTextChangedListener;
import in.galaxyofandroid.spinerdialog.OnLoadMore;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialogPaged;

public class MainActivityPaged extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    SpinnerDialogPaged mSpinnerDialogPaged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selectedItems = (TextView) findViewById(R.id.txt);


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
        items.add("Maceió");
        items.add("Recife");
        items.add("Pernambuco");
        items.add("Macapá");
        items.add("Fortaleza");
        items.add("Tocantins");
        items.add("Atalaia");
        items.add("Satuba");
        items.add("Pilar");

        mSpinnerDialogPaged = new SpinnerDialogPaged(MainActivityPaged.this, items,
                "Select");

        mSpinnerDialogPaged.setTitleColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setSearchIconColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setSearchTextColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setItemColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setItemDividerColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setCloseColor(getResources().getColor(R.color.colorAccent));

        mSpinnerDialogPaged.setCancellable(true);
        mSpinnerDialogPaged.setShowKeyboard(false);

        mSpinnerDialogPaged.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivityPaged.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
                selectedItems.setText(item + " Position: " + position);
            }
        });

        // set threshold
        mSpinnerDialogPaged.setVisibleThreshold(5);
        // hide or show search field with true of false
        mSpinnerDialogPaged.setHideSearchField(false);

        mSpinnerDialogPaged.bindOnLoadMoreListener(new OnLoadMore() {
            @Override
            public void onLoadMore(int page) {
                // call api request
            }
        });

        mSpinnerDialogPaged.bindOnAfterTextChanged(new OnAfterTextChangedListener() {
            @Override
            public void onAfterTextChanged(String term) {
                // get the search term
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinnerDialogPaged.showSpinerDialog();
            }
        });
    }

}
