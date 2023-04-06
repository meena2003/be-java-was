package service;

public class UserService {

//    public UserService() {
//    }
//
//    public User join(String requestLine) {
//        String[] userInfo = parseQueryString(requestLine);
//        return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
//    }
//
//    private static String[] parseQueryString(String requestLine) {
//        String url = getUrl(requestLine);
//        String[] parsedUrl = url.split("\\?|&");
//        logger.debug("parsedUrl = {}", Arrays.toString(parsedUrl));
//
//        String[] userInfo = new String[4];
//        for (int i = 0, j = 1; i < userInfo.length; i++, j++) {
//            // User 객체를 만들기 위해 id, password, name, email 정보 파싱해서 String 배열에 저장
//            String info = parsedUrl[j].substring(parsedUrl[j].indexOf('=') + 1);
//            userInfo[i] = URLDecoder.decode(info, StandardCharsets.UTF_8);
//        }
//        logger.debug("userInfo = {}", Arrays.toString(userInfo));
//        return userInfo;
//    }
}
