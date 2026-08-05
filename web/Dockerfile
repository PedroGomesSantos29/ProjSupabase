# Usa uma imagem oficial do Tomcat com Java 17
FROM tomcat:10-jdk17-openjdk-slim

# Remove as aplicações padrão do Tomcat para limpar a casa
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia o seu arquivo WAR da pasta dist para a pasta de execução do Tomcat
COPY dist/ProjSupabase.war /usr/local/tomcat/webapps/ROOT.war

# Expõe a porta 8080 (porta padrão da web no container)
EXPOSE 8080

# Inicia o servidor Tomcat
CMD ["catalina.sh", "run"]