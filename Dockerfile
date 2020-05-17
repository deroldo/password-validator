FROM webdizz/centos-java8

ENV APP_HOME "/opt/app"

ADD build/libs/*.jar $APP_HOME/app.jar

CMD	java -Xmx${MEMORY_RESERVATION}M -Xms${MEMORY_RESERVATION}M -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar /opt/app/app.jar