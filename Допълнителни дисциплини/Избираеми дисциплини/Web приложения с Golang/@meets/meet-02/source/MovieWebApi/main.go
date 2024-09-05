package main

import (
	"MovieWebApi/db"
	"MovieWebApi/models"
	"fmt"
	"github.com/gin-gonic/gin"
)

type Response map[string]any

func main() {

	db.Init()

	// всички HTTP глаголи
	app := gin.Default()

	app.GET("/movies", func(context *gin.Context) {
		fmt.Println("Hello Movie")

		// масив
		// collection [5]string
		// collection :=   [5]string{"A", "B", "C", ""D}

		// слаис - масив без предварително дефиниран размер
		// collection []string

		// мап - речник - ключ, стойност колекция
		// mapCollection map[string]string
		// mapCollection := map[string]string{ "key": "value" }

		result, err := models.GetAllMovies()
		if err != nil {
			context.JSON(400, Response{
				"message": "Cannot serve your request",
			})
			return
		}

		context.JSON(200, Response{
			"message": "All movies in the database",
			"movies":  result,
		})
	})

	app.POST("/movies", func(context *gin.Context) {

		var movieObject models.Movie
		err := context.ShouldBindJSON(&movieObject)
		if err != nil {
			context.JSON(400, Response{
				"message": "Invalid object",
			})
			return
		}
		// movieObject.Id = 1
		err = movieObject.Save()

		if err != nil {
			context.JSON(400, Response{
				"message": "Cannot insert movie object",
			})
			return
		}

		context.JSON(200, Response{
			"message": "Movie created successfuly",
			"object":  movieObject,
		})
	})

	err := app.Run(":8087")
	if err != nil {
		fmt.Println("SERVER exception")
		fmt.Println(err)
	}
}
