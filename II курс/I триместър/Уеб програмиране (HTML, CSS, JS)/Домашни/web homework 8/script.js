
function calculatingVAT(){
    let profits= document.getElementById('profit').value;
    let expenses=document.getElementById('expense').value;
    var overall= profits-expenses;
    var VAT=overall*0.2;
    var overallProfit=overall-VAT;

    document.getElementById('taxes').value=VAT;
    document.getElementById('overallProfit').value=overallProfit;
}

function onMounthChange(){
    document.getElementById('profit').value="";
    document.getElementById('expense').value="";
    document.getElementById('overallProfit').value="";
    document.getElementById('taxes').value="";
}