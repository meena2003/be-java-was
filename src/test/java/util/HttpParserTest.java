package util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static util.HttpParser.*;

public class HttpParserTest {
    private static BufferedReader REQUEST_HEADER_EXAMPLE;
    private static String requestLine1;
    private static String requestLine2;
    private static String requestLine3;
    private static String requestLine4;

    @BeforeAll
    public static void init() {
        REQUEST_HEADER_EXAMPLE = new BufferedReader((new StringReader("Host: www.example.com\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: en-US,en;q=0.5\n")));
        requestLine1 = "GET /user/create?userId=core&password=123&name=kim&email=core@naver.com HTTP/1.1";
        requestLine2 = "POST /login HTTP/1.1";
        requestLine3 = "PUT /files/document.txt HTTP/1.1";
        requestLine4 = "GET /search?q=java&page=2&sort=price HTTP/1.1";
    }

    @Test
    @DisplayName("올바른 http 메소드명을 반환해야 함")
    public void extract_method_from_requestLine() {
        assertThat(parseMethod(requestLine1)).isEqualTo("GET");
        assertThat(parseMethod(requestLine2)).isEqualTo("POST");
    }

    @Test
    @DisplayName("올바른 전체 http uri 반환해야 함")
    public void extract_uri_from_requestLine() {
        assertThat(parseUri(requestLine1)).isEqualTo("/user/create?userId=core&password=123&name=kim&email=core@naver.com");
        assertThat(parseUri(requestLine2)).isEqualTo("/login");
        assertThat(parseUri(requestLine3)).isEqualTo("/files/document.txt");
    }

    @Test
    @DisplayName("올바른 http 버전을 반환해야 함")
    public void extract_version_from_requestLine() {
        assertThat(parseVersion(requestLine1)).isEqualTo("HTTP/1.1");
    }

    @Test
    @DisplayName("올바른 http uri path 반환해야 함")
    public void extract_uriPath_from_requestLine() {
        assertThat(parseUriPath(requestLine1)).isEqualTo("/user/create");
        assertThat(parseUriPath(requestLine4)).isEqualTo("/search");
    }

    @Test
    @DisplayName("올바른 request header 반환해야 함")
    public void extract_requestHeader_from_requestLine() throws IOException {
        LinkedHashMap<String, String> expected = new LinkedHashMap();
        expected.put("Host", "www.example.com");
        expected.put("Connection", "keep-alive");
        expected.put("Cache-Control", "max-age=0");
        expected.put("Upgrade-Insecure-Requests", "1");
        expected.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        expected.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        expected.put("Accept-Encoding", "gzip, deflate, br");
        expected.put("Accept-Language", "en-US,en;q=0.5");

        assertThat(parseRequestHeader(REQUEST_HEADER_EXAMPLE)).isEqualTo(expected);
    }

    @Test
    @DisplayName("올바른 쿼리 파라미터를 반환해야 함")
    public void extract_queryParameter_from_requestLine() {
        Map<String, String> expected = Map.of(
                "userId", "core",
                "password", "123",
                "name", "kim",
                "email", "core@naver.com"
        );
        assertThat(parseQueryParameter(requestLine1)).isEqualTo(expected);

        expected = Map.of(
                "q", "java",
                "page", "2",
                "sort", "price"
        );
        assertThat(parseQueryParameter(requestLine4)).isEqualTo(expected);
    }
}
