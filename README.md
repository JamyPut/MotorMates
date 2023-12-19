# MotorMates
Eindopdracht novi backend

Doorloop de volgende stappen om deze applicatie te starten:


Installatie backend

Om dit bestand te kunnen bekijken is de volgende software nodig:

Java   
https://www.java.com/nl/

Een IDE zoals bijvoorbeeld Intellij  
https://www.jetbrains.com/idea/download/#section=windows

Git   
https://git-scm.com/downloads

Postgress voor de database   
https://www.postgresql.org/

Postman om endpoints te kunnen checken   
https://www.postman.com/downloads/

Clone het project van de volgende github link:  
https://github.com/JamyPut/MotorMates


In Intellij kan het project geopend worden.  
Ga naar File | new | project from  version control


Plak vervolgens de github link die je gecloned hebt in de url.   
Maak een nieuwe map aan voor het project en klik op clone. 
Klik vervolgens op ‘trust project’. Het project zal openen in Intellij.  

Dit project heeft versiebeheer van Maven.  
Ga naar View | Tool windows | Maven  
Er opent zich een zijvenster. Klap de folder uit.  
Ga naar de map ‘lifecycle’.  
Selecteer CLEAN en INSTALL (met ctrl) en klik op run.   
Maven zal het project vervolgens bijwerken.  


Open vervolgens het bestand application.properties  
en plak de volgende tekst daarin


***
spring.datasource.url=jdbc:postgresql://localhost:5432/motormates
spring.datasource.username=postgres
spring.datasource.password=postgres123
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
***

Maak met deze gegevens een datasource aan in Intellij waarmee de verbinding met een postgress database kan worden gelegd  

Hierna kan het project worden opgestart.




