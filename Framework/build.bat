mkdir temp
cd src
javac -d ../temp/ ./annotations/MappingUrl.java
javac -d ../temp/ ./etu1995/framework/Mapping.java
javac -d ../temp/ ./etu1995/framework/ModelView.java
javac -d ../temp/ ./utilities/Reflection.java
javac -d ../temp/ ./etu1995/framework/servlet/FrontServlet.java
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