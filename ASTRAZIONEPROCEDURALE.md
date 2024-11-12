# Come commentare correttamente l'astrazione procedurale

L'astrazione procedurale è molto comoda principalmente per due motivi:
* **Locality**: L'implementazione di un'astrazione può essere letta o scritta senza bisogno di esaminare l'implementazione di altre astrazioni
* **Modifiability**: Un'astrazione può essere reimplementata senza richiedere cambiamenti a nessuna astrazione che la usa

Le specifiche di una funzione vanno scritte nella forma:

    return_type pname (...)
    // REQUIRES: Definisce eventuali vincoli sull'uso
    // MODIFIES: Definisce tutti gli input modificati
    // EFFECTS: Definisce il comportamento della funzione

## REQUIRES

La clausola `REQUIRES` stabilisce i vincoli nei quali l'astrazione è definita. La clausola `REQUIRES` è necessaria se la funzione è *parziale*, ovvero se il suo comportamento non è definito per alcuni inputs. **Se la procedura invece è *totale*, ovvero è definita per ogni input, la clausola** `REQUIRES` **può essere omessa**. In questo caso le uniche restrizioni sono date dalla procedura stessa come numero di argomenti e tipi di inputs

N.B. Per la maggior parte dei file gli inputs sono i parametri descritti dalla funzione. Nonostante ciò alcune procedure possono avere input impliciti: ad esempio se la procedura legge alcune informazioni da un file e scrive su `System.out`, anche il file e `System.out` fanno parte degli inputs

## MODIFIES

La clausola `MODIFIES` elenca i nomi di tutti gli inputs (anche quelli impliciti) che sono modificati dalla procedura. Se alcuni input vengono modificati, la procedura si dice che possieda dei *side effects*. **La clausola** `MODIFIES` **può essere omessa quando non viene modificato nessun input.**

## EFFECTS

La clausola `EFFECTS` descrive il comportamento della procedura per tutti gli inputs non esclusi da `REQUIRES`. Deve definire quali outputs sono prodotti e anche quali modifiche sono fatte agli inputs elencati in `MODIFIES`. La clausola `EFFECTS` è scritta danto per scontato che i limiti di `REQUIRES` siano rispettati, e non dice nulla del comportamento della procedura nel caso essi non siano rispettati.

### Esempi


    public static int search (int[ ] a, int x)
        // EFFECTS: If x is in a, returns an index where x is stored;
        // otherwise, returns -1.

    public static int searchSorted (int[ ] a, int x)
        // REQUIRES: a is sorted in ascending order
        // EFFECTS: If x is in a, returns an index where x is stored;
        // otherwise, returns -1.

    public static void sort (int[ ] a)
        // MODIFIES: a
        // EFFECTS: Rearranges the elements of a into ascending order
        // e.g., if a = [3, 1, 6, 1] before the call, on return a = [1, 1, 3, 6].

*sort* e *search* sono funzioni totali, ovvero sono definite per ogni input: di conseguenza non possiedono `REQUIRES` che invece *searchSorted* possiede in quanto per funzionare richiede che l'array in input sia in ascending order

Notare che in *searchSorted* `EFFECTS` non definisce cosa succede se **a** non è in ascending order, ma da per scontato che la `REQUIRES` sia rispettata

*search* e *searchSorted* non modificano i loro inputs: di conseguenza non possiedono `MODIFIES` che invece *sort* possiede in quanto modifica l'array di input ordinandolo

Nella clausola `EFFECTS` di *sort* possiamo vedere come sia descritta la modificazione dell'input nella funzione, con un esempio prima e dopo

    public static void copyLine( )
    // REQUIRES: System.in contains a line of text
    // MODIFIES: System.in and System.out
    // EFFECTS: Reads a line of text from System.in, advances the cursor in
    // System.in to the end of the line, and writes the line on System.out.

Notare che sono descritti i cambiamenti degli inputs impliciti

### Alcune proprietà importanti

* **Minimality**: Una specifica è più minimale di un'altra se contiene meno vincoli sui comportamenti ammessi

* **Undetermined behavior**: Una procedura indeterminata se per certi inputs ha più di un possibile risultato

* **Deterministic implementation**: Una implementazione di una procedura è deterministica se, con gli stessi inputs, produce sempre lo stesso risultato. Le implementazioni di procedure indeterminate sono quasi sempre deterministiche

* **Generality**: Una specifica è più generale di un'altra se può gestire una classe maggiore di inputs