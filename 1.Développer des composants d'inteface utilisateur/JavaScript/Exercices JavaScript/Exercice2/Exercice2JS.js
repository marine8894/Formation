const bouton = document.getElementById("bouton");

bouton.addEventListener('click', function(){
    let saisieMois = document.getElementById("saisieMois").value;
    let saisieAnnee = document.getElementById("saisieAnnee").value;
    if (saisieMois ==1 || saisieMois ==3 || saisieMois==5 || saisieMois==7 || saisieMois==8 || saisieMois==10 || saisieMois==12){
        alert("Il y a 31 jours dans le mois.");
    } else if (saisieMois==4 || saisieMois==6 || saisieMois==9 || saisieMois==11){
        alert("Il y a 30 jours dans le mois.");
    } else if(saisieMois==2){
        if ((saisieAnnee%4==0 && saisieAnnee%100!==0) || saisieAnnee%400==0){
            alert("C'est le mois de février, d'une année bissextile. Il y a 29 jours dans le mois");
        } else {
            alert("C'est le mois de février, d'une année normale. Il y a 28 jours dans le mois");
        }
    }
});

