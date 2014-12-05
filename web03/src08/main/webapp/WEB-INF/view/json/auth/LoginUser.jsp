<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       

<%
HashMap<String,Object> resultMap = new HashMap<>();
if(session.getAttribute("loginUser") != null){
out.write(new Gson().toJson(session.getAttribute("loginUser")));
}else{%>
{ "userId":""}
<%}%>















