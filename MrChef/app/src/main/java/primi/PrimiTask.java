package primi;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by fgual on 08/09/2017.
 */

public class PrimiTask extends AsyncTask<Void,Void,Void> {

    private ProgressDialog progressDialog;
    private Context context;
    private ArrayList<PrimoPiatto> listaPrimi;
    private PrimiAdapter primiAdapter;

    public PrimiTask(Context pContext, ArrayList<PrimoPiatto> pListaPrimi, PrimiAdapter pPrimiAdapter) {
        context = pContext;
        listaPrimi = pListaPrimi;
        primiAdapter = pPrimiAdapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        listaPrimi.clear();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected Void doInBackground(Void... params) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL("http://192.168.1.4:8080/RistoranteRESTfulServices/webresources/primoPiattoService/json/listaPrimiPiatti");
            connection = (HttpURLConnection) url.openConnection();

            int response = connection.getResponseCode();
            Log.d("server response", String.valueOf(response));


            if (response == HttpURLConnection.HTTP_OK) {
                StringBuilder builder = new StringBuilder();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                        Log.d("stream reader", line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("JSON",builder.toString());
                convertJSONtoArrayList(builder.toString());

            } else {
                Toast.makeText(context, "Server connection fail!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (progressDialog.isShowing())
            progressDialog.dismiss();
        primiAdapter.notifyDataSetChanged();
    }


    private void convertJSONtoArrayList(String result) {
        // Delete all element in organizationCharts ArrayList
        listaPrimi.clear();

        try {
            JSONArray list = new JSONArray(result);

            // convert each element of list to a member object
            for (int i = 0; i < list.length(); i++) {
                JSONObject member = list.getJSONObject(i);

                //add new member object to news ArrayList
                listaPrimi.add(new PrimoPiatto(
                            member.getInt("id"),
                            member.getString("nome"),
                            member.getString("ingredienti"),
                            member.getDouble("prezzo")));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
