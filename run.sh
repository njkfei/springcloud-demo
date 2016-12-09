cd configuration-service
mvn spring-boot:run &

cd ../eureka-service
mvn spring-boot:run &

cd ../admin
mvn spring-boot:run &

cd ../hystrixdashboard
mvn spring-boot:run &

cd ../zipkinservice
mvn spring-boot:run &

cd ../userservice
mvn spring-boot:run &

cd ../feignclient
mvn spring-boot:run &

cd ../serviceclient
mvn spring-boot:run &

cd ../zuulapigateway
mvn spring-boot:run &


