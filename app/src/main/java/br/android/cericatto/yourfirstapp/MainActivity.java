package br.android.cericatto.yourfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private TextView mFirstIngredientTextView;
    private TextView mSecondIngredientTextView;
    private TextView mThirdIngredientTextView;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private void setLayout() {
        mFirstIngredientTextView = (TextView)findViewById(R.id.id_first_ingredient);
        mFirstIngredientTextView.setOnClickListener(this);

        mSecondIngredientTextView = (TextView)findViewById(R.id.id_second_ingredient);
        mSecondIngredientTextView.setOnClickListener(this);

        mThirdIngredientTextView = (TextView)findViewById(R.id.id_third_ingredient);
        mThirdIngredientTextView.setOnClickListener(this);
    }

    private void callListDialog(final int viewId) {
        new MaterialDialog.Builder(this).title(R.string.choose_ingredient)
                .items(R.array.array_ingredients).itemsCallback(new MaterialDialog.ListCallback() {
            @Override
            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                switch (viewId) {
                    case R.id.id_first_ingredient:
                        mFirstIngredientTextView.setText(text);
                        break;
                    case R.id.id_second_ingredient:
                        mSecondIngredientTextView.setText(text);
                        break;
                    case R.id.id_third_ingredient:
                        mThirdIngredientTextView.setText(text);
                        break;
                }
            }
        }).show();
    }

    //--------------------------------------------------
    // View.OnClickListener
    //--------------------------------------------------

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_first_ingredient:
            case R.id.id_second_ingredient:
            case R.id.id_third_ingredient:
                callListDialog(view.getId());
                break;
        }
    }
}