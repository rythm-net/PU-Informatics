from django.contrib import admin
from base.models import Item

# Register your models here.

@admin.register(Item)
class ItemAdmin(admin.ModelAdmin):
    pass
