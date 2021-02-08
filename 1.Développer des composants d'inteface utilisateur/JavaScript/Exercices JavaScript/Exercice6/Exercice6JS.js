const boutonEgal = document.getElementById("egal");

boutonEgal.addEventListener('click', function(){
    let calcul= document.getElementById("saisieCalcul").value;
    let resultat = document.getElementById("resultCalcul");
    resultat.value = eval(calcul);
})

const lien = document.getElementById("lien");
lien.addEventListener('click', function(){
    let calcul= document.getElementById("saisieCalcul").value;
    alert(calcul + " = " + eval(calcul));
})
