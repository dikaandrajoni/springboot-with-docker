FROM maven:3.6.3-openjdk-11-slim AS MAVEN_BUILD

# Create Directory build
WORKDIR /build

#Copy Directory to build
COPY . /build

# Run Maven
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11-slim-buster

# Create Directory home
WORKDIR /home

# Set Timezone
ENV TZ Asia/Jakarta

# Set Jar File
ARG JAR_FILE=/build/target/*.jar

# Copy Jar File
COPY --from=MAVEN_BUILD ${JAR_FILE} /home/dikaaj.jar

# Run Jar File
CMD ["java", "-Duser.timezone=Asia/Jakarta", "-Xms300m", "-Xmx1024m", "-jar", "dikaaj.jar"]