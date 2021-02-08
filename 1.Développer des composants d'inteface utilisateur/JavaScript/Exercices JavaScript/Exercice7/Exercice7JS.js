const boutonEnvoi = document.getElementById("envoyer");



const Verif = () => {
    let nom =document.getElementById("NOMPrenom").value;
    let cin = document.getElementById("CIN").value;
    let email = document.getElementById("email").value;
    var liste = document.getElementById("modules");
    var longueur = liste.options.length;
    if (nom=="" || cin=="" || email==""){
        alert("Les champs * sont obligatoires.")
        return false;
    } else if(cin.length!=8){
        alert("Le format correct du CIN est de 8 chiffres.")
        return false;
    } else if (!email.includes("@")){
        alert("Le format de l'email n'est pas respecté.")
        return false;
    //}else if (longueur >= 3){
      //  alert("Vous ne pouvez sélectionner que 2 modules au maximum")
      //  longueur = 2;
      //  return false;
    } else {
        return true;
    }

}

boutonEnvoi.addEventListener('click', function(){
    const verification = Verif();
    if (verification==true){
        alert("Insciption achevée!!");
    } 
})
