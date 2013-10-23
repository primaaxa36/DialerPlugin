package com.prima.dialer;

import org.apache.cordova.Config;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.UriResolver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class Dialer extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException{
		if (action.equals("call")) {
			String source = args.getString(0);

			try{
				Uri number = Uri.parse("tel:" + source);
				Intent callIntent = new Intent(Intent.ACTION_CALL, number);
				this.cordova.getActivity().startActivity(callIntent);
				callbackContext.success();
				return true;
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
				callbackContext.error(e.getMessage());
				return false;
			}
		}

		callbackContext.error("Invalid action");
		return false;
	}
}