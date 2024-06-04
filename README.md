# TestWorkPetStore

test.person.1992.test@gmail.com
Dana89298!


mvn clean test  
mvn test 
mvn test -Dbrowser=firefox 
mvn test -Dbrowser=MicrosoftEdge -Dscreen=DESKTOP_L
mvn test -Dbrowser=safari -Dscreen=d_m
mvn test -Dbrowser=safari -Dscreen=D_S
mvn test -Dscreen=D_S

-Dscreen  --> com.core.models.enums.ScreenSize  --> com.core.providers.ScreenProvider
DESKTOP_L(1920 x 1080),
DESKTOP_M(1536 x 864),
DESKTOP_S(1280 x 720),
MOBILE_M(414 x 896),
MOBILE_S(360 x 800),
TABLET(768 x 1024);