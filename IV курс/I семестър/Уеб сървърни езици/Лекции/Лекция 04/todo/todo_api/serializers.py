from rest_framework import serializers
from .models import Todo

class TodoSerializer(serializers.ModelSerializer):
    #additionaField = serializers.IntegerField()
    class Meta:
        model = Todo
        #fields = "__ALL__"
        fields = ["task", "description", "createdTime", "updatedTime", "teamMember", "todoStatus", "nextTodo"]