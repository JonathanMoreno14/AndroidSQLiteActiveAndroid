package androidproject.com.androidsqliteactiveandroid;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Jonathan on 6/23/2016.
 */
public class MyApplication extends Application {

    /*
    Initialized ActiveAndroid Library
     */

    @Override
    public void onCreate() {
        super.onCreate();

        //Initializing Active Android
        ActiveAndroid.initialize(this);
    }
}
