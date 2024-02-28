package com.clone.instagram.util;

public class Script {
    
    public static String back(String message){
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('"+message+"')");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }
}
