package com.github.rosjava.android.androidp1;

import android.util.Log;

public class FreeRTPSListener {
  public FreeRTPSListener() {
    Log.i("androidp1", "Loading listener library...");
    try {
      System.loadLibrary("freertps_listener");
    }
    catch (SecurityException e)
    {
      Log.i("androidp1", "Error loading library! SecurityException\n" + e);
    }
    catch (UnsatisfiedLinkError e)
    {
      Log.i("androidp1", "Error loading library! UnsatisfiedLinkError\n" + e);
    }
    catch (NullPointerException e)
    {
      Log.i("androidp1", "Error loading library! NullPointerException\n" + e);
    }
    Log.i("androidp1", "After loading listener library.");
  }

  /**
  * Native method implemented in C/C++
  */
  public native int listener();
  
}
