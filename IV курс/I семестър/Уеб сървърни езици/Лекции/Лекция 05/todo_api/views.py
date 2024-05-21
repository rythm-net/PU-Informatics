from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .models import Todo
from .services import TodosService, UsersService
from rest_framework.authentication import SessionAuthentication, TokenAuthentication
from rest_framework.permissions import IsAuthenticated, AllowAny
from .serializers import UserSerializer

# Create your views here.
#from rest_framework.decorators import api_view
#@api_view(["GET"])
#def getAllTodos(request):
#    return Response()

class TodoListApiView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [IsAuthenticated]

    def get(self, request):
        return handleResponse(TodosService.getAllTodos())
    
    def post(self, request):
        return handleResponse(TodosService.createTodo(request))

class TodoDetailApiView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [IsAuthenticated]

    def get(self, request, todoId):
        return handleResponse(TodosService.getTodo(todoId))
    
    def put(self, request, todoId):
        return handleResponse(TodosService.updateTodo(todoId,request))
    
    def delete(self, request, todoId):
        return handleResponse(TodosService.delete(todoId))

class TodoMarkAsDoneApiView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [IsAuthenticated]

    def post(self, request, todoId):
        return handleResponse(TodosService.markAsDone(todoId))

class UserSignupView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [AllowAny]

    def post(self, request):
        return handleResponse(UsersService.signup(request))

class UserLoginView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [AllowAny]

    def post(self, request):
        return handleResponse(UsersService.login(request))

class UserLogoutView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [IsAuthenticated]

    def post(self, request):
        return handleResponse(UsersService.logout(request))

class TestLoginView(APIView):
    authentication_classes = [TokenAuthentication, SessionAuthentication]
    permission_classes = [IsAuthenticated]

    def get(self, request):
        user = request.user
        serializer = UserSerializer(instance = user)
        return handleResponse({"token": user.auth_token.key, "user": serializer.data})

def handleResponse(data):
    if isinstance(data, dict) and "error" in data.keys():
        return Response(data, status.HTTP_400_BAD_REQUEST)
    else:
        return Response(data, status.HTTP_200_OK)