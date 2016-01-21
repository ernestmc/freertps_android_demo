/*
 * Copyright 2015 Ekumen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.rosjava.android.androidp1;


import org.ros.android.RosActivity;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeListener;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

import android.content.Context;
import android.content.BroadcastReceiver;
import android.util.Log;
import android.os.Bundle;
import android.view.WindowManager;
import android.content.res.Configuration;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import java.net.URI;

public class Androidp1 extends RosActivity
{
    private static final String TAG = "Androidp1";
    
    private NodeMainExecutor nodeMainExecutor = null;
    private URI masterUri;
    private String hostName;
    final static String appName = "FreeRTPS_Listener";
    FreeRTPSListener listener;
    
   
    public Androidp1()
    {
        super(appName, appName);
    }
    
    /**
    * Called when the activity is first created.
    */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Keep the screen always on
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor)
    {
        Log.i(TAG, "Androidp1 init");
        
        // Store a reference to the NodeMainExecutor and unblock any processes that were waiting
        // for this to start ROS Nodes
        this.nodeMainExecutor = nodeMainExecutor;
        masterUri = getMasterUri();
        hostName = getRosHostname();

        Log.i(TAG, masterUri.toString());
        
        Log.i(TAG, "Creating new RTPS Listener...");
        listener = new FreeRTPSListener();
        Log.i(TAG, "Invoking listener method...");
        listener.listener();
    }
    
    public void onStart(final ConnectedNode connectedNode)
    {
    }
    
    public void onStop()
    {
        super.onStop();
        Log.i(TAG, "Androidp1 stopping...");
    }
    
    public void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, "Androidp1 destroying...");
    }
}
