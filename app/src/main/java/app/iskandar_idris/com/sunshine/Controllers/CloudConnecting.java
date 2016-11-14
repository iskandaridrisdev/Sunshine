package app.iskandar_idris.com.sunshine.Controllers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Iskandar Idris on 11/5/2016.
 */

public class CloudConnecting {
    public void getData(Context context, String Url, final CloudResult result){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.resultData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.errorResultData(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

}
