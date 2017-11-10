package mondal.sanat.showhidekeyboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnShowKeyboard;
    Button btnHideKeyboard;
    Button btnNextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.edit_input);
        btnShowKeyboard = (Button) findViewById(R.id.ShowKeyBoard);
        btnHideKeyboard = (Button) findViewById(R.id.HideKeyBoard);
        btnNextScreen = (Button) findViewById(R.id.nextScreen);

        btnShowKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowKeyboard(etInput);
            }
        });

        btnHideKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HideKeyboard(etInput);
            }
        });


        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ShowKeyboard(View v) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(etInput, InputMethodManager.SHOW_IMPLICIT);
    }

    private void HideKeyboard(View v) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
    }


}
