const VIAGGI = document.getElementById("viaggi");
const FORM = document.getElementById("form");
const DETTAGLIO = document.getElementById("dettaglio");
const URL = "api/viaggi";


fetch(URL).then(j => j.json()).then(viaggi => 
{
    for(var viaggio of viaggi){
        var id = viaggio.id;
        var trip = document.createElement('div');
        var testo = document.createElement('div');
        var h2 = document.createElement('h2');
        var p = document.createElement('p');
        var btn = document.createElement('button');
        var img = document.createElement('img');
        
        btn.setAttribute('id', viaggio.id)

        // btn.onclick = function(){
        //     vaiA(viaggio.id);
        //     //window.location.href="/pagamento.html/"+viaggio.id;
           
        // };
        
        btn.addEventListener('click', function(){
            var viaggioId = btn.getAttribute('id');
            window.location.href="/pagamento.html/"+parseInt(viaggioId);
            console.log('viaggioId');
        })

        h2.innerHTML = viaggio.destinazione + ' - ' + viaggio.durata + ' - ' + viaggio.id;
        p.innerHTML = "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Neque fuga vel totam aut consectetur rem inventore.";
        btn.innerHTML = "Prenota";
        img.setAttribute('src', 'https://source.unsplash.com/400x300/?trip');

        trip.setAttribute('class', 'row row-cols-2');
        
        testo.appendChild(h2);
        testo.appendChild(p);

        trip.appendChild(testo);
        trip.appendChild(img);
        trip.appendChild(btn);

        VIAGGI.appendChild(trip);

        
    }

});

// function vaiA(id){
//     window.location.href="/pagamento.html/"+id;
// }

var conferma = document.getElementById('acquista');
var cognome = document.getElementById('cognome');
var email = document.getElementById('email');
var nCarta = document.getElementById('nCarta');
var nPasseggeri = document.getElementById('passeggeri');
var nome = document.getElementById('nome');



conferma.addEventListener('click', function(){
       
    console.log(nome.value);
    console.log(cognome.value);
    console.log(email.value);
    console.log(nCarta.value);
    console.log(nPasseggeri.value);

})









