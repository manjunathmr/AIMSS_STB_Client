import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class AIMSSSTBClient {

	public static void main(String[] args) {
		System.out.println("AIMSSSTBClient.main()");
		/*URL findNotesURL;
		try {
			findNotesURL = new URL("http://localhost:8080/rd/rest/aimss_service/findAllInNotesCollection");
			URLConnection urlConnection = findNotesURL.openConnection();
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer inputSB = new StringBuffer();
			String inputString;
			while((inputString = br.readLine()) != null){
				inputSB.append(inputString);
			}
			System.out.println("AIMSSSTBClient.main() : " + inputSB.toString());
			JSONArray noteJsonArray = new JSONArray(inputSB.toString());
			JSONObject noteJsObject= (JSONObject)noteJsonArray.get(0);
			System.out.println("AIMSSSTBClient.main() : " + noteJsObject.getClass());
			int i =0;
			int noteLength = noteJsonArray.length();
			while(i < noteLength){
				try {
					i++;
					System.out.println("AIMSSSTBClient.main() " + noteJsObject.getString("id"));
					System.out.println("AIMSSSTBClient.main() " + noteJsObject.getString("note"));
				} catch (Exception e) {
				}
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}*/
		
		try {
            URL notesUpdateURL = new URL("http://localhost:8080/rd/rest/aimss_service/updateInNotesCollection");
            HttpURLConnection connection = (HttpURLConnection) notesUpdateURL.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.addRequestProperty("Content-type", "application/json");
            OutputStream outputStream = connection.getOutputStream();
            String jsonString = "{\n" +
                    "\"id\": \"2\",\n" +
                    "\"note\": \"my second note\" \n" +
                    "}";
            outputStream.write(jsonString.getBytes("UTF-8"));
            System.out.println("AIMSSSTBClient.main() : " + connection.getResponseCode());
			} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
