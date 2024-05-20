from .models import Todo, TodoStatus
from .serializers import TodoSerializer

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
    