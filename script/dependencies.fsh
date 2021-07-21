addon-install-from-git --url https://github.com/forge/as-addon  --coordinate org.jboss.forge.addon:as
addon-install-from-git --url https://github.com/forge/jboss-as-addon  --coordinate org.jboss.forge.addon:jboss-as-wf
as-setup --server wildfly  --version 8.1.0.Final

addon-install-from-catalog --addon org.jboss.swagger:swagger-addon

addon-install-from-catalog --addon com.github.adminfaces.addon:admin-addon
addon-install-from-catalog --addon org.jboss.forge.addon:jboss-as

