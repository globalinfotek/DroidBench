package xx.xxx;

import xx.xxx.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
/**
 * @testcase_name ImplicitFlow2
 * @version 0.1
 * 
 * @description Based on an input of a password field a log message is written
 * @dataflow source -> userInputPassword -> if-condition -> sink
 * @number_of_leaks 2
 * @challenges the analysis must be able to handle implicit flows,
 *  detect callbacks from layout xml file and treat the value of password fields as source
 */
public class ImplicitFlow2 extends Activity {
	private boolean passwordCorrect = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_flow2);
    }

    public void checkPassword(View view){
		EditText mEdit = (EditText)findViewById(R.id.password);
		String userInputPassword = mEdit.getText().toString(); //source
		
		if(userInputPassword.equals("superSecure"))
			passwordCorrect = true;
		
		if(passwordCorrect)
			Log.i("INFO", "Password is correct"); //sink, leak
		else
			Log.i("INFO", "Password is not correct"); //sink, leak
	}
    
}
