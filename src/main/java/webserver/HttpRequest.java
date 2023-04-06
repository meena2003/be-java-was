package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static util.HttpParser.*;

public class HttpRequest {
    private final String HTTP_METHOD;
    private final String HTTP_URI;
    private final String HTTP_URI_PATH;
    private final String HTTP_VERSION;
    private final Map<String, String> QUERY_PARAMETER;
    private final Map<String, String> HTTP_REQUEST_HEADER;

    public HttpRequest(BufferedReader br) throws IOException {
        String requestLine = br.readLine();
        this.HTTP_METHOD = parseMethod(requestLine);
        this.HTTP_URI = parseUri(requestLine);
        this.HTTP_URI_PATH = parseUriPath(requestLine);
        this.HTTP_VERSION = parseVersion(requestLine);
        this.HTTP_REQUEST_HEADER = parseRequestHeader(br);
        this.QUERY_PARAMETER = parseQueryParameter(requestLine);
    }

    public String getHttpMethod() {
        return HTTP_METHOD;
    }

    public String getHttpUri() {
        return HTTP_URI;
    }

    public String getHttpUriPath() {
        return HTTP_URI_PATH;
    }

    public String getHttpVersion() {
        return HTTP_VERSION;
    }

    public Map<String, String> getQueryParameter() {
        return QUERY_PARAMETER;
    }

    public Map<String, String> getHttpRequestHeader() {
        return HTTP_REQUEST_HEADER;
    }

    public String getHttpHeaderValue(String headerName) {
        return HTTP_REQUEST_HEADER.get(headerName);
    }
}
