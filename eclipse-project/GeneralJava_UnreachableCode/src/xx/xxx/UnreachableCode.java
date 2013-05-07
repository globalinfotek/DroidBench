package xx.xxx;

import xx.xxx.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
/**
 * @testcase_name UnreachableCode
 * @version 0.1
 * 
 * @description A method that is never called contains a dataflow from source to sink
 * @dataflow source -> deviceid -> sink
 * @number_of_leaks 1
 * @challenges the analysis has to discover that the unit is not called
 */
public class UnreachableCode extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unreachable_code);
    }

    //this method is never called
  	private void unreachable(){
  		TelephonyManager tm =(TelephonyManager)getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
  		String deviceid = tm.getDeviceId(); //source
  		
  		Log.i("INFO", deviceid); //sink
  	}
    
}
