project-new --named niki --final-name niki --top-level-package com.blacksmith.nikiti --stack JAVA_EE_7 --build-system Maven --type war --version 1.0.0

cdi-setup 

jta-setup --jta-version 1.2 

testing-setup --test-framework junit --version 4.13.1

jpa-setup --persistence-unit-name nikitiPU --jpa-version 2.1 --jpa-provider "Hibernate 4.x" --jpa-container WILDFLY --db-type MYSQL --data-source-name java:jboss/datasources/nikiDS --schema-generation-type DROP_CREATE

jpa-new-entity --named Country                   --target-package com.blacksmith.nikiti.model
jpa-new-field  --named code                      --type String                    --length 002                                                                   --not-nullable
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable

jpa-new-entity --named Province                  --target-package com.blacksmith.nikiti.model
jpa-new-field  --named code                      --type String                    --length 002                                                                   --not-nullable
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named country                   --type com.blacksmith.nikiti.model.Country                                      --relationship-type Many-to-One --not-nullable

jpa-new-entity --named City                      --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255
jpa-new-field  --named province                  --type com.blacksmith.nikiti.model.Province                                     --relationship-type Many-to-One --not-nullable

jpa-new-entity --named Neighborhood              --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255
jpa-new-field  --named city                      --type com.blacksmith.nikiti.model.City                                         --relationship-type Many-to-One --not-nullable

jpa-new-entity --named Company                   --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255 
jpa-new-field  --named landline                  --type String                    --length 015
jpa-new-field  --named cellphone                 --type String                    --length 015
jpa-new-field  --named email                     --type String                    --length 031
jpa-new-field  --named postalCode                --type String                    --length 009                                                                   --not-nullable
jpa-new-field  --named street                    --type String                    --length 127                                                                   --not-nullable
jpa-new-field  --named houseNumber               --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named complement                --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named country                   --type com.blacksmith.nikiti.model.Country                                      --relationship-type Many-to-One
jpa-new-field  --named province                  --type com.blacksmith.nikiti.model.Province                                     --relationship-type Many-to-One
jpa-new-field  --named city                      --type com.blacksmith.nikiti.model.City                                         --relationship-type Many-to-One
jpa-new-field  --named neighborhood              --type com.blacksmith.nikiti.model.Neighborhood                                 --relationship-type Many-to-One

jpa-new-entity --named Position                  --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255 

jpa-new-entity --named Schedule                  --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255 

java-new-enum  --named Gender                    --target-package com.blacksmith.nikiti.model
java-add-enum-const --named Male 
java-add-enum-const --named Female 

jpa-new-entity --named Employee                  --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255 
jpa-new-field  --named gender                    --type com.blacksmith.nikiti.model.Gender                                                                       --not-nullable
jpa-new-field  --named birth                     --type java.util.Date            --temporal-type DATE 
jpa-new-field  --named landline                  --type String                    --length 015
jpa-new-field  --named cellphone                 --type String                    --length 015
jpa-new-field  --named email                     --type String                    --length 031
jpa-new-field  --named postalCode                --type String                    --length 009                                                                   --not-nullable
jpa-new-field  --named street                    --type String                    --length 127                                                                   --not-nullable
jpa-new-field  --named houseNumber               --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named complement                --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named country                   --type com.blacksmith.nikiti.model.Country                                      --relationship-type Many-to-One
jpa-new-field  --named province                  --type com.blacksmith.nikiti.model.Province                                     --relationship-type Many-to-One
jpa-new-field  --named city                      --type com.blacksmith.nikiti.model.City                                         --relationship-type Many-to-One
jpa-new-field  --named neighborhood              --type com.blacksmith.nikiti.model.Neighborhood                                 --relationship-type Many-to-One
jpa-new-field  --named identityNumber            --type String                    --length 017
jpa-new-field  --named identityIssuer            --type String                    --length 063
jpa-new-field  --named taxPayerNumber            --type String                    --length 017
jpa-new-field  --named socialSecurityId          --type String                    --length 017
jpa-new-field  --named admission                 --type java.util.Date            --temporal-type DATE                                                           --not-nullable
jpa-new-field  --named dealStart                 --type java.util.Date            --temporal-type DATE
jpa-new-field  --named dealEnd                   --type java.util.Date            --temporal-type DATE
jpa-new-field  --named legacySheetId             --type Integer                                                                                                  --not-nullable  
jpa-new-field  --named position                  --type com.blacksmith.nikiti.model.Position                                     --relationship-type Many-to-One
jpa-new-field  --named schedule                  --type com.blacksmith.nikiti.model.Schedule                                     --relationship-type Many-to-One

cd ..
cd Company.java
jpa-new-field  --named employees                 --type com.blacksmith.nikiti.model.Employee                                     --relationship-type One-to-Many --inverse-field-name company --fetch-type LAZY

jpa-new-entity --named Facility                  --target-package com.blacksmith.nikiti.model
jpa-new-field  --named name                      --type String                    --length 063                                                                   --not-nullable
jpa-new-field  --named description               --type String                    --length 255 
jpa-new-field  --named landline                  --type String                    --length 015
jpa-new-field  --named cellphone                 --type String                    --length 015
jpa-new-field  --named email                     --type String                    --length 031
jpa-new-field  --named postalCode                --type String                    --length 009                                                                   --not-nullable
jpa-new-field  --named street                    --type String                    --length 127                                                                   --not-nullable
jpa-new-field  --named houseNumber               --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named complement                --type String                    --length 031                                                                   --not-nullable
jpa-new-field  --named country                   --type com.blacksmith.nikiti.model.Country                                      --relationship-type Many-to-One
jpa-new-field  --named province                  --type com.blacksmith.nikiti.model.Province                                     --relationship-type Many-to-One
jpa-new-field  --named city                      --type com.blacksmith.nikiti.model.City                                         --relationship-type Many-to-One
jpa-new-field  --named neighborhood              --type com.blacksmith.nikiti.model.Neighborhood                                 --relationship-type Many-to-One
jpa-new-field  --named companies                 --type com.blacksmith.nikiti.model.Company                                      --relationship-type One-to-Many
jpa-new-field  --named employees                 --type com.blacksmith.nikiti.model.Employee                                     --relationship-type One-to-Many

jpa-generate-daos-from-entities --generator JPA_ENTITY --package-name com.blacksmith.nikiti.dao --persistence-unit nikitiPU --targets com.blacksmith.nikiti.model.* 

rest-setup --application-path /rest --target-package com.blacksmith.nikiti.rest --config APP_CLASS 
rest-generate-endpoints-from-entities --generator JPA_ENTITY --package-name com.blacksmith.nikiti.rest --persistence-unit nikitiPU --targets com.blacksmith.nikiti.model.* --content-type application/json
swagger-setup
swagger-generate

adminfaces-setup
scaffold-setup --provider AdminFaces --web-root /admin-faces
scaffold-generate --entities com.blacksmith.nikiti.model.* --provider AdminFaces --web-root /admin-faces

build
build test

as-setup --server wildfly --version 21.0.2.Final --install-dir $HOME/wildfly-21.0.2.Final 
