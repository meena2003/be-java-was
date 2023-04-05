package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webserver.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.*;

public class HttpRequestUtilsTest {

    private RequestLine requestLine;

    @BeforeEach
    public void init() throws IOException {
        String httpRequestLine = "GET /index.html HTTP/1.1";
        BufferedReader br = new BufferedReader(new StringReader(httpRequestLine));
        requestLine = new RequestLine(br);
    }

    @Test
    @DisplayName("올바른 HTTP URI 추출해야 함")
    public void extract_Url_From_RequestLine() {
        String url = requestLine.getHTTP_URI();
        assertThat(url).isEqualTo("/index.html");
    }

    @Test
    @DisplayName("올바른 HTTP Method 추출해야 함")
    public void extract_Method_From_RequestLine() {
        String method = requestLine.getHTTP_METHOD();
        assertThat(method).isEqualTo("GET");
    }

    @Test
    @DisplayName("올바른 HTTP 버전 추출해야 함")
    public void extract_Version_From_RequestLine() {
        String method = requestLine.getHTTP_VERSION();
        assertThat(method).isEqualTo("HTTP/1.1");
    }
}
