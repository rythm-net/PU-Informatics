setInterval(setClock, 1000)

const hourHand = document.querySelector('[data-hour-hand]')
const minuteHand = document.querySelector('[data-minute-hand]')
const secondHand = document.querySelector('[data-second-hand]')
var currentMinutes=Date().split(':')[1];
function setClock() {
  currentMinutes=Number(Date().split(':')[1]);
  const currentDate = new Date()
  const secondsRatio = currentDate.getSeconds() / 60
  const minutesRatio = (secondsRatio + currentDate.getMinutes()) / 60
  const hoursRatio = (minutesRatio + currentDate.getHours()) / 12
  setRotation(secondHand, secondsRatio)
  setRotation(minuteHand, minutesRatio)
  setRotation(hourHand, hoursRatio)
  setNumberChange();
}

function setRotation(element, rotationRatio) {
  element.style.setProperty('--rotation', rotationRatio * 360)
}
var time="3:10";
const numberToChange=document.querySelector('[data-number-three]');
const minute = Number(time.split(':')[1]);

function setNumberChange(){
    if(currentMinutes==35){
        document.body.style.background= 'linear-gradient(to right , rgb(151, 238, 116),rgb(18, 105, 18))';
    }
    else{
        document.body.style.background= 'linear-gradient(to right , rgb(94, 211, 58),rgb(62, 139, 62))';
    }
    if(currentMinutes==46){
        document.querySelector('img').style.display='block';
    }
    else{
        document.querySelector('img').style.display='none';
    }
}

setClock();