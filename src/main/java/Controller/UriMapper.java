package Controller;

public class UriMapper {
    public String uriMap(String uri) {
        if (uri.equals("/")) {
            return "/index.html";
        }

        if (uri.equals("/user/form")) {
            return "/user/form.html";
        }

        if (uri.equals("/user")) {

        }
    }
}
