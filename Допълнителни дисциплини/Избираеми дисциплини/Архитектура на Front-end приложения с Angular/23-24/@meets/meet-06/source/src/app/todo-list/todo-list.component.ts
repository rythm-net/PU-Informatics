import { Component, inject } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { TodoTaskComponent } from "../todo-task/todo-task.component";
import { TodoListService } from "./todo-list.service";
import { TodoApiService } from "../services/todo.api";
import { CurrencyTransformPipe } from "./currency-transform.pipe";

@Component({
  selector    : 'app-todo-list',
  templateUrl : './todo-list.component.html',
  styleUrl    : './todo-list.component.css',
  standalone  : true,
  imports     : [FormsModule, TodoTaskComponent, CurrencyTransformPipe]
})
export class TodoListComponent {

  public todoInputValue = '';
  public taskCollection: any = [];

  public currencyCollection = ['USD', 'EUR', 'BGN', 'AUD']

  // губим данните които сме вкарали в него
  // private todoListService = new TodoListService();


  // Класически подход за работа с dependancy
  // private todoListService: TodoListService;

  // public constructor(todoListService: TodoListService) {
  //   this.todoListService = todoListService;
  // }

  // модерния подход v14 / v15
  private todoListService = inject(TodoListService)
  private todoApiService  = inject(TodoApiService)

  public async ngOnInit() {

    // async / await
    // this.todoApiService.getAllTodos().then((data: any) => {
    //   // Същото като предишното
    // })

    const todoCollection: any = await this.todoApiService.getAllTodos();

    for(const element of todoCollection.todos) {

      this.taskCollection.push({
        id    : element.id,
        task  : element.todo,
        status: this.todoListService.generateStatusBasedOnMath()
      });
    }



    // this.todoApiService.getAllTodos().subscribe((data: any) => {

    //   const todoCollection = data.todos;

    //   for(const element of todoCollection) {

    //     this.taskCollection.push({
    //       id    : element.id,
    //       task  : element.todo,
    //       status: this.todoListService.generateStatusBasedOnMath()
    //     });
    //   }
    // });
  }

  public processAddTask() {

    this.taskCollection.push({
      id      : this.taskCollection.length,
      task    : this.todoInputValue,
      status  : this.todoListService.generateStatusBasedOnMath()
    });
    this.todoInputValue = '';
  }

  public processStatusChange(task) {
    console.log(task);
    console.log(this.taskCollection);
  }

  public async processTodoSelect(todoItem) {

    const todoResult = await this.todoApiService.getSingleTodo(todoItem.id)
    console.log(todoResult);
  }
}
