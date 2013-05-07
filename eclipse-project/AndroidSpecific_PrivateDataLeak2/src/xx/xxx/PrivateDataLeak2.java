package xx.xxx;

import xx.xxx.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
/**
 * @testcase_name PrivateDataLeak2
 * @version 0.1
 * 
 * @description A value from a password field is written to the log
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges the analysis has to treat the value of password fields as source
 */
public class PrivateDataLeak2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_data_leak2);
        
        EditText mEdit   = (EditText)findViewById(R.id.pwField);
		Log.v("Password", mEdit.getText().toString()); //source, sink, leak
    }
}
