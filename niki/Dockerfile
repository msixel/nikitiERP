FROM rmpestano/wildfly:16.0.0

COPY ./docker/standalone.conf ${WILDFLY_HOME}/bin/

COPY ./target/niki.war ${DEPLOYMENT_DIR}

