#!/bin/bash

JBOSS_HOME=$HOME/wildfly-21.0.2.Final 

cp -R ./jboss-wildfly-config/modules/system/layers/base/com/mysql $JBOSS_HOME/modules/system/layers/base/com/
cp ./jboss-wildfly-config/deployments/mysql-connector-java-8.0.22.jar $JBOSS_HOME/standalone/deployments

