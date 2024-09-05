package voter

func New(firstName string, lastName string) Voter {
	return Voter{
		FirstName:  firstName,
		FamilyName: lastName,
	}
}

// собствен тип данни
type Voter struct {
	FirstName  string
	FamilyName string
}

func (voterReference Voter) GetFullName() string {
	return voterReference.FirstName + " " + voterReference.FamilyName
}
