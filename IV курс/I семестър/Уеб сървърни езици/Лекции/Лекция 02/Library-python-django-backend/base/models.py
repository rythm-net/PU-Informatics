from django.db import models
from base.utils import CategoriesEnum

class Country(models.Model):
    continent = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    class Meta:
        db_table = "country"

class Author(models.Model):
    name = models.CharField(max_length=255)
    surname = models.CharField(max_length=255)
    country = models.ForeignKey(Country, blank=False, null=False, on_delete=models.RESTRICT)

    class Meta:
        db_table = "author"

class Book(models.Model):
    name = models.CharField(max_length=255)
    available_copies = models.SmallIntegerField();
    category = models.SmallIntegerField(choices=CategoriesEnum.choices(), default=CategoriesEnum.NOVEL);
    author = models.ForeignKey(Author, blank=False, null=False, on_delete=models.RESTRICT)

    class Meta:
        db_table = "book"
