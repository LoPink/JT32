const VIAGGI = document.getElementById("viaggi");
const URL = "api/viaggi";

fetch(URL).then(j => j.json()).then(viaggi => 
{
    for(var viaggio of viaggi){
        var trip = document.createElement('div');
        var testo = document.createElement('div');
        var h2 = document.createElement('h2');
        var p = document.createElement('p');
        var btn = document.createElement('button');
        var img = document.createElement('img');

        h2.innerHTML = viaggio.destinazione;
        p.innerHTML = viaggio.durata;
        img.setAttribute('src', 'https://source.unsplash.com/400x300/?trip');

        testo.appendChild(h2);
        testo.appendChild(p);

        trip.appendChild(testo);
        trip.appendChild(img);
        trip.appendChild(btn);

        btn.addEventListener('click', function(){
            window.location.href="/pagamento";
        })
        
    }







});