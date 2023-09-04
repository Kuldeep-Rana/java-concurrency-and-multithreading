package com.codersdesks;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThreadDumTest {
    static Map map = new TreeMap<Integer, String>();
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Thread.currentThread().setName("DumpTest");
        int count = 1;
        List<String> list = new ArrayList<>();

        while(true){
            var request = HttpRequest.newBuilder().uri(new URI("https://google.com")).GET().build();
            var response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            var body = response.body();
            System.out.println(body);
            count++;
           ///Thread.sleep(2000);
            System.out.println("Count "+count);
            list.add(body);
            map.put(count, body);
            //if(count == 10)
               // throw new OutOfMemoryError("OOM");
        }
    }
}
