from django.contrib import admin
from base.models import Country, Author, Book

# Register your models here.

@admin.register(Country)
class CountryAdmin(admin.ModelAdmin):
    pass

@admin.register(Author)
class AuthorAdmin(admin.ModelAdmin):
    pass

@admin.register(Book)
class BookAdmin(admin.ModelAdmin):
    pass
