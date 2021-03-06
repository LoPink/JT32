const INFO = document.getElementById('info')
const LISTA = document.getElementById('lista')
const FORM = document.getElementById('form')

const URL = "https://reqres.in/api/users/";


//$.ajax({
//    url:'https://reqres.in/api/users?page=2'
//    type:'GET',
//    dataType: 'json',
//    success: function(dati){
//      var $users = dati.data;
//      $users.forEach(user => {
//          $('#lista').append('<li>'+ user.first_name +'</li>')
//      })
//
//      $('li').on('click', function(){
//          $('#card').append('')
//          $('#card').append('<h1>'+ $users[$(this).index()].first_name)
//          $('#card').append('<img src="'+ $users[$(this).index()].avatar + '">')
//
//
//
//
//      })
//
//    },    
//    error:function(){
//      console.log('qualcos è andato storto')
//    }
//
//})

let listaUser=[];
var listaLocal=[];

fetch(URL).then(j => j.json()).then(persone => 
{

    //let avatar = [];

    //listaUser = persone.data;
    //localStorage.setItem('lista', JSON.stringify(listaUser))
    
    listaLocal = JSON.parse(localStorage.getItem('lista'))
    
    // LISTA
    for(user of listaLocal){
        //console.log(typeof(listaLocal))    
        $('ul').append('<li>'+user.first_name+'<button class="btn-elimina" id="'+ user.id +'">Elimina</button></li>')
        //avatar.push(user.avatar);
        //let elimina = document.getElementById('elimina');

    }
    
    // CARD
    $('li').on('click', function(){
        
        //console.log(listaLocal[$(this).index()].id)
        $('#cartaInfo').html('');
        $('#cartaInfo').append('<img src='+ listaLocal[$(this).index()].avatar +'>');
        $('#cartaInfo').append("<div class='card-body'></div>");
        $('.card-body').append('<h5>'+ listaLocal[$(this).index()].first_name + ' ' + listaLocal[$(this).index()].last_name +'</h5>');
        $('.card-body').append('<p>' + listaLocal[$(this).index()].email + '</p>');
        $('.card-body').append('<button class="btn-modifica" id="'+ listaLocal[$(this).index()].id +'">Modifica</button>')  

        //MODIFICA
        $('.btn-modifica').on('click', function(){
        
            var idCorrenteM = Number(this.getAttribute('id'))
            var nomeCorrenteM = listaLocal[idCorrenteM-1].first_name
            var cognomeCorrenteM = listaLocal[idCorrenteM-1].last_name
            var emailCorrenteM = listaLocal[idCorrenteM-1].email
            // console.log(idCorrenteM)
            // console.log(nomeCorrenteM)
            // console.log(cognomeCorrenteM)
            // console.log(emailCorrenteM)
            var nome = document.getElementById('nome')
            var cognome = document.getElementById('cognome')
            var email = document.getElementById('email')

            nome.setAttribute('value', nomeCorrenteM)
            cognome.setAttribute('value', cognomeCorrenteM)
            email.setAttribute('value', emailCorrenteM)
            
            listaLocal = listaLocal.filter( p => p.id != idCorrenteM );
            
            localStorage.setItem('lista', JSON.stringify(listaLocal))

        });


    });
    


//ELIMINA
    $('.btn-elimina').on('click', function(){
           
        //var listaTmp = [];

        var idCorrente = this.getAttribute('id')

        listaLocal = listaLocal.filter( p => p.id != idCorrente );

        // for(var i=0; i<listaLocal.length; i++){
        //     if(listaLocal[i].id!=idCorrente){
        //         listaTmp.push(listaLocal[i]);
        //     }
        // }
        //listaLocal.splice(idCorrente-1, 1)
        
        //console.log("idCorrente = "+ idCorrente)
        //console.log('listaLocal[idCorrente-1] = '+listaLocal[idCorrente-1])
        //console.log(listaLocal.indexOf())

        localStorage.setItem('lista', JSON.stringify(listaLocal))
    
    });
    
});

    
    

// CARICA
$('#carica').on('click', function(){

    var nome = document.getElementById('nome').value
    var cognome = document.getElementById('cognome').value
    var email = document.getElementById('email').value
    var incrementoId = listaLocal.length

    var utente = {
        id: ++incrementoId,
        email: email,
        first_name: nome,
        last_name: cognome,
        //aggiungere avatar con unsplash 128x128
    }
    
    //console.log(++listaLocal.length)

    //console.log(utente)
    //localStorage.setItem('utente', JSON.stringify(utente))
    //localStorage.getItem('lista')
    
    //localStorage.removeItem('utente')

    listaLocal.push(utente)
    
    console.log(listaLocal)

    localStorage.removeItem('lista')

    localStorage.setItem('lista', JSON.stringify(listaLocal))
    
    fetch(URL, {
        method: 'POST',
        body: JSON.stringify(utente),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
    .then((response) => response.json())
    .then((json) =>  console.log(json));

});




