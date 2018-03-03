package com.liumapp.demo.apache.httpclient.client.post;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liumapp on 3/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping("post")
public class PostController {

    @RequestMapping("/toLocal")
    public String postToApple () {
        try {
            String url = "https://selfsolve.apple.com/wcResults.do";

            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);

            // add header
            post.setHeader("User-Agent", "Mozila/5.0");

            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
            urlParameters.add(new BasicNameValuePair("cn", ""));
            urlParameters.add(new BasicNameValuePair("locale", ""));
            urlParameters.add(new BasicNameValuePair("caller", ""));
            urlParameters.add(new BasicNameValuePair("num", "12345"));

            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpResponse response = client.execute(post);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error";
    }


}
