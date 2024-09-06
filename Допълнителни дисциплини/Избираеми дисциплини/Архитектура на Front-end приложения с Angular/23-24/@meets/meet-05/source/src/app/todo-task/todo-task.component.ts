import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from "@angular/core";

@Component({
  selector    : 'app-todo-task',
  templateUrl : './todo-task.component.html',
  styleUrl    : './todo-task.component.css',
  standalone  : true
})
export class TodoTaskComponent implements OnInit, OnChanges {
  // От къде ще дойде тази информация ???

  @Input() public inputTask;

  @Input() public inputStatus;

  @Input() public inputTaskObject;

  @Output() public onStatusChange = new EventEmitter();

  public processStatus(statusCode) {

    this.inputTaskObject.status = statusCode;
    this.onStatusChange.emit(this.inputTaskObject);
  }

  public getClassByStatus(status) {

    if(status == 'todo') return 'todo';
    if(status == 'doing') return 'doing';
    return 'done';
  }

  public ngOnInit() {
    console.log("TaskCOmponent INIT");
  }

  public ngOnChanges() {
    console.log("TaskCOmponent changed");
  }
}
