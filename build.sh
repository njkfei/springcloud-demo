cd configuration-service
mvn clean install -Dmaven.test.skip=true

cd ../eureka-service
mvn clean install -Dmaven.test.skip=true

cd ../admin
mvn clean install -Dmaven.test.skip=true

cd ../hystrixdashboard
mvn clean install -Dmaven.test.skip=true

cd ../zipkinservice
mvn clean install -Dmaven.test.skip=true

cd ../userservice
mvn clean install -Dmaven.test.skip=true

cd ../feignclient
mvn clean install -Dmaven.test.skip=true

cd ../serviceclient
mvn clean install -Dmaven.test.skip=true

cd ../zuulapigateway
mvn clean install -Dmaven.test.skip=true


