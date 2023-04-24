mkdir temp
cd src
javac -d ../temp/ ./annotations/MappingUrl.java
javac -d ../temp/ ./etu1995/framework/Mapping.java
javac -d ../temp/ ./etu1995/framework/ModelView.java
javac -d ../temp/ ./utilities/Reflection.java
javac -d ../temp/ ./etu1995/framework/servlet/FrontServlet.java
cd ../temp
jar cvf framework.jar *
cp framework.jar ../../TestFramework/WEB-INF/lib/framework.jar
cd ../
rm -R temp
cd ../TestFramework
jar cvf TestFramework.war *
cp TestFramework.war C:/xampp/tomcat/webapps/TestFramework.war
rm TestFramework.war
cd ../Framework