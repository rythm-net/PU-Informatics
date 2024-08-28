var Util = {};

// * 
Util.maintanens = {};
Util.maintanens.initValueOfSequanceGenerator = 1;
Util.maintanens.generateId = function() {
    return this.initValueOfSequanceGenerator++;
}
