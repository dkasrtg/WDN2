package etu1995.framework.error;

public class Error {
    public Error(){

    }
    public static String fourzerofour(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>404 Not Found</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"center\">\n" +
                "        <div>\n" +
                "            <p class=\"a\">404</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"b\">Page not found</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"c\">The page you are looking for does not exist</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "<style>\n" +
                "    body{\n" +
                "        font-family: Arial;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .center{\n" +
                "        width: fit-content;\n" +
                "        height: fit-content;\n" +
                "        margin: auto;\n" +
                "        margin-top: 30vh;\n" +
                "        align-items: center;\n" +
                "    }\n" +
                "    .a{\n" +
                "        font-size:xx-large;\n" +
                "        font-weight: bolder;\n" +
                "    }\n" +
                "    .b{\n" +
                "        font-size: x-large;\n" +
                "    }\n" +
                "    .c{\n" +
                "        font-size: medium;\n" +
                "    }\n" +
                "</style>\n" +
                "</body>\n" +
                "</html>";
    }
    public static String fourzerothree(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>403 Forbidden</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"center\">\n" +
                "        <div>\n" +
                "            <p class=\"a\">403</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"b\">Access forbidden</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"c\">You do not have permission to access this page</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "<style>\n" +
                "    body{\n" +
                "        font-family: Arial;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .center{\n" +
                "        width: fit-content;\n" +
                "        height: fit-content;\n" +
                "        margin: auto;\n" +
                "        margin-top: 30vh;\n" +
                "        align-items: center;\n" +
                "    }\n" +
                "    .a{\n" +
                "        font-size:xx-large;\n" +
                "        font-weight: bolder;\n" +
                "    }\n" +
                "    .b{\n" +
                "        font-size: x-large;\n" +
                "    }\n" +
                "    .c{\n" +
                "        font-size: medium;\n" +
                "    }\n" +
                "</style>\n" +
                "</body>\n" +
                "</html>";
    }
    public static String error(Exception e){
        Throwable rootCause = e.getCause();
        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }
        StackTraceElement[] stackTrace = rootCause.getStackTrace();
        String fileName = null;
        int lineNumber = -1;
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (!className.startsWith("java.") && !className.startsWith("javax.") && !className.startsWith("jdk.")) {
                fileName = element.getFileName();
                lineNumber = element.getLineNumber();
                break;
            }
        }
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Error</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"center\">\n" +
                "        <div>\n" +
                "            <p class=\"a\">Error</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"b\">An error occured when fullfiling the request</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <td>Type:</td>\n" +
                "                    <td>"+rootCause.getClass().getSimpleName()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>File:</td>\n" +
                "                    <td>"+fileName+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>Line:</td>\n" +
                "                    <td>"+lineNumber+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>Message:</td>\n" +
                "                    <td>"+rootCause.getLocalizedMessage()+"</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "<style>\n" +
                "    body{\n" +
                "        font-family: Arial;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .center{\n" +
                "        width: fit-content;\n" +
                "        height: fit-content;\n" +
                "        margin: auto;\n" +
                "        margin-top: 30vh;\n" +
                "        align-items: center;\n" +
                "    }\n" +
                "    .a{\n" +
                "        font-size:xx-large;\n" +
                "        font-weight: bolder;\n" +
                "    }\n" +
                "    .b{\n" +
                "        font-size: x-large;\n" +
                "    }\n" +
                "    .c{\n" +
                "        font-size: medium;\n" +
                "    }\n" +
                "    table {\n" +
                "        text-align: left;\n" +
                "        margin: auto;\n" +
                "        font-size: medium;\n" +
                "    }\n" +
                "</style>\n" +
                "</body>\n" +
                "</html>";
    }

    public static String fourzerofourfile(String file){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>404 Not Found</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"center\">\n" +
                "        <div>\n" +
                "            <p class=\"a\">404</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"b\">File not found</p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <p class=\"c\">The file "+file+" was not found</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "<style>\n" +
                "    body{\n" +
                "        font-family: Arial;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .center{\n" +
                "        width: fit-content;\n" +
                "        height: fit-content;\n" +
                "        margin: auto;\n" +
                "        margin-top: 30vh;\n" +
                "        align-items: center;\n" +
                "    }\n" +
                "    .a{\n" +
                "        font-size:xx-large;\n" +
                "        font-weight: bolder;\n" +
                "    }\n" +
                "    .b{\n" +
                "        font-size: x-large;\n" +
                "    }\n" +
                "    .c{\n" +
                "        font-size: medium;\n" +
                "    }\n" +
                "</style>\n" +
                "</body>\n" +
                "</html>";
    }
}
