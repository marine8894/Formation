const bouton = document.getElementById("bouton");

bouton.addEventListener('click', function(){
    let saisieChiffre = document.getElementById("chiffre").value;
    alert("La racine carrée de " + saisieChiffre + " est de " + (saisieChiffre*saisieChiffre));
})