package main

import (
	"errors"
	"fmt"
	"voting/voter"
)

// преименуване на типове
type voterFirstName string

const PoorPersonId = "POOR"
const RichPersonId = "RICH"
const NormalPersonId = "NORMAL"

func getVoterTypeByCardNumber(cardNumber int) (string, error) {

	if cardNumber >= 1 && cardNumber <= 100 {
		return PoorPersonId, nil
	}

	if cardNumber >= 101 && cardNumber <= 1000 {
		return NormalPersonId, nil
	}

	if cardNumber >= 1001 && cardNumber <= 2000 {
		return RichPersonId, nil
	}

	return "", errors.New("Card number is not valid")
}

func main() {

	// int, float, string, bool
	//var voterCardNumber = 55

	// var voterCardNumber int
	// voterCardNumber = 55

	var firstName string
	var familyName string

	voterCardNumber := 550
	voterType, _ := getVoterTypeByCardNumber(voterCardNumber)

	if voterType == "POOR" {

		// voter := voter.Voter{}

		fmt.Print("Как се казваш ?")
		fmt.Scan(&firstName)
		fmt.Print("Как e фамилното ти име ?")
		fmt.Scan(&familyName)

		// voter.FirstName = firstName
		// voter.FamilyName = familyName

		voter := voter.New(firstName, familyName)
		fmt.Print(voter.GetFullName())
	}

	// fmt.Print(voterType)
	// fmt.Print(cardNumber)

	// всички гласували днес
	var voterCollection = [5]voter.Voter{}
	voterCollection[0] = voter.New("Mihail", "Petrov")
	voterCollection[1] = voter.New("Ivan", "Ivanov")
	voterCollection[2] = voter.New("Sergei", "Danchev")
	voterCollection[3] = voter.New("Kaloian", "Stavrev")
	voterCollection[4] = voter.New("Petar", "Nachev")

	var manyVoterCollection = []voter.Voter{}
	manyVoterCollection = append(manyVoterCollection, voter.New("Petar", "Nachev"))
	manyVoterCollection = append(manyVoterCollection, voter.New("Petar", "Nachev"))
	manyVoterCollection = append(manyVoterCollection, voter.New("Petar", "Nachev"))
	manyVoterCollection = append(manyVoterCollection, voter.New("Petar", "Nachev"))

	for i := 0; i < len(manyVoterCollection); i++ {
		fmt.Println(manyVoterCollection[i].GetFullName())
	}

	for _, element := range manyVoterCollection {
		fmt.Println(element)
	}
}
