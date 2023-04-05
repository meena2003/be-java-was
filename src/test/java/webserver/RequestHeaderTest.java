package webserver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.*;

public class RequestHeaderTest {

    private RequestHeader requestHeader;

    @BeforeEach
    void init() throws IOException {
        String REQUEST_HEADER_EXAMPLE = "Host: www.example.com\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: en-US,en;q=0.5\n";
        requestHeader = new RequestHeader(new BufferedReader(new StringReader(REQUEST_HEADER_EXAMPLE)));
    }

    @Test
    @DisplayName("requestHeader에 저장되는 키-값의 개수가 올바르게 나와야 함")
    public void right_Size_Of_HashMap() {
        assertThat(requestHeader.getHeaderSize()).isEqualTo(8);
    }

    @Test
    @DisplayName("원하는 headerName을 넣으면 매칭되는 headerValue가 반환되어야 함")
    public void get_Right_Value_By_Key() {
        assertThat(requestHeader.getHeaderValue("Host")).isEqualTo("www.example.com");
        assertThat(requestHeader.getHeaderValue("Connection")).isEqualTo("keep-alive");
        assertThat(requestHeader.getHeaderValue("Cache-Control")).isEqualTo("max-age=0");
        assertThat(requestHeader.getHeaderValue("Upgrade-Insecure-Requests")).isEqualTo("1");
        assertThat(requestHeader.getHeaderValue("User-Agent")).isEqualTo("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        assertThat(requestHeader.getHeaderValue("Accept")).isEqualTo("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        assertThat(requestHeader.getHeaderValue("Accept-Encoding")).isEqualTo("gzip, deflate, br");
        assertThat(requestHeader.getHeaderValue("Accept-Language")).isEqualTo("en-US,en;q=0.5");
    }
}
