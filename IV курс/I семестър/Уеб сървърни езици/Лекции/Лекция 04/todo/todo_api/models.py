from django.db import models

# Create your models here.
class TodoStatus(models.IntegerChoices):
    NOT_STARTED = 1, "Not started"
    IN_PROGRESS = 2, "In progress"
    DONE = 3, "Done"

class Role(models.Model):
    name = models.CharField(max_length=100)

    class Meta:
        db_table = "role"

class TeamMember(models.Model):
    name = models.CharField(max_length=100)
    roles = models.ManyToManyField(Role)

    class Meta:
        db_table = "teamMember"

class Todo(models.Model):
    task = models.CharField(max_length=200)
    createdTime = models.DateTimeField(auto_now_add=True, auto_now=False, blank=False)
    updatedTime = models.DateTimeField(auto_now=True, blank=False)
    description = models.TextField(default="")
    teamMember = models.ForeignKey(TeamMember, on_delete=models.CASCADE)
    nextTodo = models.ForeignKey("Todo", blank=True, null=True, on_delete=models.RESTRICT)
    todoStatus = models.IntegerField(choices=TodoStatus.choices, default=TodoStatus.NOT_STARTED)

    class Meta:
        db_table = "todo"
