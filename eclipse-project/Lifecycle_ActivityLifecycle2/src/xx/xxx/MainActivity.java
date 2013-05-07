package xx.xxx;

import xx.xxx.R;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
/**
 * @testcase_name ActivityLifecycle2
 * @version 0.1
 * 
 * @description The return value of source method is stored to a static variable in one callback method
 *  and sent to a sink in a different callback method
 * @dataflow onCreate: source -> imei; onResume: imei -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to handle the activity lifecycle correctly
 *  and detect the callback method that is inherited from a superclass
 */
public class MainActivity extends GeneralActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		imei = telephonyManager.getDeviceId(); //source
    }    
}
