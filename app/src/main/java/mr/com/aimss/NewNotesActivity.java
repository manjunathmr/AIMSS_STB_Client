package mr.com.aimss;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class NewNotesActivity extends ActionBarActivity {

    private EditText newNotesET;
    private NotesDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);
        newNotesET = (EditText) findViewById(R.id.newNotesEditText);
        datasource = new NotesDataSource(this);
        datasource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        addNewNotes(newNotesET.getText().toString());



    }

    private void addNewNotes(String s) {
        datasource.createNote(s);
        try {
            URL notesUpdateURL = new URL("http://localhost:8080/rd/rest/aimss_service/updateInNotesCollection");
            HttpURLConnection connection = (HttpURLConnection) notesUpdateURL.openConnection();

            connection.setDoInput(true);
            connection.setRequestMethod("PUT");
            connection.addRequestProperty("Content-type", "application/json");
            OutputStream outputStream = connection.getOutputStream();
            String jsonString = "{\n" +
                    "\"id\": \"2\",\n" +
                    "\"note\": \"my second note\" \n" +
                    "}";
            outputStream.write(jsonString.getBytes("UTF-8"));


             connection.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
