package com.example.autosms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

import java.util.ArrayList;
 
public class SmsReceiver extends BroadcastReceiver
{
    GPSTracker gps;
    String latitudeStr ;
    String longitudeStr;
	private static boolean activated=true;

	public static boolean changeStatus() {
		return SmsReceiver.activated=!SmsReceiver.activated;
	}
	
    @Override
    public void onReceive(Context context, Intent intent) 
    {

        //--- get current position ---

        gps = new GPSTracker(context);

        if(gps.canGetLocation()) {
            double latitude = gps.getLatitude();
            latitudeStr = String.valueOf(gps.getLatitude());
            double longitude = gps.getLongitude();
            longitudeStr = String.valueOf(gps.getLongitude());


        } else {
            gps.showSettingsAlert();
        }

        //---get the SMS message passed in---
    	Log.v("SmsReceiver", "Received");
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;        
        String messageRecu;
        String messageAEnvoyer;
        String numTel;
        ArrayList<String> longMessage;
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            //---display the new SMS message---
            SmsManager smsManager = SmsManager.getDefault();
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++){
            	messageAEnvoyer="";
            	longMessage=new ArrayList<String>();
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                numTel=msgs[i].getOriginatingAddress();
                
                messageRecu = msgs[i].getMessageBody().toLowerCase().replaceAll(" ", "");
                if(messageRecu!=null) {
                    if(messageRecu.equals("help")) {
                        messageAEnvoyer="Latitude: "+latitudeStr+"\r\nLongitude: "+longitudeStr ;
                    } else {
	                	messageAEnvoyer=devinette(messageRecu, numTel);
	                }
	                
	                if(!messageAEnvoyer.equals("")) {
                		longMessage=smsManager.divideMessage(messageAEnvoyer);
                		smsManager.sendMultipartTextMessage(numTel, null, longMessage, null, null);
	                }
                }    
            }
        }                         
    }
    
    public String devinette(String messageRecu, String numTel) {
    	String messageAEnvoyer="";
    	String devinette;
    	PredictifData data = PredictifData.getInstance();
    	if(messageRecu.equals("devinette")) {
    		devinette = data.getRandom();
    		if(devinette.equals("moi"))
    		{
    			messageAEnvoyer=caesar(numTel);
    		}
    		else
    		{
    			messageAEnvoyer=data.nomQuestion.get(devinette);
    		}
        	data.numDevinette.put(numTel, devinette);
    	} else if(data.numDevinette.containsKey(numTel)){
        	if(messageRecu.equals(data.numDevinette.get(numTel))){
        		messageAEnvoyer="Great ! You did it.";
        	} else if(messageRecu.equals("quitter")){
        		messageAEnvoyer="Bye, you little shit.";
        		data.numDevinette.remove(numTel);
        	} else {
        		//messageAEnvoyer="You failed";
        	}
        }
    	return messageAEnvoyer;
    }
    
    public String caesar(String text)
    {
    	char[] chars = text.toCharArray();
        for (int i=0; i < text.length(); i++)
        {
            char c = chars[i];
            if (c >= 43 && c <= 57)
            {
            	int x = c;
            	Log.v("ASCII", Integer.toString(x));
                chars[i] = (char) (x + 64);
            }
        }
        return new String(chars);
    }
}
