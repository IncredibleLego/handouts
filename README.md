# Prog2@UniMI Handouts di Francesco Corrado

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![License: CC BY-SA 4.0](https://img.shields.io/badge/License-CC%20BY--SA%204.0-blue.svg)](http://creativecommons.org/licenses/by-sa/4.0/)
[![Workflow results](https://github.com/prog2-unimi/handouts/actions/workflows/gradle.yml/badge.svg)](https://github.com/prog2-unimi/handouts/actions/workflows/gradle.yml)

Questo repository contiene gli *handout* dell'insegnamento di [Programmazione
II](https://prog2.di.unimi.it/) del corso di laurea in
[Informatica](https://informatica.cdl.unimi.it/it) dell'[Università degli Studi
di Milano](http://www.unimi.it/). Si tratta di una copia della [Repository ufficiale](https://github.com/prog2-unimi/handouts) del prof. Questa repository
è stata creata con lo scopo di allenarsi ad usare Git.

Il materiale di questo repository (aggiornato periodicamente) consiste nella
collezione del *materiale didattico* prodotto dal docente e dalla soluzione o implementazione
degli esercizi svolti dallo studente.

La situazione attuale della risoluzione degli esercizi e test può essere visualizzata [qui](build/reports/tests/test/classesJubbiotTest.html)

## Guida all'uso di Git

Come è gestito Git?
![schema](/assets/images/schema.png)
La mia copia locale del repository è composta da tre "alberi" mantenuti da git. Il primo è la Directory di lavoro che contiene i files attuali. Il secondo è l'Index che fa da spazio di transito per i files e per finire l'HEAD che punta all'ultimo commit fatto.

Ecco alcuni comandi che possono essere utili all'uso e la gestione di Git:

### Creare e clonare una repo

    git init

Crea una nuova repository

    git clone https://github.com/IncredibleLego/handouts.git

Clona la repository (sostituire il link con la repo corrispondente)

### Aggiungere le modifiche effettuate

    git add <nomefile>
    git add .
Aggiungi uno specifico file con il `nomefile` oppure tutti i file usando `.`

    git commit -m Messaggio per la commit
Carica il file correttamente nell'HEAD (non ancora nella repo). Il messaggio contenuto in `Messaggio per la commit` è il messaggio che poi comparirà come descrizione delle modifiche effettuate

    git push
Carica infine le modifiche effettuate alla repo

### Aggiornare le repo

    git pull
Aggiorna la repo locale all'ultima versione: fa un **fetch** delle modifiche dal server remoto e un **merge** cona la repo locale, scaricando ed incorporando in locale eventuali modifiche effettuate

Ulteriori comandi e materiali possono essere trovati al seguente [link](https://rogerdudler.github.io/git-guide/index.it.html)

![schema](/assets/images/GitWorkflow.png)


## Scaricare in locale il materiale

Si può scaricare il file [Zip](https://github.com/prog2-unimi/handouts/archive/master.zip) del contenuto
di questo repository usando il link in questa frase, oppure il bottone verde "Clone or download" in altro a destra nella pagina dove sta leggendo questo `README.md`.

## Come compilare ed eseguire i test e il codice

Una volta ottenuta una copia locale può procedere a **compilare** il codice con
il comando:

    ./gradlew build
    ./gradlew test

Su GNU/Linux, oppure se si usa Windows usare `./gradlew` con `gradlew.bat`; questo comando provvederà
anche ad eseguire tutti i **test** specificati nella directory `tests`.

Si può eserguire il codice di una specifica classe, ad esempio
`it.unimi.di.prog2.h02.SalveMondo` con il comando

    ./gradlew runClass -PmainClass=it.unimi.di.prog2.h02.SalveMondo
Per maggiori informazioni sul **funzionamento dei test** consulti l'[esempio d'uso di
Jubbiot](https://github.com/prog2-unimi/jubbiot/blob/master/README.md#example);
in particolare presti attenzione alla sezione sulla [generazione degli output
dello studente](https://github.com/prog2-unimi/jubbiot/blob/master/README.md#generating-actual-outputs).

### Come generare la documentazione

La ocumentazione può essere generata in locale con il comando:

    ./gradlew javadoc

Tale comando è configurato per riportare un errore in caso di *warning*, per aiutare a comprendere se la documentazione è, almeno dal punto di vista sintattico, completa.

È possibile accedere direttamente ad una copia già compilata della
[documentazione del codice in questo repository](https://prog2-unimi.github.io/handouts/).

## Materiale Anni Passati

* branch dell'[AA 2019/20](../../tree/aa1920),
* branch dell'[AA 2020/21](../../tree/aa2021),
* branch dell'[AA 2021/22](../../tree/aa2122),
* branch dell'[AA 2022/23](../../tree/aa2223),
* branch dell'[AA 2023/24](../../tree/aa2324).

[comment]: <> (Per modificare il file con l'anteprima premere CTRL + Shift + V)