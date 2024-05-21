from rest_framework import serializers
from .models import Todo
from django.contrib.auth.models import User

class TodoSerializer(serializers.ModelSerializer):
    #additionaField = serializers.IntegerField()
    class Meta:
        model = Todo
        #fields = "__ALL__"
        fields = ["id", "task", "description", "createdTime", "updatedTime", "teamMember", "todoStatus", "nextTodo"]

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ["username", "password", "email"]