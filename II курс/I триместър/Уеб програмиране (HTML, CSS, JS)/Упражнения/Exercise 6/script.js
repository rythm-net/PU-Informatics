function initall(){
    var bobs = document.getElementsByClassName("bob");
    for (i=0; i < bobs.length; i++)
    initit(bobs[i]);
}    
    function initit(el){
    el.style.left = 0;
    el.style.top = 0;
    }

    function bcm(e){
    var d = e.keyCode;
    switch (d){
        case 82 : bob = red; break;
        case 71 : bob = green; break;
        case 66 : bob = blue; break;
        case 67 : bob.style.borderRadius = "25px"; break;
        case 83 : bob.style.borderRadius = "0px"; break;
        case 37 : bob.style.left = parseInt(bob.style.left) - 50 + 'px'; break;
        case 38 : bob.style.top = parseInt(bob.style.top) - 50 + 'px'; break;
        case 39 : bob.style.left = parseInt(bob.style.left) + 50 + 'px'; break;
        case 40 : bob.style.top = parseInt(bob.style.top) + 50 + 'px'; break; 
    }
    bob.innerHTML = d;
    }
window.onload = initall;
document.onkeydown = bcm;