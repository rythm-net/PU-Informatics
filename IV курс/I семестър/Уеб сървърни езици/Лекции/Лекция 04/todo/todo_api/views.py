from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .models import Todo
from .services import TodosService


# Create your views here.
#from rest_framework.decorators import api_view
#@api_view(["GET"])
#def getAllTodos(request):
#    return Response()

class TodoListApiView(APIView):
    def get(self, request):
        return handleResponse(TodosService.getAllTodos())
    
    def post(self, request):
        return handleResponse(TodosService.createTodo(request))

class TodoDetailApiView(APIView):
    def get(self, request, todoId):
        return handleResponse(TodosService.getTodo(todoId))

class TodoMarkAsDoneApiView(APIView):
    def post(self, request, todoId):
        return handleResponse(TodosService.markAsDone(todoId))

def handleResponse(data):
    if isinstance(data, dict) and "error" in data.keys():
        return Response(data, status.HTTP_400_BAD_REQUEST)
    else:
        return Response(data, status.HTTP_200_OK)