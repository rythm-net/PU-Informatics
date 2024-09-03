while(SystemObject.isAlive()) {

    const command = prompt("Въведи команда:");

    if(command == 'turnon') {
        turnonCommand();
    }

    else if(command == 'load') {

        // if(SystemObject.isTurnOn()) {
        //     const robotNameArgument = prompt("Въведи името на роботската ръка")
        //     loadCommand(robotNameArgument);
        // }
        // else {
        //     alert("Трябва да включите системата");
        // }

        if(SystemObject.isTurnOff()) {
            alert("Трябва да включите системата");
            continue;
        }

        const robotNameArgument = prompt("Въведи името на роботската ръка")
        loadCommand(robotNameArgument);
    }

    else if(command == 'unload') {
        const robotNameArgument = prompt("Въведи името на роботската ръка")
        unloadCommand(robotNameArgument);
    }

    else if(command == 'moveX') {

        const directionArgument = prompt("Въведи посока left / right");
        const stepArgument      = prompt("Въведи стъпка ");
        moveCommand('X', directionArgument, stepArgument);
    }

    else if(command == 'moveY') {
        
        const directionArgument = prompt("Въведи посока up / down");
        const stepArgument      = prompt("Въведи стъпка ");
        moveCommand('Y', directionArgument, stepArgument);
    }

    else if(command == 'identify') {
        identifyCommand();
    }

    else if(command == 'cut') {

        const numberArgument = prompt("Въведи число");
        processCommand('cut', numberArgument);
    }

    else if(command == 'fill') {

        const numberArgument = prompt("Въведи число");
        processCommand('fill', numberArgument);
    }

    else if(command == 'finish') {
        processCommand('finish');
    }

    else if(command == 'status') {
        statusCommand();
    }

    else {
        alert("Командата е невалидна, моля опитайте отново да въведете коректна такава")
    }
}


if(SystemObject.gassCount <= 0) {
    console.log(`няма гориво в резервоара, моля презареди`);
}

if(SystemObject.oxigenCount < 24) {
    console.log(`достигнахме критичен кислороден минимум`);
}

console.log(`Мисията е успешна`);