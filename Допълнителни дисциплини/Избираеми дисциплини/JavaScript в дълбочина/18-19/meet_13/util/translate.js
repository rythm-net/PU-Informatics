const translate = (lang, code) => {

    const TRANSLATE_COLLECTION = {

        "SUCCESS" : {
            "bg" : "Заявката е успешно съхранена",
            "en" : "Success stored in database"
        },

        "ERROR" : {
            "bg" : "Нещо много се обърка",
            "en" : "Something whent wrong"
        }        
    }

    return TRANSLATE_COLLECTION[code][lang];
}


module.exports = translate;