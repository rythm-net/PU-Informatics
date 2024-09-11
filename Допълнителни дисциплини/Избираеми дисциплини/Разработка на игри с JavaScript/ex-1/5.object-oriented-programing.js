// //  In classic OOP languages
// class Character {
//     public String name;
//     public int age;

//     public void move() {

//     }

//     public void jump() {

//     }
// }

// Character superMario = new Character();
// superMario.name = "Super Mario";
// superMario.age = 26;

// In java Script

var Character = {
    name    : 'Super Mario',
    age     : 26,
    move    : function() {
        console.log("Move forward") 
    },

    jump    : function() {
        console.log("Jump forward") 
    }
};

var CharacterFactory = function(inputFname, inputLname, inputAge) {

    return {
        fname   : inputFname,
        lname   : inputLname,
        age     : inputAge,
        move    : function() {
            console.log("Move forward");
        },

        jump    : function() {
            console.log("Jump forward");
        },

        fullName : function() {
            console.log("Hi My name is " + this.fname + " " + this.lname);
        }
    };
};

var superMario  = CharacterFactory("Super Mario", "Petrov", 26);
var luige       = CharacterFactory("Luige", "Vankov", 26);

superMario.fullName();
luige.fullName();



var CharacterConstructor = function(characterConfig) {
    
    this.fname  = characterConfig.fname;
    this.lname  = characterConfig.lname;
    this.age    = characterConfig.age;
};

// CharacterConstructor.prototype = {
//     fullName : function() {

//     },

//     move : function() {

//     }
// };

CharacterConstructor.prototype.fullName = function() {
    console.log(`Hi my name is ${this.fname} ${this.lname}`);
};

CharacterConstructor.prototype.move = function() {

};

var MasterCheef = new CharacterConstructor({
    fname   : 'Master Cheef',
    lname   : 'Marly',
    age     : 40
});

MasterCheef.fullName();

console.log("%%%");
for(var index in MasterCheef) {
    console.log(index);
    console.log(MasterCheef[index]);
}