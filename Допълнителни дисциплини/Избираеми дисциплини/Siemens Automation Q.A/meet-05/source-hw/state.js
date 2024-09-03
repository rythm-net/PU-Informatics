const SystemObject = {
    gassCount: 90,
    oxigenCount: 168,
    filledHoles : 0,
    isSystemTurnOn : false,
    activeHandId: null,

    setActiveHandId(handId) {
        SystemObject.activeHandId = handId;
    },

    hasActiveHand(handId) {

        if(SystemObject.activeHandId == null) {
            return false;
        }

        if(SystemObject.activeHandId == handId) {
            return false;
        }

        return true;
    },

    isTurnOn() {
        return SystemObject.isSystemTurnOn;
    },

    isTurnOff() {
        return !SystemObject.isTurnOn();
    },

    turnOn() {
        SystemObject.isSystemTurnOn = true;
    },

    turnOff() {
        SystemObject.isSystemTurnOn = false;
    },

    isAlive() {
        return  SystemObject.gassCount > 0 &&
                SystemObject.oxigenCount > 24
    }
}