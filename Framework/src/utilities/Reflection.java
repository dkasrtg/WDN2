package utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Reflection {
//    public Vector<Method> the_getters(Object object) throws Exception{
//        Vector<Method> methods = new Vector<>();
//        Vector<String> real = columns_name(object);
//        for (int i = 0; i < real.size(); i++) {
//            String to_compare = "get";
//            to_compare = to_compare + real.get(i);
//            for (int j = 0; j < object.getClass().getDeclaredMethods().length; j++) {
//                if (object.getClass().getDeclaredMethods()[j].getName().equalsIgnoreCase(to_compare)) {
//                    methods.add(object.getClass().getDeclaredMethods()[j]);
//                }
//            }
//        }
//        return methods;
//    }
    public Vector<Method> the_setters(Object object) throws Exception{
        Vector<Method> methods = new Vector<>();
        Vector<String> real = the_attributes(object);
        for (int i = 0; i < real.size(); i++) {
            String to_compare = "set";
            to_compare = to_compare + real.get(i);
            for (int j = 0; j < object.getClass().getDeclaredMethods().length; j++) {
                if (object.getClass().getDeclaredMethods()[j].getName().equalsIgnoreCase(to_compare)) {
                    methods.add(object.getClass().getDeclaredMethods()[j]);
                }
            }
        }
        return methods;
    }
    public Vector<Method> methods_by(String by,Object object){
        Vector<Method> result = new Vector<>();
        for (int i=0;i<object.getClass().getDeclaredMethods().length;i++){
            if (object.getClass().getDeclaredMethods()[i].getName().contains(by)){
                result.add(object.getClass().getDeclaredMethods()[i]);
            }
        }
        return result;
    }
    public Vector<Method> corres(Vector<Method> methods,Object object){
        Vector<Method> result = new Vector<>();
        for (int i=0;i<methods.size();i++){
            String ns = "get"+methods.get(i).getName().substring(methods.get(i).getName().indexOf("_")+1);
            for (int j=0;j<object.getClass().getDeclaredMethods().length;j++){
                if (object.getClass().getDeclaredMethods()[i].getName().equalsIgnoreCase(ns)){
                    result.add(object.getClass().getDeclaredMethods()[i]);
                }
            }
        }
        return result;
    }
    public Vector<String> the_attributes(Object object){
        Vector<String> result = new Vector<>();
        for (int i=0;i<object.getClass().getDeclaredFields().length;i++){
            result.add(object.getClass().getDeclaredFields()[i].getName().toLowerCase());
        }
        return result;
    }
    public String query_syntax(Object object){
        String result = "";
        String name = object.getClass().getName();
        switch (name){
            case "java.lang.Integer":
            case "java.lang.Double":
                result = String.valueOf(object);
                break;
            case "java.lang.String":
            case "java.sql.Date":
            case "java.sql.Time":
                result = "'" + object + "'";
                break;
            case "java.lang.Boolean":
                result = String.valueOf(object).toUpperCase();
                break;
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
        }
        return result;
    }
//    public Object clone(Object object) throws Exception{
//        Constructor constructor = object.getClass().getConstructor();
//        Object result = constructor.newInstance();
//        Vector<Method> gets = the_getters(object);
//        Vector<Method> sets = the_setters(object);
//        for (int i=0;i< gets.size();i++){
//            sets.get(i).invoke(result,gets.get(i).invoke(object));
//        }
//        return result;
//    }
}