# Usa imagem do Tomcat 10 com Java 17
FROM tomcat:10-jdk17-openjdk-slim

# Limpa a pasta padrao de apps do Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia o seu ROOT.war direto para a pasta do Tomcat
COPY dist/ROOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]

