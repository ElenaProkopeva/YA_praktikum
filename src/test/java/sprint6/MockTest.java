package sprint6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
@RunWith(Parameterized.class)
public class MockTest {
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
     @Mock
    ServiceClass serviceClass;


    @Test
    public void test() throws IOException {
        Server server = new Server();
        Mockito.when(serviceClass.sendGet(Mockito.anyString())).thenReturn(400);
        int responseCode = serviceClass.sendGet("http://www.example.com");
        String status = server.checkServer(responseCode);
        Assert.assertEquals("Сервер недоступен", status);
    }
}

class ServiceClass {

    public int sendGet(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection.getResponseCode();
    }
}

class Server {

    public String checkServer(int responseCode) {
        if (200 == responseCode) {
            return "Сервер доступен";
        } else {
            return "Сервер недоступен";
        }
    }

}