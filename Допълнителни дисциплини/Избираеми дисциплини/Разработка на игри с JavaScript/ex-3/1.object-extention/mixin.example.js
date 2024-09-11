// Mixin object 1
var LevelUp = {

    fireBlast : function() {
        console.log("Fireeeeeeeeeee");
    }
};

// Mixin object 2
var HeavyWarrior = {
    heavyHit : function() {
        console.log('Heavy hittttttt');
    }
};


var BaseWarrior = {
    hit : function() {
        console.log('Hit');
    }
};

// Basic mix 
BaseWarrior.heavyHit = HeavyWarrior.heavyHit;
console.log(BaseWarrior);
BaseWarrior.hit()
BaseWarrior.heavyHit()

for(var index in LevelUp) {
    BaseWarrior[index] = LevelUp[index];
}

BaseWarrior.fireBlast();


var mix = function(mixinObject) {
    
    for(var index in mixinObject.with) {
        mixinObject.what[index] = mixinObject.with[index];
    }   
};

mix({
    what : BaseWarrior,
    with : LevelUp
})