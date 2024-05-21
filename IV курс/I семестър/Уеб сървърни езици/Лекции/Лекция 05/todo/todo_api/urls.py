from django.urls import path
#from .views import getAllTodos
from .views import TodoListApiView, TodoDetailApiView, TodoMarkAsDoneApiView
from .views import UserSignupView, UserLoginView, UserLogoutView, TestLoginView

urlpatterns = [
    #path("api/todo", getAllTodos),
    path("api/todo", TodoListApiView.as_view()),
    path("api/todo/<int:todoId>", TodoDetailApiView.as_view()),
    path("api/todo/markAsDone/<int:todoId>", TodoMarkAsDoneApiView.as_view()),
    path("api/auth/signup", UserSignupView.as_view()),
    path("api/auth/login", UserLoginView.as_view()),
    path("api/auth/logout", UserLogoutView.as_view()),
    path("api/test_login", TestLoginView.as_view()),
]