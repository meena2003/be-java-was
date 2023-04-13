package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public enum ContentType {
    HTML(".+\\.html", "src/main/java/resources/templates"),
    CSS(".+\\.css", "src/main/java/resources/static"),
    JS(".+\\.js", "src/main/java/resources/static"),
    PNG(".+\\.png", "src/main/java/resources/static"),
    ICO(".+\\.ico", "src/main/java/resources/static");

    private static final Logger log = LoggerFactory.getLogger("ContentType");
    final String extension;
    final String rootPath;

    ContentType(String extension, String rootPath) {
        this.extension = extension;
        this.rootPath = rootPath;
    }

    // uri에 포함된 확장자 종류에 따라 content 타입을 반환함
    public static ContentType getContentType(String uri) {
        for (ContentType type : ContentType.values()) {
            if (uri.matches(type.extension)) {
                log.debug("content type : {}", type);
            }
        }
        // todo 포함되지 않는 확장자에 대한 처리 필요
        return null;
    }

    public String getExtension() {
        return extension;
    }

    public String getRootPath() {
        return rootPath;
    }

    @Override
    public String toString() {
        return "ContentType{" +
                "extension='" + extension + '\'' +
                ", rootPath='" + rootPath + '\'' +
                '}';
    }
}
