package com.prima.dialplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.net.Uri;
import android.app.Activity;
import android.content.Intent;

public class Dialer extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException{
		try{
			if ("call".equals(action)) {
				Uri number = Uri.parse("tel:" + args.getString(0));
				Intent callIntent = new Intent(Intent.ACTION_CALL, number);
				this.cordova.getActivity().startActivity(callIntent);
				callbackContext.success();
				return true;
			}
			callbackContext.error("Invalid action");
			return false;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}
	}
}