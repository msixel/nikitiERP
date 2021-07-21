addon-install-from-catalog --addon org.primefaces.forge:primefaces-forge-addon


//addon-install-from-catalog --addon org.primefaces.forge:primefaces-forge-addon
//addon-install-from-git --url https://github.com/forge/as-addon  --coordinate org.jboss.forge.addon:as
//addon-install-from-git --url https://github.com/forge/jboss-as-addon  --coordinate org.jboss.forge.addon:jboss-as-wf
//as-setup --server wildfly  --version 8.1.0.Final
//as-start
//as-deploy

//rest-setup                                       --target-package com.blacksmith.nikiti.rest
//rest-generate-endpoints-from-entities            --targets com.blacksmith.nikiti.model.* 

//scaffold-generate --targets com.blacksmith.nikiti.model.Company --provider AngularJS 
//scaffold-generate --targets com.blacksmith.nikiti.model.BusinessUnit --provider AngularJS 
//scaffold-generate --targets com.blacksmith.nikiti.model.ContactChannel --provider AngularJS 
//scaffold-generate --targets com.blacksmith.nikiti.model.Employee --provider AngularJS 
//scaffold-generate --targets com.blacksmith.nikiti.model.WorkSchedule --provider AngularJS 

//faces-setup --faces-version 2.2
//scaffold-generate --targets com.blacksmith.nikiti.model.* --provider Faces
//scaffold-generate --targets com.blacksmith.nikiti.model.* --provider AngularJS --generate-rest-resources

//jpa audit add --entity ~.domain.Country --createdDateColumn CREATED_DATE --modifiedDateColumn MODIFIED_DATE --createdByColumn CREATED_BY --modifiedByColumn MODIFIED_BY




cdi-setup 

jta-setup --jta-version 1.2 

jpa-new-embeddable --named Address
jpa-new-field  --named postalCode                --type String                    --length 009                                                                   --not-nullable
jpa-new-field  --named street                    --type String                    --length 127                                                                   --not-nullable
jpa-new-field  --named houseNumber               --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named complement                --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named country                   --type com.blacksmith.nikiti.model.Country                                      --relationship-type Many-to-One
jpa-new-field  --named province                  --type com.blacksmith.nikiti.model.Province                                     --relationship-type Many-to-One
jpa-new-field  --named city                      --type com.blacksmith.nikiti.model.City                                         --relationship-type Many-to-One
jpa-new-field  --named neighborhood              --type com.blacksmith.nikiti.model.Neighborhood                                 --relationship-type Many-to-One

jpa-new-field  --named address          --entity --type com.blacksmith.nikiti.model.Address                                      --relationship-type Embedded



adminfaces-setup
scaffold-setup --provider AdminFaces
scaffold-generate --entities com.blacksmith.nikiti.model.* --provider AdminFaces --web-root /admin-faces

faces-setup --faces-version 2.2
primefaces-setup --primefaces-version PRIMEFACES_5_1
primefaces-facelet

scaffold-setup --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.BusinessUnit --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.City --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.Company --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.ContactChannel --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.Country --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.Employee --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.JobPosition --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.Neighborhood --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.Province --provider Faces --web-root /faces
scaffold-generate --targets com.blacksmith.nikiti.model.WorkSchedule --provider Faces --web-root /faces

scaffold-setup --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.BusinessUnit --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.City --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.Company --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.ContactChannel --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.Country --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.Employee --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.JobPosition --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.Neighborhood --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.Province --provider AngularJS --web-root /angular
scaffold-generate --targets com.blacksmith.nikiti.model.WorkSchedule --provider AngularJS --web-root /angular

