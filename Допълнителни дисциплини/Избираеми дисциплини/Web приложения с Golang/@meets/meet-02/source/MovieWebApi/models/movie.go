package models

import "MovieWebApi/db"

type Movie struct {
	Id      int64
	Title   string
	Rating  int
	Release int
}

var movieCollection []Movie

func (m *Movie) Save() error {

	statment, err := db.GetDb().Prepare(`
		INSERT INTO 
		movies
		    (title, rating, release)
		VALUES
		    (?, ?, ?)
	`)

	defer statment.Close()

	if err != nil {
		return err
	}

	result, err := statment.Exec(m.Title, m.Rating, m.Release)
	if err != nil {
		return err
	}

	movieId, err := result.LastInsertId()
	m.Id = movieId

	return err
}

func GetAllMovies() ([]Movie, error) {

	dbCursor, err := db.GetDb().Query(`SELECT * FROM movies`)
	if err != nil {
		return nil, err
	}

	for dbCursor.Next() {

		var movieObject Movie
		err := dbCursor.Scan(
			&movieObject.Id,
			&movieObject.Title,
			&movieObject.Rating,
			&movieObject.Release,
		)

		if err != nil {
			return nil, err
		}

		movieCollection = append(movieCollection, movieObject)
	}

	return movieCollection, nil
}
