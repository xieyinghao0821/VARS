package bupt.xyh.vars;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.util.ArrayList;
import java.util.List;

import bupt.xyh.vars.bupt.xyh.vars.model.WiFi;

/**
 * Created by Administrator on 2017/7/25.
 */

public class WifiLocationManager {

    private Context mContext;
    private WifiManager wifiManager;

    public WifiLocationManager(Context context) {
        mContext = context;
        wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
    }

    public void getLocation(BroadcastReceiver receiver) {
        mContext.registerReceiver(receiver, new IntentFilter(
                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();
    }

    public List<ScanResult> getWifiList() {
        return wifiManager.getScanResults();
    }

    public List<WiFi> getLocationWifi() {
        List<ScanResult> wifiList = getWifiList();
        List<WiFi> wifiDatas = new ArrayList<>();
        for (int i = 0; i < wifiList.size(); i++) {
            String macAddress = wifiList.get(i).BSSID;
            String ssid = wifiList.get(i).SSID;
            Integer signalStrength = wifiList.get(i).level;
            wifiDatas.add(new WiFi(macAddress, ssid, signalStrength));
        }
        return wifiDatas;
    }

}
