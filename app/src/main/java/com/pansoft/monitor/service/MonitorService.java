package com.pansoft.monitor.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

import static android.view.accessibility.AccessibilityEvent.TYPES_ALL_MASK;
import static android.view.accessibility.AccessibilityEvent.TYPE_ANNOUNCEMENT;
import static android.view.accessibility.AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT;
import static android.view.accessibility.AccessibilityEvent.TYPE_GESTURE_DETECTION_END;
import static android.view.accessibility.AccessibilityEvent.TYPE_GESTURE_DETECTION_START;
import static android.view.accessibility.AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
import static android.view.accessibility.AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END;
import static android.view.accessibility.AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START;
import static android.view.accessibility.AccessibilityEvent.TYPE_TOUCH_INTERACTION_END;
import static android.view.accessibility.AccessibilityEvent.TYPE_TOUCH_INTERACTION_START;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_CLICKED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_FOCUSED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_HOVER_ENTER;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_HOVER_EXIT;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_LONG_CLICKED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_SCROLLED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_SELECTED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
import static android.view.accessibility.AccessibilityEvent.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
import static android.view.accessibility.AccessibilityEvent.TYPE_WINDOWS_CHANGED;
import static android.view.accessibility.AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED;
import static android.view.accessibility.AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;

/**
 * Created by meijun on 17-7-6.
 */

public class MonitorService extends AccessibilityService {
    private static final String TAG = "MonitorService";
    private AccessibilityManager mAccessibilityManager;


      boolean isOpenCamera = false;
    //扬声器默认使打开的;
        boolean isOpenVoice = true;
    int i  = 0;
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e(TAG, "getEventType: " + event.getEventType() + "----" + AccessibilityEvent.eventTypeToString(event.getEventType()));
        Log.e(TAG, "getPackageName: " + event.getPackageName());
        Log.e(TAG, "getText: " + event.getText());
        Log.e(TAG, "toString: " + event.toString());

        i++;
        Log.e(TAG,"---------------" +i+  "  --------------------- \n\n\n" );
        Log.e(TAG, "                    " );
       accessibilityEventHelper(event);

    }

    private void accessibilityEventHelper(AccessibilityEvent event) {
        int eventType = event.getEventType();
        if (eventType == TYPES_ALL_MASK) {
            Log.e(TAG, "accessibilityEventHelper: TYPES_ALL_MASK");
        }
        switch (eventType) {
            case TYPE_VIEW_CLICKED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_CLICKED");
            }
            break;
            case TYPE_VIEW_LONG_CLICKED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_LONG_CLICKED");
            }
            break;
            case TYPE_VIEW_SELECTED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_SELECTED");
            }
            break;
            case TYPE_VIEW_FOCUSED: {

                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_FOCUSED");
            }
            break;
            case TYPE_VIEW_TEXT_CHANGED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_TEXT_CHANGED");
            }
            break;
            case TYPE_WINDOW_STATE_CHANGED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_WINDOW_STATE_CHANGED");
                holdPhone();
                if(isOpenCamera){
                    //关闭扬声器
                    closeVoice();


                }

            }
            break;
            case TYPE_VIEW_HOVER_ENTER: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_HOVER_ENTER");
            }
            break;
            case TYPE_VIEW_HOVER_EXIT: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_HOVER_EXIT");
            }
            break;
            case TYPE_NOTIFICATION_STATE_CHANGED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_NOTIFICATION_STATE_CHANGED");
            }
            break;
            case TYPE_TOUCH_EXPLORATION_GESTURE_START: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_TOUCH_EXPLORATION_GESTURE_START");
            }
            break;
            case TYPE_TOUCH_EXPLORATION_GESTURE_END: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_TOUCH_EXPLORATION_GESTURE_END");
            }
            break;
            case TYPE_WINDOW_CONTENT_CHANGED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_WINDOW_CONTENT_CHANGED");

            }
            break;
            case TYPE_VIEW_TEXT_SELECTION_CHANGED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_TEXT_SELECTION_CHANGED");
            }
            break;
            case TYPE_VIEW_SCROLLED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_SCROLLED");
            }
            break;
            case TYPE_ANNOUNCEMENT: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_ANNOUNCEMENT");
            }
            break;
            case TYPE_VIEW_ACCESSIBILITY_FOCUSED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
            }
            break;
            case TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
            }
            break;
            case TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY");
            }
            break;
            case TYPE_GESTURE_DETECTION_START: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_GESTURE_DETECTION_START");
            }
            break;
            case TYPE_GESTURE_DETECTION_END: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_GESTURE_DETECTION_END");
            }
            break;
            case TYPE_TOUCH_INTERACTION_START: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_TOUCH_INTERACTION_START");
            }
            break;
            case TYPE_TOUCH_INTERACTION_END: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_TOUCH_INTERACTION_END");
            }
            break;
            case TYPE_WINDOWS_CHANGED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_WINDOWS_CHANGED");
            }
            break;
            case TYPE_VIEW_CONTEXT_CLICKED: {
                Log.e(TAG, "accessibilityEventHelper: " + "TYPE_VIEW_CONTEXT_CLICKED");
            }
            break;
            case TYPE_ASSIST_READING_CONTEXT: {
            }
            Log.e(TAG, "accessibilityEventHelper: " + "TYPE_ASSIST_READING_CONTEXT");
            break;
        }
    }

    /**
     * 关闭扬声器
     */
    private void closeVoice() {

        if(!isOpenVoice){
            //此时已经关闭不要往下走了;
            return ;
        }
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        if(rootInActiveWindow==null){
            return;
        }

        List<AccessibilityNodeInfo> voices= rootInActiveWindow.findAccessibilityNodeInfosByText("扬声器");

        for (int i1 = 0;voices!=null &&  i1 < voices.size(); i1++) {

            AccessibilityNodeInfo accessibilityNodeInfo = voices.get(i1);
            Log.e(TAG, "closeVoice: "+ accessibilityNodeInfo.toString() );
            boolean b = accessibilityNodeInfo.performAction(TYPE_VIEW_CLICKED);

            //关闭扬声器
            isOpenVoice = false;
        }

    }


    public void holdPhone() {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if(rootNode==null){
            return ;
        }
        Log.e(TAG, "holdPhone: toString---"+ rootNode.toString() );
        List<AccessibilityNodeInfo> nodes = rootNode.findAccessibilityNodeInfosByText("接听");
        for (int i = 0; i < nodes.size(); i++) {
            AccessibilityNodeInfo accessibilityNodeInfo = nodes.get(i);
            Log.e(TAG, "holdPhone: "+ accessibilityNodeInfo.toString() );
            if(accessibilityNodeInfo.isClickable()){
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);

                if(rect.equals(new Rect(597,1661,897,1905))){
                   accessibilityNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    Log.e(TAG, " ===================================================" );
                    isOpenCamera = true;
                    return ;
                }
            }
        }
    }

    public AccessibilityNodeInfo recycle(AccessibilityNodeInfo node) {
        if (node.getChildCount() == 0) {
            if (node.getText() != null) {
                if ("接听".equals(node.getText().toString())) {
                    return node;
                }
            }
        } else {
            for (int i = 0; i < node.getChildCount(); i++) {
                if (node.getChild(i) != null) {
                    recycle(node.getChild(i));
                }
            }
        }
        return null;
    }

    @Override
    public void onInterrupt() {

    }


    /**
     * Check当前辅助服务是否启用
     *
     * @param serviceName serviceName
     * @return 是否启用
     */
    private boolean checkAccessibilityEnabled(String serviceName) {
        List<AccessibilityServiceInfo> accessibilityServices =
                mAccessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        for (AccessibilityServiceInfo info : accessibilityServices) {
            if (info.getId().equals(serviceName)) {
                return true;
            }
        }
        return false;
    }
}
