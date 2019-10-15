package in.galaxyofandroid.searchablespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnAfterTextChangedListener;
import in.galaxyofandroid.spinerdialog.OnLoadMoreListener;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialogPaged;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivityPaged extends AppCompatActivity {

    ArrayList<String> mItems = new ArrayList<>();
    SpinnerDialogPaged mSpinnerDialogPaged;
    TextView mSelectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSelectedItems = findViewById(R.id.txt);

        mSpinnerDialogPaged = new SpinnerDialogPaged(MainActivityPaged.this, mItems,
                "Select");

        mSpinnerDialogPaged.setTitleColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setSearchIconColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setSearchTextColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setItemColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setItemDividerColor(getResources().getColor(R.color.colorAccent));
        mSpinnerDialogPaged.setCloseColor(getResources().getColor(R.color.colorAccent));

        mSpinnerDialogPaged.setCancellable(true); // for cancellable
        mSpinnerDialogPaged.setShowKeyboard(false); // for open keyboard by default
        mSpinnerDialogPaged.setVisibleThreshold(3); // set visible threshold
        mSpinnerDialogPaged.setHideSearchField(true); // hide or show search field with true of false

        getUsers(1); // make your request for api

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinnerDialogPaged.showSpinerDialog();
            }
        });


        mSpinnerDialogPaged.bindOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(int page) {
                getUsers(page); // make your request for api with the new page returned
            }
        });

        mSpinnerDialogPaged.bindOnAfterTextChanged(new OnAfterTextChangedListener() {
            @Override
            public void onAfterTextChanged(String term) {
                // get the search term
            }
        });

    }

    private void getUsers(int page) {
        mSpinnerDialogPaged.showProgressBar(); // show the progress bar before your request

        RetrofitConfig.createService(UserService.class).getUsers(page).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    mSpinnerDialogPaged.hideProgressBar(); // hide the progress bar after your request

                    for (Data item : response.body().getData()) {
                        mItems.add(item.getEmail());
                    }

                    mSpinnerDialogPaged.addMoreItems(mItems);
                    mSpinnerDialogPaged.bindOnSpinerListener(new OnSpinerItemClick() {
                        @Override
                        public void onClick(String item, int position) {
                            Toast.makeText(MainActivityPaged.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
                            mSelectedItems.setText(item + " Position: " + position);

                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }


}
