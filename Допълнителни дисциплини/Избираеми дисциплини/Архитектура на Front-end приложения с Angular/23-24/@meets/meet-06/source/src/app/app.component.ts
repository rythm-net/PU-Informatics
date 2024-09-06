import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { TodoListComponent } from './todo-list/todo-list.component';
@Component({
  selector    : 'app-root',
  standalone  : true,
  imports     : [
    RouterOutlet,
    FormsModule,
    CommonModule,
    TodoListComponent
  ],
  templateUrl : './app.component.html',
  styleUrl    : './app.component.css'
})
export class AppComponent {

}
