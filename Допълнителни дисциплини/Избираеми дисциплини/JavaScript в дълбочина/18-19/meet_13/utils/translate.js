const translate = (lang, code) => {

    const TRANSLATE_COLLECTION = {

        "SUCCESS" : {
            "bg" : "Заявката е успешно съхранена",
            "en" : "Success stored in database"
        },

        "ERROR" : {
            "bg" : "Нещо много се обърка",
            "en" : "Something whent wrong"
        },
        
        "API_BOOKS_FETCH_SUCCESS" : {
            "bg" : "Книгата е успешно намерена",
            "en" : "Book collection is fetched succefuly"
        },

        "API_BOOKS_FETCH_ERROR" : {
            "bg" : "Няма книги, сори",
            "en" : "No books go home"
        }
    };

    const DEFAULT_CODE = {
        "bg" : "Няма транслейт за това съобщение",
        "en" : "No available translations for this code"        
    }

    if(!TRANSLATE_COLLECTION[code]) {
        return (DEFAULT_CODE[lang]) ? DEFAULT_CODE[lang] : DEFAULT_CODE['en'];
    }

    // If no translate key found --> return message NO TRANSLATE KEY FOUND
    return TRANSLATE_COLLECTION[code][lang] ? TRANSLATE_COLLECTION[code][lang] : TRANSLATE_COLLECTION[code]['en'];
}

module.exports = translate;