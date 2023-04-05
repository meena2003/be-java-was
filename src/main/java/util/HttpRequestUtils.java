package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHeader;
import webserver.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequestUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);
    private RequestLine requestLine;
    private RequestHeader requestHeader;

    public HttpRequestUtils(BufferedReader br) throws IOException {
        requestLine = new RequestLine(br);
        requestHeader = new RequestHeader(br);
    }

    public void printHttpRequestAllHeaders() {
        System.out.println(requestHeader.getRequestHeaders());
    }

    public String getRequestLineHttpURI() {
        return requestLine.getHTTP_URI();
    }

    public String getRequestLineHttpVersion() {
        return requestLine.getHTTP_VERSION();
    }

    public String getRequestLineHttpMethod() {
        return requestLine.getHTTP_METHOD();
    }

}
