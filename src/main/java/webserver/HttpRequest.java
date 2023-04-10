package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static util.HttpParser.*;

public class HttpRequest {
    private final String httpMethod;
    private final String httpUri;
    private final String httpUriPath;
    private final String httpUriRootPath;
    private final String httpVersion;
    private final Map<String, String> httpQueryParameters;
    private final Map<String, String> httpRequestHeader;

    public HttpRequest(BufferedReader br) throws IOException {
        String requestLine = br.readLine();
        this.httpMethod = parseMethod(requestLine);
        this.httpUri = parseUri(requestLine);
        this.httpUriPath = parseUriPath(requestLine);
        this.httpUriRootPath = parseUriRootPath(requestLine);
        this.httpVersion = parseVersion(requestLine);
        this.httpQueryParameters = parseRequestHeader(br);
        this.httpRequestHeader = parseQueryParameter(requestLine);
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getHttpUri() {
        return httpUri;
    }

    public String getHttpUriPath() {
        return httpUriPath;
    }

    public String getHttpUriRootPath() {
        return httpUriRootPath;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public Map<String, String> getQueryParameter() {
        return httpQueryParameters;
    }

    public Map<String, String> getHttpRequestHeader() {
        return httpRequestHeader;
    }

    public String getHttpHeaderValue(String headerName) {
        return httpRequestHeader.get(headerName);
    }
}
