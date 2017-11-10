package mondal.sanat.showhidekeyboard;

/**
 * Created by Sanat on 10/13/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity implements OnKeyListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setOnKeyListener(this);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setOnKeyListener(this);

    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {

        TextView responseText = (TextView) findViewById(R.id.responseText);
        EditText myEditText = (EditText) view;

        if (keyCode == EditorInfo.IME_ACTION_SEARCH ||
                keyCode == EditorInfo.IME_ACTION_DONE ||
                event.getAction() == KeyEvent.ACTION_DOWN &&
                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

            if (!event.isShiftPressed()) {
                Log.v("AndroidEnterKeyActivity","Enter Key Pressed!");
                switch (view.getId()) {
                    case R.id.editText1:
                        responseText
                                .setText("Just pressed the ENTER key, " +
                                        "focus was on Text Box1. " +
                                        "You typed:\n" + myEditText.getText());
                        break;
                    case R.id.editText2:
                        responseText
                                .setText("Just pressed the ENTER key, " +
                                        "focus was on Text Box2. " +
                                        "You typed:\n" + myEditText.getText());
                        break;
                }
                return true;
            }

        }
        return false; // pass on to other listeners.

    }

}