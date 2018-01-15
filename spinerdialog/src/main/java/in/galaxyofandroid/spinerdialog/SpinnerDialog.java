package in.galaxyofandroid.spinerdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Md Farhan Raja on 2/23/2017.
 */

public class SpinnerDialog {
    ArrayList<String> items;
    Activity context;
    String dTitle,closeTitle="Close";
    OnSpinerItemClick onSpinerItemClick;
    AlertDialog alertDialog;
    int pos;
    int style;


    public SpinnerDialog(Activity activity, ArrayList<String> items, String dialogTitle) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
    }

    public SpinnerDialog(Activity activity, ArrayList<String> items, String dialogTitle,String closeTitle) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.closeTitle=closeTitle;
    }

    public SpinnerDialog(Activity activity, ArrayList<String> items, String dialogTitle, int style) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.style = style;
    }

    public SpinnerDialog(Activity activity, ArrayList<String> items, String dialogTitle, int style,String closeTitle) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.style = style;
        this.closeTitle=closeTitle;
    }

    public void bindOnSpinerListener(OnSpinerItemClick onSpinerItemClick1) {
        this.onSpinerItemClick = onSpinerItemClick1;
    }

    public void showSpinerDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        View v = context.getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView rippleViewClose = (TextView) v.findViewById(R.id.close);
        TextView title = (TextView) v.findViewById(R.id.spinerTitle);
        rippleViewClose.setText(closeTitle);
        title.setText(dTitle);
        final ListView listView = (ListView) v.findViewById(R.id.list);
        final EditText searchBox = (EditText) v.findViewById(R.id.searchBox);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.items_view, items);
        listView.setAdapter(adapter);
        adb.setView(v);
        alertDialog = adb.create();
        alertDialog.getWindow().getAttributes().windowAnimations = style;//R.style.DialogAnimations_SmileWindow;
        alertDialog.setCancelable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t = (TextView) view.findViewById(R.id.text1);
                for (int j = 0; j < items.size(); j++) {
                    if (t.getText().toString().equalsIgnoreCase(items.get(j).toString())) {
                        pos = j;
                    }
                }
                onSpinerItemClick.onClick(t.getText().toString(), pos);
                alertDialog.dismiss();
            }
        });

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(searchBox.getText().toString());
            }
        });

        rippleViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

}
