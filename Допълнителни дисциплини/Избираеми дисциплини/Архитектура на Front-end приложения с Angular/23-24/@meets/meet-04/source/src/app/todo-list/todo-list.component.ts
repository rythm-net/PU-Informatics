import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { TodoTaskComponent } from "../todo-task/todo-task.component";

@Component({
  selector    : 'app-todo-list',
  templateUrl : './todo-list.component.html',
  styleUrl    : './todo-list.component.css',
  standalone  : true,
  imports     : [FormsModule, TodoTaskComponent]
})
export class TodoListComponent {

  public todoInputValue = '';
  public taskCollection: any = [];

  public ngOnInit() {

    this.taskCollection.push({
      id    : 0,
      task  : 'Initial task',
      status: 'todo'
    });
  }

  public processAddTask() {

    this.taskCollection.push({
      id      : this.taskCollection.length,
      task    : this.todoInputValue,
      status  : 'todo'
    });
    this.todoInputValue = '';
  }

  public processStatusChange(task) {
    console.log(task);
    console.log(this.taskCollection);
  }
}
