from django.db import models

# Create your models here.
class Todo(models.Model):
    task = models.CharField(max_length=200)
    created_time = models.DateTimeField(auto_now_add=True, auto_now=False, blank=False)
    updated_time = models.DateTimeField(auto_now=True, blank=False)
    completed = models.BooleanField()

    class Meta:
        db_table = "todo"
