from rest_framework import serializers
from base.models import Author, Book

class AuthorSerializer(serializers.ModelSerializer):
     class Meta:
        model = Author
        fields = "__all__"

class BookSerializer(serializers.ModelSerializer):
     availableCopies = serializers.IntegerField(source='available_copies')
     class Meta:
        model = Book
        fields = "__all__"
