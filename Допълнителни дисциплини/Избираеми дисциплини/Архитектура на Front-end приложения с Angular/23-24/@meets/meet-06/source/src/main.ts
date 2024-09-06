import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { TodoListComponent } from './app/todo-list/todo-list.component';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    provideRouter([
      {
        path      : 'todo',
        component : TodoListComponent
    }
  ])
  ]
})
  .catch((err) => console.error(err));
