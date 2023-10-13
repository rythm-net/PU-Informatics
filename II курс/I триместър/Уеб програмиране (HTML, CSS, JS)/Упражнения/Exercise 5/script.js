function bi(){
    bob.style.top = "0px";
    bob.style.left = "0px";
}
function bm(e){
    bob.innerHTML = e.key;
    if (e.keyCode == 37) bob.style.left = parseInt(bob.style.left) - 50 + "px";
    else if (e.keyCode == 38) bob.style.top = parseInt(bob.style.top) - 50 + "px";
    else if (e.keyCode == 39) bob.style.left = parseInt(bob.style.left) + 50 + "px";
    else if (e.keyCode == 40) bob.style.top = parseInt(bob.style.top) + 50 + "px";
}
window.onload = bi;
document.onkeydown = bm;