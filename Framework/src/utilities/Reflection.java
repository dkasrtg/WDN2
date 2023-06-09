package utilities;

import etu1995.framework.FileUpload;

import jakarta.servlet.http.Part;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Vector;

public class Reflection {

    public Method method_by(String method, Object object) {
        for (int i = 0; i < object.getClass().getDeclaredMethods().length; i++) {
            if (object.getClass().getDeclaredMethods()[i].getName().equals(method)) {
                return object.getClass().getDeclaredMethods()[i];
            }
        }
        return null;
    }

    public Vector<String> the_attributes(Object object) {
        Vector<String> result = new Vector<>();
        for (int i = 0; i < object.getClass().getDeclaredFields().length; i++) {
            result.add(object.getClass().getDeclaredFields()[i].getName().toLowerCase());
        }
        return result;
    }

    public Method caster(String name) throws Exception {
        Method result = null;
        switch (name) {
            case "int":
            case "java.lang.Integer":
                result = Integer.class.getDeclaredMethod("parseInt", String.class);
                break;
            case "double":
            case "java.lang.Double":
                result = Double.class.getDeclaredMethod("parseDouble", String.class);
                break;
            case "java.sql.Date":
                result = Date.class.getDeclaredMethod("valueOf", String.class);
                break;
            case "boolean":
            case "java.lang.Boolean":
                result = Boolean.class.getDeclaredMethod("valueOf", String.class);
                break;
            case "java.lang.String":
                result = String.class.getDeclaredMethod("valueOf", Object.class);
                break;
            case "[Ljava.lang.String;":
                result = Reflection.class.getDeclaredMethod("toArray", String.class);
                break;
            case "etu1995.framework.FileUpload":
                result = Reflection.class.getDeclaredMethod("toFileUpload", Vector.class);
                break;
            case "[Letu1995.framework.FileUpload;":
                result = Reflection.class.getDeclaredMethod("toFileUploadArray", Vector.class);
                break;
        }
        return result;
    }

    public static String[] toArray(String p) {
        String ox = p.substring(1, p.length() - 1);
        return ox.split(", ");
    }

    public static FileUpload toFileUpload(Vector<Part> parts) throws Exception {
        Part part = parts.get(0);
        String name = part.getSubmittedFileName();
        String headerValue = part.getHeader("content-disposition");
        String filePath = headerValue.substring(headerValue.indexOf("filename=") + 10, headerValue.length() - 1); // Extract the file path
        byte[] bytes = part.getInputStream().readAllBytes();
        return new FileUpload(name, bytes,filePath);
    }

    public static FileUpload[] toFileUploadArray(Vector<Part> parts) throws Exception {
        FileUpload[] fileUploads = new FileUpload[parts.size()];
        for (int i = 0; i < fileUploads.length; i++) {
            String name = parts.get(i).getSubmittedFileName();
            String headerValue = parts.get(i).getHeader("content-disposition");
            String filePath = headerValue.substring(headerValue.indexOf("filename=") + 10, headerValue.length() - 1); // Extract the file path
            byte[] bytes = parts.get(i).getInputStream().readAllBytes();
            fileUploads[i] = new FileUpload(name, bytes,filePath);
        }
        return fileUploads;
    }

    public void nullos(Object object) {
        Vector<String> attributes = the_attributes(object);
        for (int i = 0; i < attributes.size(); i++) {
            String to_compare = "set";
            to_compare = to_compare + attributes.get(i);
            for (int j = 0; j < object.getClass().getDeclaredMethods().length; j++) {
                if (object.getClass().getDeclaredMethods()[j].getName().equalsIgnoreCase(to_compare)) {
                    try {
                        object.getClass().getDeclaredMethods()[j].invoke(object, (Object) null);
                    } catch (Exception e) {
                        try {
                            object.getClass().getDeclaredMethods()[j].invoke(object, 0);
                        } catch (Exception f) {
                            try {
                                object.getClass().getDeclaredMethods()[j].invoke(object, false);
                            } catch (Exception ignored) {}
                        }
                    }
                }
            }
        }
    }
}