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

# Végpont tervek és leírások

#Egy végpont működésének leírása


