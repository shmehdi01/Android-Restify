package library.shmehdi.restify;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created By Syed Hussain Medhi
 * email : shmehdi01@gmail.com
 * youtube : youtube.com/shmehdi5
 * */

public class Service<T>{


    private String TAG = Service.class.getName();

    /**
     * Methods of Request
     * */

    public final static int GET = 0;
    public final static int POST = 1;
    public final static int PUT = 2;
    public final static int DELETE = 3;
    public final static int HEAD = 4;
    public final static int OPTIONS = 5;
    public final static int TRACE = 6;
    public final static int PATCH = 7;

    /**
     * This is a {@value GET} request method.
     * It will response {@link Response} with your model,json, and url.
     * */

    public void getRequest(Context context, final String url, final Parser<T> parser , final Response<T> listener){

        StringRequest request = new StringRequest(0, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,response);
                 if(parser != null)listener.onServerResponse(parser.parse(response), response,url); else listener.onServerResponse(null,response,url);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error "+url+" "+(error.networkResponse!=null?"StatusCode : "+error.networkResponse.statusCode:""));
                listener.onErrorResponse(url,error);
            }
        });


        request.setShouldCache(false);
        VolleySingleTon.getInstance(context).addToRequesQue(request);
    }


    /**
     * This is a {@value POST} request method.
     * It takes Map<String>,<String> as params
     * It will response {@link Response} with your model,json, and url.
     * */

    public void postRequest(Context context, final String url, final Map<String,String > params, final Parser<T> parser , final Response<T> listener){


        StringRequest request = new StringRequest(1, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,response);
                if(parser != null)listener.onServerResponse(parser.parse(response), response,url); else listener.onServerResponse(null,response,url);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error "+url+" "+(error.networkResponse!=null?"StatusCode : "+error.networkResponse.statusCode:""));
                listener.onErrorResponse(url,error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }


        };


        VolleySingleTon.getInstance(context).addToRequesQue(request);
    }

    public void postRequest(Context context, final String url, final Map<String,String > params, final Map<String,String > headers, final Parser<T> parser , final Response<T> listener){


        StringRequest request = new StringRequest(1, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,response);
                if(parser != null)listener.onServerResponse(parser.parse(response), response,url); else listener.onServerResponse(null,response,url);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error "+url+" "+(error.networkResponse!=null?"StatusCode : "+error.networkResponse.statusCode:""));
                listener.onErrorResponse(url,error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };


        VolleySingleTon.getInstance(context).addToRequesQue(request);
    }



    /**
     * This is a {@value POST} and {@value GET} request method.
     * It takes JSONObject as params
     * It will response {@link Response} with your model,json, and url.
     * */

    public void jsonRequest(int method, Context context, final String url, final JSONObject params, final Parser<T> parser , final Response<T> listener){


        JsonObjectRequest request = new JsonObjectRequest(method, url, params, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG,response.toString());
                if(parser != null)listener.onServerResponse(parser.parse(response.toString()), response.toString(),url); else listener.onServerResponse(null,response.toString(),url);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error "+url+" "+(error.networkResponse!=null?"StatusCode : "+error.networkResponse.statusCode:""));
                listener.onErrorResponse(url,error);
            }
        });



        VolleySingleTon.getInstance(context).addToRequesQue(request);
    }


    /**
     * This is a {@value POST} and {@value GET} request method.
     * It takes JSONArray as params
     * It will response {@link Response} with your model,json, and url.
     * */

    public void jsonRequest(int method, Context context, final String url, final JSONArray params, final Parser<T> parser , final Response<T> listener){


        JsonArrayRequest request = new JsonArrayRequest(method, url, params, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i(TAG,response.toString());
                if(parser != null)listener.onServerResponse(parser.parse(response.toString()), response.toString(),url); else listener.onServerResponse(null,response.toString(),url);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error "+url+" "+(error.networkResponse!=null?"StatusCode : "+error.networkResponse.statusCode:""));
                listener.onErrorResponse(url,error);
            }
        });
        VolleySingleTon.getInstance(context).addToRequesQue(request);
    }


    /**
     * To customize your own method
     * create your request such as JsonRequest, StringRequest
     * In response method call this method
     * */
    public void parseResponse(String response,final String url, final Parser<T> parser , final Response<T> listener){
        if(parser != null)listener.onServerResponse(parser.parse(response), response,url); else listener.onServerResponse(null, response,url);
    }

    /**
     * To print error in log of volley error
     * call this method in onErrorResponse(VolleyError error)
     * */
    public void logError(String url, VolleyError error ){
        Log.i(TAG,"Error "+url+" "+(error.networkResponse!=null?"StatusCode : "+error.networkResponse.statusCode:""));
    }
}
