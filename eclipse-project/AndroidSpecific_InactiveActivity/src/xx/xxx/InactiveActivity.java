package xx.xxx;

import xx.xxx.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
/**
 * @testcase_name InactiveActivity
 * @version 0.1
 * 
 * @description A value from a source is written to the log but the activity is not active
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis has to be aware that the activity is set to inactive in manifest file
 */
public class InactiveActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inactive);
        
        TelephonyManager  mTelephonyMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String imei = mTelephonyMgr.getDeviceId(); //source
		
		Log.i("INFO", imei); //sink
    }    
}
