# 1. BEADANDÓ:

# RÖVID ISMERTETŐ:

 - Egy olyan webalkalmazás amely, elősegíti egy könyvesbolt rendeléseinek a nyilvántartását.
 - A felhasználók lehetnek vendégek (nem regisztrált felhasználók), regisztrált felhasználók( rendelhetnek könyveket ), illetve dolgozók, akik átállíthatják a felvett rendelések státuszát.
 

# KÖVETELMÉNYEK ÖSSZEGYŰJTÉSE:

-  Funkcionális elvárások
-  nyújtandó szolgáltatások ismertetése
-  Nem funkcionális követelmények
-  használhatóság
-  teljesítmény
-  rendelkezésre állás
-  skálázhatóság
-  biztonság
-  karbantarthatóság
  
# FUNKCIONÁLIS KÖVETELMÉNYEK:

-  Vendégként a főoldalon kiemelt ajánlatokat láthatunk kategóriánként.
-  Vendégként megtekinthetjük a könyek leírását.
-  Vendégként kereshetünk a könyvek között.
-  Vendégként regisztrálhatunk az oldalra.
-  Felhasználóként be tudunk jelentkezni az oldalra.
-  Felhasználóként szerkeszthejük a profiljukat.
-  Felhasználóként új rendelést küldhetünk be.
-  Felhasználóként láthatjuk régebbi rendeléseinket.
-  Dolgozóként láthatjuk a megrendelések listáját.
-  Dolgozóként állíthatjuk egy rendelés státuszát.
  
# NEM FUNKCIONÁLIS KÖVETELMÉNYEK:

-  Felhasználóbarát, ergonomikus elrendezés és kinézet.
-  Gyors működés.
-  Biztonságos működés: jelszavak tárolása, funkciókhoz való hozzáférés.
  
# SZEREPKÖRÖK:

-  jogosultsági csoportok
-  elérhető funkciók
  
# SZEREPKÖRÖK:

-  vendég: könyvek keresését, böngészését, leírások/ajánlók megtekintését végezheti.
-  felhasználó: a vendég szerepkörén túl rendelések beküldésére jogosult, illetve listázhatja régebbi rendeléseit.
-  dolgozók: látják a rendelési listát, illetve a rendelések státuszát átállíthatják.
 
# 2. BACKEND DOKUMENTÁCIÓ

# Fejlesztői környezet bemutatása, beállítása, használt technológiák

A programot a IntelliJ és Eclipse fejlesztői környezetben készítettük. A project elkészítéséhez a Spring Boot keretrendszert használjuk, adatbázisnak pedig egy H2 adatbázist használtunk. Az adatbázis beállítása az application.properties fájban található meg.

# Adatbázis terv

![Adatbázis UML](/image/AlkfejlUML.png)

Az Author és a Book tábla között illetve a Book és a BookOrder között OneToMany kapcsolat van. A BookOrder és az User tábla között pedig ManyToOne kapcsolat van.

# Könyvtárstruktúra bemutatása

![Könyvtár szerkezet](/image/konyvtar1.png)
![](/image/konyvtar2.png)


A project könyvtárstruktúrája a fenti képen látható. A programunk az MVC szerkezeti mintát követi. Az entity packageben találhatóak az adatbázisban található táblák megvalósításai. Minden egyes entitáshoz a repository packageben található egy repó amik segítségével kérhetünk le rekordokat az adatbázisból. Ezeket a repókat a service packageben találhato @Service classokban használjuk. Ezekben az osztályokban történik az adatbázissal való kommunikáció folyamatok megvalósítása. A controller packageben találhatóak a @RestController osztályok.

# Végpontok

Author (/author):
 /listall             get    kilistázza az összes írót
 /new                 post   új írót ad hozzá az adatbázishoz
 
 Book (/book):
 /listall             get    kilistázza az összes könyvet
 /{id}                get    kiírja az adott id-vel rendelkező könyv adatait
 /new                 post   új könyvet ad hozzá az adatbázishoz
 /category/{category} get    kilistázza az adott kategóriájú könyveket
 
 BookOrder (/bookorder):
 /listall             get   kilistázza az összes rendelés
 /new                 get   új rendelést ad hozzá az adatbázishoz
 /oldorders           post  kilistázza a adott felhasználóhoz tartozó régi rendeléseket  
 /updatestatus        post  módosítja az adott rendelés státuszát
 
 User (/user):
 /listall             get   kilistázza az összes felhasználót
 /register            post  új felhasználót ad hozzá az adatbázishoz
 /login               post  bejelentkező oldal
 /edit                post  szerkeszti az adott felhasználó adatait
 
# Egy végpont működése:

![](/image/Vegpontszeq.png)
 

# Üzembe helyezés
## Frontend
Az alkalmazás frontend részének elindításához szükség van az npm csomagkezelőre. Ez a NodeJs szoftverrendszerrel együtt telepítésre kerül pl: https://nodejs.org/dist/v8.9.3/node-v8.9.3-x64.msi linken elérhető.
Ennek telepítése után már elérhetővé válik parancssorból az npm csomagkezelő, és a projekt mappájába navigálás után az "npm install" parancs kiadásával letöltésre kerülnek a szükséges könyvtárak, amelyek a package.json fájlban kerültek meghatározásra.
Még az első indítás előtt célszerű ellenőrizni, hogy mely címen lesz elérhető a backend kiszolgáló, ez alapértelmezetten a "localhost:8080", de tetszőlegesen átírható a book-service.service.ts, bookorder.service.ts, és a login.service.ts fájlokban ahogy arra szükség van.
Mindezek után az alkalmazás parancssorból az "ng serve" parancs kiadásával indítható el.

## Backend
A kiszolgáló üzemeltetéséhez Java jre telepítése szükséges, de adott esetben az Eclipse fejlesztőkörnyezet képes a futtatására.
A függőségek a pom.xml fájlban kerülnek tárolásra.
Elindítani Eclipse környezetben, úgy lehet, hogy kiválasztjuk az AlkfejlApplication.java fájlt, azon jobb gombot nyomunk, majd a Run As menüből kiválasztjuk a Java Application menüpontot.
Ekkor elindul a szerver, alapértelmezetten lefoglalva a 8080-as portot, ez módosítani a resources/application.properties fájlban lehet amennyiben szükséges.

Innentől kezdve ha sikeresen beállításra került a két rész, érzékelni fogják egymást, és használatba vehető az alkalmazás.

