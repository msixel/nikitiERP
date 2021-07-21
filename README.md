DEPENDENCIAS
=============
Instalar java jdk
Instalar apache maven 
Instalar jboss forge



NikiERP
=========


PROJETO
--------
gerar o projeto a partir do arquivo nikitiERP.fsh

	$> forge
	$forge> run ./script/dependencies.fsh (APENAS UMA VEZ NA VIDA - IRA' INSTALAR O JBOSS)
	$forge> run ./script/nikitiERP.fsh

adicionar usuario administrativo (em outro terminal - nao feche o terminal do forge)
	$> ./script/add_admin_user.sh

configurar driver jdbc no JBoss (em outro terminal - nao feche o terminal do forge)
	$> ./script/add_datasource.sh

configurar driver e datasource no JBoss (em outro terminal - nao feche o terminal do forge)
	$> ./script/add_datasource.sh
	obs.: datasource pode ser configurado no painel de administracao do jboss (requer apendice opcional abaixo)

iniciar o JBoss e realizar o deploy da aplicacao (no terminal do forge)
	$forge> as-start
	$forge> as-deploy

popular dados (executando em outro terminal - nao feche o terminal do forge)
	$> ./data/init_data.sh



acessar site em http://localhost:8080/niki
acessar api rest em http://localhost:8080/niki/apidocs
testar api rest abrindo
	$> curl -X GET http://localhost:8080/niki/rest/countries/
	$> curl -X GET http://localhost:8080/niki/rest/provinces/
	$> curl -X GET http://localhost:8080/niki/rest/cities/
	$> curl -X GET http://localhost:8080/niki/rest/neighborhoods/
	$> curl -X GET http://localhost:8080/niki/rest/jobpositions/







APENDICES
===========

OPCIONAL: PAINEL ADMINISTRATIVO DO JBOSS AS (WILDFLY)
------------------------------------------------------------
requisito: jboss wildfly instalado

adicionar usuario administrativo com ./script/add_admin_user.sh
    username: admin
    password: admin
    group: administrator

iniciar jboss AS do terminal  
	$> ${JBOSS_HOME}/bin/standalone.sh
ou do forge
	$forge> as-shutdown
	$forge> as-start 

acessar painel administrativo em http://localhost:9990/console








OPCIONAL: DEPLOY NO JBOSS VIA TERMINAL (MAVEN)
----------------------------------------------
alterar o pom.xml do projeto criado adicionando o seguinte trecho na tag <build> para permitir deploy no jboss atraves do maven na linha de comando
<plugins>
	<plugin>
	        <groupId>org.wildfly.plugins</groupId>
	        <artifactId>wildfly-maven-plugin</artifactId>
	        <version>1.0.2.Final</version>
	        <configuration>
	            <filename>${project.build.finalName}.war</filename>
	        </configuration>
	</plugin>
</plugins>

atencao: ele nao iniciar o servidor
com o jboss rodando executar o comando para instalar no jboss
./mvn wildfly:deploy   (utilizar usuario criado anteriormente)

acessar http://localhost:8080/niki
acessar http://localhost:8080/niki/apidocs

