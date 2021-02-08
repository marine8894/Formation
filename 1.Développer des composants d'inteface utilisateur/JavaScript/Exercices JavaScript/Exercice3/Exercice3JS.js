const bouton = document.getElementById("bouton");

bouton.addEventListener('click', function(){
    let saisieChiffre = document.getElementById("saisieChiffre").value;
    let affichage = document.getElementById("affichage");
    let table = "TABLE DE MULTIPLICATION de " + saisieChiffre +"\n";
    for (let i = 1; i<=10; i++){
        resultat = saisieChiffre * i;
        table += saisieChiffre + " x " + i + " = " + resultat + "\n";
    }
    affichage.value = table;
})