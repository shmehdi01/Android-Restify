package library.shmehdi.restify;

/**
 * Created by Syed Hussain Mehdi on 25-03-2018.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * This class is used as singleton of Volley request
 * */

@SuppressWarnings("unchecked")
public class VolleySingleTon {

    private RequestQueue requestQueue;
    private static Context mContext;
    private static VolleySingleTon mInstance;

    private VolleySingleTon(Context context){
        mContext = context;
        requestQueue = getRequestQueue();

    }

    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized VolleySingleTon getInstance(Context context){
        if(mInstance==null){
            mInstance = new VolleySingleTon(context);
        }
        return mInstance;
    }

    public <T> void addToRequesQue(Request request){
        requestQueue.add(request);
    }
}

