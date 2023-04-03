package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HttpRequestUtilsTest {
    @Test
    @DisplayName("HTTP RequestLine에서 URL이 추출되어야 함")
    public void extract_Url_From_RequestLine() {
        String httpRequestLine = "GET /index.html HTTP/1.1";
        String url = HttpRequestUtils.getUrl(httpRequestLine);
        assertThat(url).isEqualTo("/index.html");
    }
}
