package webserver;

public class RequestLine {
    private final String HTTP_METHOD;
    private final String HTTP_URI;
    private final String HTTP_VERSION;

    public RequestLine(String HTTP_METHOD, String HTTP_URI, String HTTP_VERSION) {
        this.HTTP_METHOD = HTTP_METHOD;
        this.HTTP_URI = HTTP_URI;
        this.HTTP_VERSION = HTTP_VERSION;
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
}
