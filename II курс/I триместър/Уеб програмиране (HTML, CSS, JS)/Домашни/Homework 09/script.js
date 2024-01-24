function swapTiles(block1,block2) {
    var temp = document.getElementById(blckk1).className;
    document.getElementById(block1).className = document.getElementById(block2).className;
    document.getElementById(block2).className = temp;
  }
  
  function shuffle() {
  for (var row=1;row<=4;row++) { 
     for (var column=1;column<=4;column++) { 
    
      var row2=Math.floor(Math.random()*4 + 1); 
      var column2=Math.floor(Math.random()*4 + 1); 
       
      swapTiles("block"+row+column,"block"+row2+column2); 
    } 
  } 
  }
  
  function clickTile(row,column) {
    var block = document.getElementById("block"+row+column);
    var emptyBlock = block.className;
    if (emptyBlock!="block16") { 
         if (column<4) {
           if ( document.getElementById("block"+row+(column+1)).className=="block16") {
             swapTiles("block"+row+column,"block"+row+(column+1));
             return;
           }
         }
         if (column>1) {
           if ( document.getElementById("block"+row+(column-1)).className=="block16") {
             swapTiles("block"+row+column,"block"+row+(column-1));
             return;
           }
         }
         if (row>1) {
           if ( document.getElementById("block"+(row-1)+column).className=="block16") {
             swapTiles("block"+row+column,"block"+(row-1)+column);
             return;
           }
         }
         if (row<4) {
           if ( document.getElementById("block"+(row+1)+column).className=="block16") {
             swapTiles("block"+row+column,"block"+(row+1)+column);
             return;
           }
         } 
    }
    
  }
  