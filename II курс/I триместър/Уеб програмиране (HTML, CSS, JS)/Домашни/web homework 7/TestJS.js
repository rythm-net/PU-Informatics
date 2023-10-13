
  function allowDrop(ev)
  {
    ev.preventDefault();
  }

  function drag(ev)
  {
    ev.dataTransfer.setData("Text",ev.target.id);
  }

  function drop(ev)
  {
    console.log(ev)
    ev.preventDefault();
    var data=ev.dataTransfer.getData("Text");
    if (ev.target.classList.contains('container')) {
      var container = ev.target;
      container.appendChild(document.getElementById(data));
    } else {
      container = ev.target.parentElement;
      container.insertBefore(document.getElementById(data), ev.target);
    }
  }
  function checkAnswer(){
      if(document.getElementById("aTF").value==209){
        alert("Верен отговор");
      }
      else{
        alert("Грешен отговор");
      }
  }
  function checkAnswerQ5(){
   alert("Грешен отговор");
  }
  
  function q5T(){
    alert("Верен отговор");
  }

function checkAnswerQ6(){

  if(document.getElementById("html").checked==true && document.getElementById("css").checked==true&&document.getElementById("javascript").checked==true){
    alert("Верен отговор 3/3 точки")
  }
  else if((document.getElementById("html").checked==true && document.getElementById("css").checked==true)
  || (document.getElementById("html").checked==true && document.getElementById("javascript").checked==true)
  || (document.getElementById("css").checked==true && document.getElementById("javascript").checked==true)){
    alert("Верен отговор 2/3 точки");
  }
  else if(document.getElementById("html").checked==true
  || document.getElementById("css").checked==true
  ||document.getElementById("javascript").checked==true){
    alert("Верен отговор 1/3 точки");
  }
  else if((document.getElementById("html").checked==false && document.getElementById("css").checked==false && document.getElementById("javascript").checked==false) 
  &&(document.getElementById("python").checked==true || document.getElementById("java").checked==true || document.getElementById("c++").checked==true)){
    alert("Грешен отговор 0/3 точки");
  }
  else if(document.getElementById("html").checked==false && document.getElementById("css").checked==false && document.getElementById("javascript").checked==false
  && document.getElementById("python").checked==false && document.getElementById("java").checked==false && document.getElementById("c++").checked==false){
    alert("Не може да оставите празно");
  }
  document.getElementById("html").checked=false
  document.getElementById("css").checked=false
  document.getElementById("javascript").checked=false
  document.getElementById("python").checked=false
  document.getElementById("java").checked=false
  document.getElementById("c++").checked=false
}
function close_window() {
    if (confirm("Close Window?")) {
        window.close();
    }
  }