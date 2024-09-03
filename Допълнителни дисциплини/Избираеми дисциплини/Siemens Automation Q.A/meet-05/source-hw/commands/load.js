function loadCommand(robotHandId) {
    
    const isApplicable =    robotHandId == 'A' || 
                            robotHandId == 'B' || 
                            robotHandId == 'C';

    if(!isApplicable) {
        return console.log("Не разполагате с подобно устройство");
    }

    if(SystemObject.hasActiveHand(robotHandId)) {
        return console.log("Не може да включите, нова ръка");
    }

    console.log(`Ръка ${robotHandId} е включена успешно`);
    SystemObject.setActiveHandId(robotHandId);
}