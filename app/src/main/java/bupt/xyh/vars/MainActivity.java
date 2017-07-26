package bupt.xyh.vars;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import bupt.xyh.vars.bupt.xyh.vars.adapter.WiFiAdapter;
import bupt.xyh.vars.bupt.xyh.vars.model.WiFi;
import bupt.xyh.vars.bupt.xyh.vars.util.Util;

public class MainActivity extends Activity {

    private Button mButton;
    private WifiLocationManager wifiLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn_get_info);
        wifiLocation = new WifiLocationManager(MainActivity.this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity:", "on mButton Click!!!");
                getLocation();
            }
        });

    }

    private void getLocation() {
        //boolean isNet = Util.isNetworkAvaliable(MainActivity.this);
        /*
        if(!isNet){
            Toast.makeText(MainActivity.this, "网络不可用：打开网络或数据连接！！！", Toast.LENGTH_LONG).show();
            Log.i("Main-getLocation:","Network not avaliable");
            return;
        }
        */
        boolean isWifi = Util.isWifiNetwrokType(MainActivity.this);
        if (isWifi) {
            Log.i("Main-getLocation:", "WiFi定位");
            wifiLocation.getLocation(new WifiReceiver());
        } else {
            Log.i("Main-getLocation:", "not WiFi");
            Toast.makeText(MainActivity.this,"请先打开WiFi",Toast.LENGTH_SHORT).show();
        }
    }

    class WifiReceiver extends BroadcastReceiver {
        public void onReceive(Context c, Intent intent) {
            Log.i("get broadcastReceiver:", " SCAN_RESULTS_AVAILABLE_ACTION");
            List<WiFi> wifiDatas = wifiLocation.getLocationWifi();
            WiFiAdapter adapter = new WiFiAdapter(MainActivity.this, R.layout.wifi_item, wifiDatas);
            ListView mListView = (ListView) findViewById(R.id.wifi_list);
            mListView.setAdapter(adapter);
        }
    }
}
