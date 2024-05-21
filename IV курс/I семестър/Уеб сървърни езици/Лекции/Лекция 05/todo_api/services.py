from .models import Todo, TodoStatus
from .serializers import TodoSerializer, UserSerializer
from django.contrib.auth.models import User
from django.core.exceptions import ObjectDoesNotExist
from rest_framework.authtoken.models import Token

class TodosService:
    @staticmethod
    def getAllTodos():
        todos = Todo.objects.all()
        serializer = TodoSerializer(todos, many=True)
        return serializer.data

    @staticmethod
    def getTodo(todoId):
        todo = getTodoById(todoId)
        if todo:
            serializer = TodoSerializer(todo)
            return serializer.data
        else:
            return {"error": "Cannot find object with id " + str(todoId)}

    @staticmethod
    def createTodo(request):
        data = {
            "task": request.data.get("task"),
            "description": request.data.get("description"),
            "teamMember": request.data.get("teamMember"),
            "nextTodo": None
        }
        #if first todo for the team member, create it directly
        #in progress status
        teamMemberTodos = Todo.objects.filter(teamMember=data["teamMember"]).order_by("createdTime")
        todoCount = teamMemberTodos.count()
        todoStatus = TodoStatus.NOT_STARTED
        if todoCount==0:
            todoStatus = TodoStatus.IN_PROGRESS
        data["todoStatus"] = todoStatus
        serializer = TodoSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            teamMemberTodos = Todo.objects.filter(teamMember=data["teamMember"]).order_by("createdTime")    
            if (todoCount > 0):
                lastTodo = teamMemberTodos[len(teamMemberTodos) - 2]
                data2 = {
                    "nextTodo": teamMemberTodos.last().id
                }
                lastTodoSerializer = TodoSerializer(instance = lastTodo, data = data2, partial=True)
                if lastTodoSerializer.is_valid():
                    lastTodoSerializer.save()

            return serializer.data
        else:
            return {"error": "Invalid data"}
    @staticmethod
    def updateTodo(todoId, request):
        todo = getTodoById(todoId)
        if todo:
            data = {
                "task": request.data["task"],
                "description": request.data["description"]
            }
            serializer = TodoSerializer(instance=todo, data=data, partial=True)
            #similar as below. will validate and if issues will raise 404 exception
            #serializer.is_valid(raise_exception=True)
            if serializer.is_valid():
                serializer.save()
                return serializer.data
            else:
                return {"error": "invalid data"}
        return {"error": "Cannot find todo with id " + str(todoId)}

    @staticmethod
    def delete(todoId):
        todo = getTodoById(todoId)
        if not todo:
            return {"error": "Cannot find todo with id " + str(todoId)}
        try:
            prevTodo = Todo.objects.get(nextTodo=todoId)
        except Todo.DoesNotExist:
            prevTodo = None
        if prevTodo:
            data = {
                "nextTodo": getattr(todo, "nextTodo_id")
            }
            print(data)
            serializer = TodoSerializer(instance=prevTodo, data=data, partial=True)
            if serializer.is_valid():
                serializer.save()
            else:
                return {"error": "Invalid data"}
        todo.delete()
        return {"success": "Todo with id " + str(todoId) + " was deleted successfuly"}

    @staticmethod
    def markAsDone(todoId):
        todo = getTodoById(todoId)
        if todo:
            data = {
                "todoStatus": TodoStatus.DONE
            }
            serializer = TodoSerializer(instance = todo, data = data, partial=True)
            if serializer.is_valid():
                serializer.save()
                nextTodo = getTodoById(serializer.data["nextTodo"])
                data = {
                    "todoStatus": TodoStatus.IN_PROGRESS
                }
                serializer = TodoSerializer(instance = nextTodo, data = data, partial=True)
                if serializer.is_valid():
                    serializer.save()

                return {"success": "Todo marked as done!"}
            else:
                return {"error": "wrong data"}
        return {"error": "Cannot find object with id " + str(todoId)}
#helper method to extract todo by id
#return None if doesn't exist
def getTodoById(todoId):
    try:
        return Todo.objects.get(id=todoId)
    except Todo.DoesNotExist:
        return None

class UsersService:
    @staticmethod
    def signup(request):
        data = request.data
        #validate user
        if User.objects.filter(username=data["username"]).exists():
            return {"error": "User already exists"}

        if User.objects.filter(email=data["email"]).exists():
            return {"error": "Another user exist with email " + data["email"]}
    
        if not "password_check" in data or data["password"] != data["password_check"]:
            return {"error": "Passwords do not match"}

        if len(data["password"])<8:
            return {"error": "Please provide password with minimum 8 chars"}
        
        serializer = UserSerializer(data = data)
        if serializer.is_valid():
            serializer.save()
            user = User.objects.get(username=serializer.data["username"])
            user.set_password(data["password"])
            user.save()
            serializer = UserSerializer(instance = user)
            token = Token.objects.create(user=user)
            return {"token": token.key, "user": serializer.data}
        return {"error": serializer.errors}
    @staticmethod
    def login(request):
        username = request.data["username"]
        password = request.data["password"]
        try:
            user = User.objects.get(username=username)
        except User.DoesNotExist:
            return {"error": "Wrong user or password"}
        if not user.check_password(password):
            return {"erorr": "Wrong user or password"}
        token, _ = Token.objects.get_or_create(user=user)
        serializer = UserSerializer(instance = user)
        return {"token": token.key, "user": serializer.data}

    @staticmethod
    def logout(request):
        try:
            request.user.auth_token.delete()
        except (AttributeError, ObjectDoesNotExist):
            pass
        return {"success": "successful logout"}