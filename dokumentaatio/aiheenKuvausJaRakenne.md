#Aihe: Shakki
Toteutetaan shakkiohjelma jota voi pelata itseään (tai hotseat-tyylisesti toista pelaajaa) vastaan. Tekoälyä tai internetin kautta pelaamista ei toteuteta. Myös joitakin shakkivariantteja voidaan pelata, ja käyttäjä voi lisätä uusia variantteja (tietyissä rajoissa, esimerkiksi luultavasti pitää pysyä ruudukossa eikä voi käyttää esimerkiksi heksoja).

##Käyttäjät: Pelaaja

###Itse pelaamiseen liittyvät toiminnot:
* Voi tehdä laillisen siirron
  * muttei laitonta
* Peruutustoiminto
* Siirtosarjan syöttö algebrallisella merkintätavalla (esim. 1. e4 e5 2. Nf3 Nc6)
* Voi syöttää siirtosarjan (esim. 1. d4 d5 2. d4 e5 3. xe5 jne) ja jatkaa siitä pelaamista

###Varianttien lisäys
* Voidaan lisätä xml-tiedosto joka kuvaa variantin. UI tuntee valmiiksi kaksi varianttia (ja standardishakin), käyttäjä voi myös syöttää haluamansa xml-tiedoston.

![Luokkakaavio](/dokumentaatio/luokkakaavio.png)
![Sekvenssikaavioita](/dokumentaatio/sekvenssikaavio.png)
