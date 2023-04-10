package util;

public enum ContentType {
    HTML(".*\\.html", "src/main/resources/templates"),
    CSS(".*\\.css", "src/main/resources/static"),
    JS(".*\\.JS", "src/main/resources/static"),
    IMAGES(".*\\.png", "src/main/resources/static"),
    FONTS(".*\\eot$|.*\\svg$|.*\\.ttf$|.*\\.woff$|.*\\.woff2$", "src/main/resources/static");

    private final String fileExtension;
    private final String fileLocation;

    ContentType(String FILE_EXTENSION, String FILE_LOCATION) {
        this.fileExtension = FILE_EXTENSION;
        this.fileLocation = FILE_LOCATION;
    }

    public String getFILE_EXTENSION() {
        return fileExtension;
    }

    public String getFILE_LOCATION() {
        return fileLocation;
    }
}
