package webserver;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestLine {
    private final String HTTP_METHOD;
    private final String HTTP_URI;
    private final String HTTP_VERSION;

    public RequestLine(BufferedReader br) throws IOException {
        String[] tokens = getTokens(br);
        this.HTTP_METHOD = tokens[0];
        this.HTTP_URI = tokens[1];
        this.HTTP_VERSION = tokens[2];
    }

    public String getHTTP_METHOD() {
        return HTTP_METHOD;
    }

    public String getHTTP_URI() {
        return HTTP_URI;
    }

    public String getHTTP_VERSION() {
        return HTTP_VERSION;
    }

    private String[] getTokens(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }
}
