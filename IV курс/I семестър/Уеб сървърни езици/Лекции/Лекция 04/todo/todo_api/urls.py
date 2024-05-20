from django.urls import path
#from .views import getAllTodos
from .views import TodoListApiView, TodoDetailApiView, TodoMarkAsDoneApiView

urlpatterns = [
    #path("api/todo", getAllTodos),
    path("api/todo", TodoListApiView.as_view()),
    path("api/todo/<int:todoId>", TodoDetailApiView.as_view()),
    path("api/todo/markAsDone/<int:todoId>", TodoMarkAsDoneApiView.as_view())
]