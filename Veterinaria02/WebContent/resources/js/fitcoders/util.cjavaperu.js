function hide(idModal) {
    $(idModal).modal('hide');
    if ($(".modal-backdrop") !== null) {
        $(".modal-backdrop").remove();
    }
}
function show(idModal) {
    $(idModal).modal('show');

}

function limpiarCSSTablaPrimeFaces() {
    console.log("Limipar");
    $('table').addClass('table table-bordered table-striped');

    $('table').closest('div.ui-datatable').removeClass();
    $('table thead th').removeClass('ui-state-default');
}

function changeInput(event, id) {
    console.log(event);
    if (event.keyCode == 13) { 
        document.getElementById(id).focus(); 
        return false; 
    }
}

function clickButton(event, id) {
    if (event.keyCode == 13) { 
        document.getElementById(id).click(); 
        return false; 
    }
}

function showMessage(sumary, detail, tipe) {
    PF('growl').renderMessage({"summary": sumary,
        "detail": detail,
        "severity": tipe});
    //"warn"
    //"info
    //error
}
//carlos chata
function deshabilitaRetroceso(){
    window.location.hash="no-back-button";
    window.location.hash="Again-No-back-button" //chrome
    window.onhashchange=function(){window.location.hash="no-back-button";}
}