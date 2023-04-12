package util;

public enum ContentType {
    HTML(".*\\.html", "src/main/resources/templates"),
    CSS(".*\\.css", "src/main/resources/static"),
    JS(".*\\.JS", "src/main/resources/static"),
    IMAGES(".*\\.png", "src/main/resources/static"),
    FONTS(".*\\eot$|.*\\svg$|.*\\.ttf$|.*\\.woff$|.*\\.woff2$", "src/main/resources/static");

    private final String fileExtension;
    private final String fileLocation;

    ContentType(String fileExtension, String fileLocation) {
        this.fileExtension = fileExtension;
        this.fileLocation = fileLocation;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileLocation() {
        return fileLocation;
    }
}
