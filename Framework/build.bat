mkdir temp

cd src
javac -d ../temp/ ./annotations/MappingUrl.java
javac -d ../temp/ ./annotations/Scope.java
javac -d ../temp/ ./annotations/Authentication.java
javac -d ../temp/ ./annotations/Session.java
javac -d ../temp/ ./annotations/RestAPI.java
javac -d ../temp/ ./etu1995/framework/Mapping.java
javac -d ../temp/ ./etu1995/framework/ModelView.java
javac -d ../temp/ ./etu1995/framework/FileUpload.java
javac -d ../temp/ ./utilities/Reflection.java
javac -d ../temp/ ./etu1995/framework/error/Error.java
javac -cp C:/xampp/tomcat/lib/gson-2.8.2.jar;C:/xampp/tomcat/lib/servlet-api.jar;C:/xampp/tomcat/lib/jsp-api.jar;../temp -d ../temp ./etu1995/framework/servlet/FrontServlet.java

cd ../temp
jar cvf framework.jar *
copy framework.jar ..\\..\\TestFramework\\WEB-INF\\lib\\framework.jar
cd ../
del temp

cd ../TestFramework
jar cvf TestFramework.war *
copy TestFramework.war C:\\xampp\\tomcat\\webapps\\TestFramework.war
del TestFramework.war

cd ../Framework