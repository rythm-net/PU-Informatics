// -- какво ще тестваме - тестовата сюита
function describe(message, callback) {
    console.log(message);
    console.group();
    callback();
    console.groupEnd();
}

// -- какъв ще е фактическия тест
function it(message, testScenario) { // test
    console.log(message);
    testScenario();
}

function get(locator) {
    return document.getElementById(locator);
}

const assert = {
    isEquals(actualValue, expectedValue) {

        if(actualValue == expectedValue) {
            console.info("SUCCESS");
        }
        else {
            console.error(`FAIL - current value ${actualValue} expected ${expectedValue}`);
        }
    }
}